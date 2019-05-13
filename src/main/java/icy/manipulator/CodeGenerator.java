/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import javax.annotation.processing.Generated;

import icy.manipulator.model.MethodDefinition;
import icy.manipulator.model.ModelDefinition;
import icy.manipulator.model.PropertyDefinition;
import icy.manipulator.model.Synthesizer;
import icy.manipulator.util.Lists;
import icy.manipulator.util.Strings;

public class CodeGenerator {

    /** The prefix of assignable type. */
    public static final String Assignable = "Åssignable";

    /** The aggregated assignable interface name. */
    public static final String AssignableAll = Assignable + "All";

    /** The instantiator class name. */
    public static final String Instantiator = "Ìnstantiator";

    /** The configuration interface name for arbitrary perperties. */
    public static final String ArbitraryInterface = Assignable + "Årbitrary";

    /** The current procesing model. */
    private final ModelDefinition m;

    /** The {@link Icy} info on the model class. */
    private final Icy icy;

    /** The actual coder. */
    private final Coder code = new Coder(IcyManipulator.importer);

    /**
     * Create code analyzer.
     * 
     * @param root
     * @param elements
     */
    CodeGenerator(ModelDefinition model) {
        this.icy = model.e.getAnnotation(Icy.class);
        this.m = model;

        System.out.println(model);
    }

    /**
     * Generate source code.
     * 
     * @return
     */
    String generate() {
        String visibility = icy.packagePrivate() ? "" : "public ";

        code.write("/**");
        code.write(" * Generated model for {@link ", m.type, "}.");
        code.write(" */");
        code.write("@", Generated.class, "(`Icy Manipulator`)");
        code.write(visibility, "abstract class ", m.implType, " extends ", m.type, () -> {
            if (m.hasOverload() || m.hasIntercept()) {
                defineMethodInvokerBuilder();
                defineMethodInvoker();
            }
            defineFiledUpdaterBuilder();
            defineFieldUpdater();
            defineField();
            defineConstructor();
            defineAccessors();
            defineBuilder();
            defineAssignableInterfaces();
            defineAssignableArbitrary();
            defineAssignableAll();
            defineMutableClass();
            definePropertyEnum();
        });
        return code.toCode();
    }

    /**
     * Define query method for property updater.
     */
    private void defineMethodInvokerBuilder() {
        code.write();
        code.write("/**");
        code.write(" * Create special method invoker.");
        code.write(" *");
        code.write(" * @param name A target method name.");
        code.write(" * @param parameterTypes A list of method parameter types.");
        code.write(" * @return A special method invoker.");
        code.write(" */");
        code.write("private static final ", MethodHandle.class, " invoker(String name, Class... parameterTypes) ", () -> {
            code.writeTry(() -> {
                code.write(java.lang.reflect.Method.class, " method = ", m.type, ".class.getDeclaredMethod(name, parameterTypes);");
                code.write("method.setAccessible(true);");
                code.write("return ", MethodHandles.class, ".lookup().unreflect(method);");
            }, Throwable.class, e -> {
                code.write("throw new Error(", e, ");");
            });
        });
    }

    /**
     * Define property updater.
     */
    private void defineMethodInvoker() {
        for (PropertyDefinition property : m.ownProperties()) {
            for (MethodDefinition method : Lists.merge(m.findOverloadsFor(property), m.findInterceptsFor(property))) {
                StringJoiner types = new StringJoiner(", ", ", ", "").setEmptyValue("");
                method.paramTypes.forEach(t -> types.add(code.classLiteral(t)));

                code.write();
                code.write("/** The overload or intercept method invoker. */");
                code.write("private static final ", MethodHandle.class, " ", method.id(), "= invoker(`", method.name, "`", types, ");");
            }
        }
    }

    /**
     * Define query method for property updater.
     */
    private void defineFiledUpdaterBuilder() {
        code.write();
        code.write("/**");
        code.write(" * Create special property updater.");
        code.write(" *");
        code.write(" * @param name A target property name.");
        code.write(" * @return A special property updater.");
        code.write(" */");
        code.write("private static final ", MethodHandle.class, " updater(String name) ", () -> {
            code.writeTry(() -> {
                code.write(Field.class, " field = ", m.implType, ".class.getDeclaredField(name);");
                code.write("field.setAccessible(true);");
                code.write("return ", MethodHandles.class, ".lookup().unreflectSetter(field);");
            }, Throwable.class, e -> {
                code.write("throw new Error(", e, ");");
            });
        });
    }

