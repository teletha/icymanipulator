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
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.annotation.processing.Generated;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;

import icy.manipulator.Icy.Overload;
import icy.manipulator.model.Method;
import icy.manipulator.model.ModelDefinition;
import icy.manipulator.model.PropertyDefinition;
import icy.manipulator.model.PropetyInfo;

public class CodeGenerator {

    /** The prefix of assignable type. */
    public static final String Assignable = "Åssignable";

    /** The aggregated assignable interface name. */
    public static final String AssignableAll = Assignable + "All";

    /** The instantiator class name. */
    private static final String Instantiator = "Ìnstantiator";

    /** The configuration interface name for arbitrary perperties. */
    public static final String ArbitraryInterface = Assignable + "Årbitrary";

    /** The {@link Icy} info on the model class. */
    private final Icy icy;

    /** The fully qualified model class name. */
    private Type model;

    /** The fully qualified generated class name. */
    Type clazz;

    /** The overload method holder. */
    private final List<Method> overloads = new ArrayList();

    /** The overload method for each property */
    private final PropetyInfo<Method> overloadForProperty = new PropetyInfo();

    private Coder code = new Coder(IcyManipulator.importer);

    private final Type parent;

    /** The current procesing model. */
    private final ModelDefinition m;

    /**
     * Create code analyzer.
     * 
     * @param root
     * @param elements
     */
    CodeGenerator(Element root) {
        this.icy = root.getAnnotation(Icy.class);
        this.m = new ModelDefinition(root);
        this.parent = m.parent.map(p -> p.implementationType).orElse(null);

        // analyze
        model = m.type;
        clazz = m.implementationType;

        TypeUtil.methods(m.e).forEach(e -> {
            createAsProperty(e);

            // collect overload methods
            Overload overload = e.getAnnotation(Icy.Overload.class);
            if (overload != null) overloads.add(new Method(e));
        });
    }

    /**
     * Check property declaring method.
     * 
     * @param method
     */
    private void createAsProperty(ExecutableElement method) {
        // require annotation
        icy.manipulator.Icy.Property annotation = method.getAnnotation(Icy.Property.class);

        if (annotation == null) {
            return;
        }

        // require no parameter
        if (method.getParameters().size() != 0) {
            throw new Fail(method, "Property declaring method must have no parameter.");
        }

        Type returnType = Type.of(method.getReturnType());

        if (returnType.className.equalsIgnoreCase("void")) {
            throw new Fail(method, "Property declaring method must return something.");
        }

        PropertyDefinition property = new PropertyDefinition(method);

        if (property.isArbitrary) {
            m.addArbitraryProperty(property);
        } else {
            m.addRequiredProperty(property);
        }
    }

    /**
     * Prepare to analyze.
     */
    void prepare() {
        System.out.println(m);

        validateOverload();
    }

    /**
     * Validate overload method.
     */
    private void validateOverload() {
        for (Method method : overloads) {
            Overload overload = method.getAnnotation(Overload.class);
            String targetProperty = overload.value().isEmpty() ? method.name : overload.value();

            PropertyDefinition property = m.findPropertyByName(targetProperty);

            if (!method.returnType.equals(property.type)) {
                throw new Fail(method.element, "Although the property [" + targetProperty + "] type is " + method.returnType + ", overload method [" + method + "] returns " + method.returnType + ".");
            }
            overloadForProperty.add(property, method);
        }
    }

    /**
     * Generate source code.
     * 
     * @return
     */
    String defineCode() {
        String visibility = icy.packagePrivate() ? "" : "public ";

        code.write("/**");
        code.write(" * Generated model for {@link ", model, "}.");
        code.write(" */");
        code.write("@", Generated.class, "(\"Icy Manipulator\")");
        code.write(visibility, "abstract class ", clazz, " extends ", model, () -> {
            if (!overloads.isEmpty()) {
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
                code.write(java.lang.reflect.Method.class, " method = ", model, ".class.getDeclaredMethod(name, parameterTypes);");
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
            for (Method method : overloadForProperty.get(property)) {
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
                code.write(Field.class, " field = ", clazz, ".class.getDeclaredField(name);");
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
        code.write("protected ", clazz, "()", () -> {
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
        code.write("public static final  ", Instantiator, "Typed<?> ", builder, " = new ", Instantiator, "Typed();");

        code.write();
        code.write("public static final class ", Instantiator, "Typed<Self extends ", clazz.className, " & ", ArbitraryInterface, "<Self>> extends ", Instantiator, "<Self>", () -> {
        });

        code.write();
        code.write("/**");
        code.write(" * Builder namespace for {@link ", clazz, "}.");
        code.write(" */");

        if (m.hasRequiredProperty() == false) {
            code.write("public static class ", Instantiator, "<Self>", () -> {
                code.write();
                code.write("/**");
                code.write(" * Create uninitialized {@link ", clazz, "}.");
                code.write(" */");
                code.write("public final Self create()", () -> {
                    code.write("return base();");
                });
                code.write("protected Self base()", () -> {
                    code.write("return (Self) new ", Assignable, "();");
                });
            });
        } else {
            m.firstRequiredProperty().ifPresent(p -> {
                String extend = parent == null ? ""
                        : " extends " + code.use(parent) + "." + Instantiator + "<" + m.ownRequiredRouteType("Self") + ">";

                code.write("protected static class ", Instantiator, "<Self>", extend, () -> {
                    code.write();

                    if (parent == null) {
                        code.write("/** Create Uninitialized {@link ", clazz, "}. */");
                        code.write("public final <T extends ", m
                                .ownRequiredRouteTypeWithoutFirst("Self"), "> T ", p.name, "(", p.type, " value)", () -> {
                                    code.write("return (T) base().", p.name, "(value);");
                                });
                        for (Method method : overloadForProperty.get(p)) {
                            code.write();
                            code.write("/** Create Uninitialized {@link ", clazz, "}. */");
                            code.write("public final <T extends ", m.ownRequiredRouteTypeWithoutFirst("Self"), "> T ", method, () -> {
                                code.write("return (T) base().", method.name, "(", method.paramNames, ");");
                            });
                        }
                    }
                    code.write("protected ", AssignableAll, " base()", () -> {
                        code.write("return new ", Assignable, "();");
                    });
                });
            });
        }
    }

    /**
     * Define mutable model class.
     */
    private void defineMutableClass() {
        code.write();
        code.write("/**");
        code.write(" * Mutable Model.");
        code.write(" */");
        code.write("private static final class ", Assignable, clazz.variable, " extends ", clazz, " implements ", AssignableAll, ", ", ArbitraryInterface, () -> {
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
                for (Method method : overloadForProperty.get(p)) {
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
        code.write("public static interface ", ArbitraryInterface, "<Next extends ", clazz, ">", extend, () -> {
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