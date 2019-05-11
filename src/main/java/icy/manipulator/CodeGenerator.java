/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.StringJoiner;

import javax.annotation.processing.Generated;

import icy.manipulator.model.Method;
import icy.manipulator.model.ModelDefinition;
import icy.manipulator.model.PropertyDefinition;

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

    private final Type parent;

    /**
     * Create code analyzer.
     * 
     * @param root
     * @param elements
     */
    CodeGenerator(ModelDefinition model) {
        this.icy = model.e.getAnnotation(Icy.class);
        this.m = model;
        this.parent = m.parent.map(p -> p.implType).orElse(null);

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
            if (m.hasOverload()) {
                defineMethodInvokerBuilder();
                defineOverloadMethodInvoker();
            }
            defineFiledUpdaterBuilder();
            defineFieldUpdater();
            defineField();
            defineConstructor();
            defineAccessors();
            defineBuilder();
            defineAssignableInterfaces();
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
        code.write("private static final ", MethodHandle.class, " updater(String name, Class... parameterTypes) ", () -> {
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
    private void defineOverloadMethodInvoker() {
        for (PropertyDefinition property : m.ownProperties()) {
            for (Method method : m.findOverloadsFor(property)) {
                StringJoiner types = new StringJoiner(", ", ", ", "").setEmptyValue("");
                method.paramTypes.forEach(t -> types.add(code.use(t) + ".class"));

                code.write();
                code.write("/** The overload method invoker. */");
                code.write("private static final ", MethodHandle.class, " ", method.id, "= updater(\"", method.name, "\"", types, ");");
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
            code.write("private static final ", MethodHandle.class, " ", property.name, "Updater = updater(\"", property.name, "\");");
        }
    }

    /**
     * Define property field.
     */
    private void defineField() {
        for (PropertyDefinition property : m.ownProperties()) {
            code.write();
            code.write("/** The exposed property. */");
            code.write("public final ", property.type, " ", property.name, ";");
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
            code.write("private final void set", property.capitalizeName(), "(", property.type, " value)", () -> {
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
            code.write();

            Optional<PropertyDefinition> first = m.firstRequiredProperty();

            if (first.isEmpty()) {
                code.write("/**");
                code.write(" * Create uninitialized {@link ", m.implType, "}.");
                code.write(" */");
                code.write("public final Self create()", () -> {
                    code.write("return (Self) new ", Assignable, "();");
                });
            } else {
                PropertyDefinition p = first.get();
                // base setter
                code.write("/** Create Uninitialized {@link ", m.implType, "}. */");
                code.write("public final <T extends ", m
                        .requiredRouteTypeWithoutFirst("Self"), "> T ", p.name, "(", p.type, " value)", () -> {
                            code.write("return (T) new ", Assignable, "().", p.name, "(value);");
                        });

                for (Method method : m.findOverloadsFor(p)) {
                    code.write();
                    code.write("/** Create Uninitialized {@link ", m.implType, "}. */");
                    code.write("public final <T extends ", m.requiredRouteTypeWithoutFirst("Self"), "> T ", method, () -> {
                        code.write("return (T) new ", Assignable, "().", method.name, "(", method.paramNames, ");");
                    });
                }
            }
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
                for (Method method : m.findOverloadsFor(p)) {
                    code.write();
                    code.write("/**");
                    code.write(" * The overload setter.");
                    code.write(" */");
                    code.write("default Next ", method, () -> {
                        code.writeTry(() -> {
                            code.write("return ", p.name, "((", method.returnType, ") ", method.id, ".invoke(this, ", method.paramNames, "));");
                        }, Throwable.class, e -> {
                            code.write("throw new Error(", e, ");");
                        });
                    });
                }
                code.write();
                code.write("/**");
                code.write(" * The setter.");
                code.write(" */");
                code.write("default Next ", p.name, "(", p.type, " value)", () -> {
                    code.writeTry(() -> {
                        code.write(p.name, "Updater.invoke(this, value);");
                    }, Throwable.class, e -> {
                        code.write("throw new Error(", e, ");");
                    });
                    code.write("return (Next) this;");
                });
            });
        }

        String extend = this.parent == null ? "" : " extends " + this.parent + "." + ArbitraryInterface + "<Next>";
        code.write();
        code.write("/**");
        code.write(" * Property assignment API.");
        code.write(" */");
        code.write("public static interface ", ArbitraryInterface, "<Next extends ", m.implType, ">", extend, () -> {
            for (PropertyDefinition property : m.ownArbitraryProperties()) {
                code.write();
                code.write("/**");
                code.write(" * Property assignment API.");
                code.write(" */");
                code.write("default Next ", property.name, "(", property.type, " value)", () -> {
                    code.writeTry(() -> {
                        code.write(property.name, "Updater.invoke(this, value);");
                    }, Throwable.class, e -> {
                        code.write("throw new Error(", e, ");");
                    });
                    code.write("return (Next) this;");
                });
            }
        });

        StringJoiner apis = new StringJoiner(", ", " extends ", "").setEmptyValue("");
        for (PropertyDefinition property : m.ownRequiredProperties()) {
            apis.add(property.assignableInterfaceName());
        }
        if (parent != null) {
            apis.add(code.use(parent) + "." + AssignableAll);
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