    /**
     * Define property updater.
     */
    private void defineFieldUpdater() {
        for (PropertyDefinition property : m.ownProperties()) {
            code.write();
            code.write("/** The final property updater. */");
            code.write("private static final ", MethodHandle.class, " ", property.name, "Updater = updater(`", property.name, "`);");
        }
    }

    /**
     * Define property field.
     */
    private void defineField() {
        for (PropertyDefinition property : m.ownProperties()) {
            code.write();
            code.write("/** The exposed property. */");
            code.write("public ", property.mutable ? "" : "final ", property.type, " ", property.name, ";");
        }
    }

    /**
     * Define constructor.
     */
    private void defineConstructor() {
        code.write();
        code.write("/**");
        code.write(" * HIDE CONSTRUCTOR");
        code.write(" */");
        code.write("protected ", m.implType, "()", () -> {
            // initialize field
            for (PropertyDefinition p : m.ownProperties()) {
                code.write("this.", p.name, " = ", (p.isArbitrary ? "super." + p.name + "()" : p.type.defaultValue()), ";");
            }
        });
    }

    /**
     * Define property getter methods.
     */
    private void defineAccessors() {
        for (PropertyDefinition property : m.ownProperties()) {
            // Exposed getter
            code.write();
            code.write("/**");
            code.write(" * Retrieve ", property.name, " property.");
            code.write(" */");
            code.write("@Override");
            code.write("public final ", property.type, " ", property.name, "()", () -> {
                code.write("return this.", property.name, ";");
            });

            // Hidden classic getter
            code.write();
            code.write("/**");
            code.write(" * Provide classic getter API.");
            code.write(" */");
            code.write("@SuppressWarnings(`unused`)");
            code.write("private final ", property.type, " get", property.capitalizeName(), "()", () -> {
                code.write("return this.", property.name, ";");
            });

            // Hidden classic setter
            code.write();
            code.write("/**");
            code.write(" * Provide classic setter API.");
            code.write(" */");
            code.write("@SuppressWarnings(`unused`)");
            code.write(icy.classicSetterModifier().trim(), " void set", property.capitalizeName(), "(", property.type, " value)", () -> {
                code.write("((", property.assignableInterfaceName(), ") this).", property.name, "(value);");
            });
        }
    }

    /**
     * Defien model builder methods.
     */
    private void defineBuilder() {
        String builder = icy.builder();

        code.write();
        code.write("/** The singleton builder. */");
        code.write("public static final  ", Instantiator, "<?> ", builder, " = new ", Instantiator, "();");

        code.write();
        code.write("/**");
        code.write(" * Builder namespace for {@link ", m.implType, "}.");
        code.write(" */");
        code.write("public static final class ", Instantiator, "<Self extends ", m.implType.className, " & ", ArbitraryInterface, "<Self>>", () -> {
            m.firstRequiredProperty().ifPresentOrElse(p -> {
                int group = icy.grouping();
                List<PropertyDefinition> requireds = m.requiredProperties().subList(0, group);

                requireds.stream()
                        .map(def -> new Synthesizer(m, def))
                        .reduce((prev, next) -> prev.synthesize(next))
                        .ifPresent(synthesizer -> {
                            for (MethodDefinition method : synthesizer.methods) {
                                code.write("/**");
                                code.write(" * Create uninitialized {@link ", m.implType, "}.");
                                code.write(" */");
                                code.write("public final <T extends ", m.requiredRouteType(group, "Self"), "> T ", method, () -> {
                                    code.write(Assignable, " o = new ", Assignable, "();");

                                    boolean skipFirst = requireds.size() != method.paramNames.size();
                                    int parameterIndex = skipFirst ? -1 : 0;
                                    int index = 0;

                                    for (; index < requireds.size(); index++, parameterIndex++) {
                                        String methodName = index == 0 ? method.name : requireds.get(index).name;

                                        if (0 <= parameterIndex) {
                                            code.write("o.", methodName, "(", method.paramNames.get(parameterIndex), ");");
                                        } else {
                                            code.write("o.", methodName, "();");
                                        }
                                    }
                                    code.write("return (T) o;");
                                });
                            }
                        });
            }, () -> {
                // =========================================
                // No Required Property
                // =========================================
                code.write("/**");
                code.write(" * Create uninitialized {@link ", m.implType, "}.");
                code.write(" */");
                code.write("public final Self create()", () -> {
                    code.write("return (Self) new ", Assignable, "();");
                });
            });
        });
    }

    /**
     * Define mutable model class.
     */
    private void defineMutableClass() {
        code.write();
        code.write("/**");
        code.write(" * Mutable Model.");
        code.write(" */");
        code.write("private static final class ", Assignable, m.implType.variable, " extends ", m.implType, " implements ", AssignableAll, ", ", ArbitraryInterface, () -> {
        });
    }

    /**
     * Define assignable interfaces.
     */
    private void defineAssignableInterfaces() {
        for (PropertyDefinition p : m.ownRequiredProperties()) {
            code.write();
            code.write("/**");
            code.write(" * Property assignment API.");
            code.write(" */");
            code.write("public static interface ", p.assignableInterfaceName(), "<Next>", () -> {
                defineAssignableSetter(p);
            });
        }
    }

    /**
     * Define assignable interfaces.
     */
    private void defineAssignableArbitrary() {
        Optional<String> extend = m.findNearestArbitraryModel().map(m -> " extends " + m.implType + "." + ArbitraryInterface + "<Next>");
        code.write();
        code.write("/**");
        code.write(" * Property assignment API.");
        code.write(" */");
        code.write("public static interface ", ArbitraryInterface, "<Next extends ", m.implType, ">", extend, () -> {
            m.ownArbitraryProperties().forEach(this::defineAssignableSetter);
        });
    }

    /**
     * Define assignable setter.
     * 
     * @param p
     */
    private void defineAssignableSetter(PropertyDefinition p) {
        // =========================================
        // Base Setter
        // =========================================
        code.write("/**");
        code.write(" * The base setter.");
        code.write(" */");
        code.write("default Next ", p.name, "(", p.type, " value)", () -> {
            code.writeTry(() -> {
                String value = "value";
                for (MethodDefinition method : m.findInterceptsFor(p)) {
                    if (method.paramTypes.size() == 1) {
                        value = method.id() + ".invoke(this, " + value + ")";
                    } else {
                        value = method.id() + ".invoke(this, " + value;
                        for (int i = 1; i < method.paramTypes.size(); i++) {
                            PropertyDefinition target = m.findPropertyByName(method.paramNames.get(i));
                            value = value + ", " + "(Consumer<" + target.type
                                    .wrap().className + ">) ((" + Assignable + ") this)::" + target.name;
                        }
                        value = value + ")";
                    }
                }
                code.write(p.name, "Updater.invoke(this, ", value, ");");
            }, Throwable.class, e -> {
                code.write("throw new Error(", e, ");");
            });
            code.write("return (Next) this;");
        });

        // =========================================
        // Overload Setter
        // =========================================
        for (MethodDefinition m : m.findOverloadsFor(p)) {
            code.write();
            code.write("/**");
            code.write(" * The overload setter.");
            code.write(" */");
            code.write("default Next ", m, () -> {
                code.writeTry(() -> {
                    code.write("return ", p.name, "((", m.returnType, ") ", m.id(), ".invoke(", m.namesWithHead("this"), "));");
                }, Throwable.class, e -> {
                    code.write("throw new Error(", e, ");");
                });
            });
        }

        // =========================================
        // Auto-Expanded Overload Setter
        // =========================================
        if (p.autoExpandable) {
            for (String name : TypeUtil.enumConstantNames(p.element.getReturnType())) {
                code.write();
                code.write("/**");
                code.write(" * The overload setter.");
                code.write(" */");
                code.write("default Next ", Strings.decapitalize(name), "()", () -> {
                    code.write("return ", p.name, "(", p.type, ".", name, ");");
                });
            }
        }
    }

    /**
     * Define assignable interfaces.
     */
    private void defineAssignableAll() {
        StringJoiner apis = new StringJoiner(", ", " extends ", "").setEmptyValue("");
        for (PropertyDefinition property : m.ownRequiredProperties()) {
            apis.add(property.assignableInterfaceName());
        }
        if (m.hasParent()) {
            apis.add(m.parent.get().implType + "." + AssignableAll);
        }

        code.write();
        code.write("/**");
        code.write(" * Internal aggregated API.");
        code.write(" */");
        code.write("protected static interface ", AssignableAll, apis, () -> {
        });
    }

    /**
     * Define property identity.
     */
    private void definePropertyEnum() {
        code.write();
        code.write("/**");
        code.write(" * The identifier for properties.");
        code.write(" */");
        code.write("static final class My", () -> {
            for (PropertyDefinition property : m.ownProperties()) {
                code.write("static final String ", property.capitalizeName(), " = \"", property.name, "\";");
            }
        });
    }
}
