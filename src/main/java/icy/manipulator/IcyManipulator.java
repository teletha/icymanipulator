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
import java.util.function.UnaryOperator;

import javax.annotation.processing.Generated;

import apty.Apty;
import apty.AptyProcessor;
import apty.code.Coder;
import icy.manipulator.util.Lists;
import icy.manipulator.util.Strings;

public class IcyManipulator extends AptyProcessor {

    /** The prefix of assignable type. */
    static final String Assignable = "Åssignable";

    /** The aggregated assignable interface name. */
    static final String AssignableAll = Assignable + "All";

    /** The instantiator class name. */
    static final String Instantiator = "Ìnstantiator";

    /** The configuration interface name for arbitrary perperties. */
    static final String ArbitraryInterface = Assignable + "Årbitrary";

    /**
    * 
    */
    public IcyManipulator() {
        process(Icy.class, element -> {
            writeSourceFileBy(new IcyCoder(new ModelInfo(element)));
        });
    }

    /**
     * 
     */
    private static class IcyCoder extends Coder {

        /** The current procesing model. */
        private final ModelInfo m;

        /** The {@link Icy} info on the model class. */
        private final Icy icy;

        /**
         * @param model
         */
        public IcyCoder(ModelInfo model) {
            super(model.implType.fqcn());
            this.m = model;
            this.icy = model.e.getAnnotation(Icy.class);

            String visibility = icy.packagePrivate() ? "" : "public ";

            write("/**");
            write(" * Generated model for {@link ", model.type, "}.");
            write(" */");
            write("@", Generated.class, "(`Icy Manipulator`)");
            write(visibility, "abstract class ", model.implType, " extends ", model.type, () -> {
                defineErrorHandler();
                if (model.hasOverload() || model.hasIntercept()) {
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
        }

        /**
         * Define transparent error handler.
         */
        private void defineErrorHandler() {
            write();
            write("/**");
            write(" * Deceive complier that the specified checked exception is unchecked exception.");
            write(" *");
            write(" * @param <T> A dummy type for {@link RuntimeException}.");
            write(" * @param throwable Any error.");
            write(" * @return A runtime error.");
            write(" * @throws T Dummy error to deceive compiler.");
            write(" */");
            write("private static final <T extends Throwable> T quiet(Throwable throwable) throws T", () -> {
                write("throw (T) throwable;");
            });
        }

        /**
         * Define query method for property updater.
         */
        private void defineMethodInvokerBuilder() {
            write();
            write("/**");
            write(" * Create special method invoker.");
            write(" *");
            write(" * @param name A target method name.");
            write(" * @param parameterTypes A list of method parameter types.");
            write(" * @return A special method invoker.");
            write(" */");
            write("private static final ", MethodHandle.class, " invoker(String name, Class... parameterTypes) ", () -> {
                writeTry(() -> {
                    write(java.lang.reflect.Method.class, " method = ", m.type, ".class.getDeclaredMethod(name, parameterTypes);");
                    write("method.setAccessible(true);");
                    write("return ", MethodHandles.class, ".lookup().unreflect(method);");
                }, Throwable.class, e -> {
                    write("throw quiet(", e, ");");
                });
            });
        }

        /**
         * Define property updater.
         */
        private void defineMethodInvoker() {
            for (PropertyInfo property : m.ownProperties()) {
                for (MethodInfo method : Lists.merge(m.findOverloadsFor(property), m.findInterceptsFor(property))) {
                    StringJoiner types = new StringJoiner(", ", ", ", "").setEmptyValue("");
                    method.paramTypes.forEach(t -> types.add(classLiteral(t)));

                    write();
                    write("/** The overload or intercept method invoker. */");
                    write("private static final ", MethodHandle.class, " ", method.id(), "= invoker(`", method.name, "`", types, ");");
                }
            }
        }

        /**
         * Define query method for property updater.
         */
        private void defineFiledUpdaterBuilder() {
            write();
            write("/**");
            write(" * Create special property updater.");
            write(" *");
            write(" * @param name A target property name.");
            write(" * @return A special property updater.");
            write(" */");
            write("private static final ", MethodHandle.class, " updater(String name) ", () -> {
                writeTry(() -> {
                    write(Field.class, " field = ", m.implType, ".class.getDeclaredField(name);");
                    write("field.setAccessible(true);");
                    write("return ", MethodHandles.class, ".lookup().unreflectSetter(field);");
                }, Throwable.class, e -> {
                    write("throw quiet(", e, ");");
                });
            });
        }

        /**
         * Define property updater.
         */
        private void defineFieldUpdater() {
            for (PropertyInfo property : m.ownProperties()) {
                write();
                write("/** The final property updater. */");
                write("private static final ", MethodHandle.class, " ", property.name, "Updater = updater(`", property.name, "`);");
            }
        }

        /**
         * Define property field.
         */
        private void defineField() {
            for (PropertyInfo p : m.ownProperties()) {
                write();
                write("/** The exposed property. */");
                write("public final ", p.type, " ", p.name, ";");

                if (p.custom != null) {
                    write();
                    write("/** The property customizer. */");
                    write("private final ", p.custom.type(), " ", p.name, "Customizer = new ", p.custom.type(), "()", () -> {
                        write();
                        write("@Override");
                        write("public ", p.type, " get()", () -> {
                            write("return ", p.name, ";");
                        });
                    }).asStatement();
                }
            }
        }

        /**
         * Define constructor.
         */
        private void defineConstructor() {
            write();
            write("/**");
            write(" * HIDE CONSTRUCTOR");
            write(" */");
            write("protected ", m.implType, "()", () -> {
                // initialize field
                for (PropertyInfo p : m.ownProperties()) {
                    write("this.", p.name, " = ", (p.isArbitrary ? "super." + p.name + "()" : p.type.defaultValue()), ";");
                }
            });
        }

        /**
         * Define property getter methods.
         */
        private void defineAccessors() {
            for (PropertyInfo property : m.ownProperties()) {
                // Exposed getter
                write();
                javadoc(property.element, () -> {
                    write("/**");
                    write(" * Return the ", property.name, " property.");
                    write(" *");
                    write(" * @return A value of ", property.name, " property.");
                    write(" */");
                });
                write("@Override");
                write("public final ", property.type, " ", property.name, "()", () -> {
                    write("return this.", property.name, ";");
                });

                // Exposed setter
                if (property.mutable) {
                    write();
                    write("/**");
                    write(" * Assign the new value of ", property.name, " property.");
                    write(" *");
                    write(" * @paran value The ", property.name, " property assigner which accepts the current value and returns new value.");
                    write(" * @return Chainable API.");
                    write(" */");
                    write("public final ", m.implType, " ", property.name, "(", UnaryOperator.class, "<", property.type, "> value)", () -> {
                        write("set", property.capitalizeName(), "(value.apply(this.", property.name, "));");
                        write("return this;");
                    });
                }

                // Hidden classic getter
                write();
                write("/**");
                write(" * Provide classic getter API.");
                write(" *");
                write(" * @return A value of ", property.name, " property.");
                write(" */");
                if (property.isPrivateGetter()) write("@SuppressWarnings(`unused`)");
                write(property.getterModifier, property.type, " get", property.capitalizeName(), "()", () -> {
                    write("return this.", property.name, ";");
                });

                // Hidden classic setter
                write();
                write("/**");
                write(" * Provide classic setter API.");
                write(" *");
                write(" * @paran value A new value of ", property.name, " property to assign.");
                write(" */");
                write(property.setterModifier, "void set", property.capitalizeName(), "(", property.type, " value)", () -> {
                    if (!property.nullable && !property.type.isPrimitive()) {
                        write("if (value == null)", () -> {
                            if (property.isArbitrary) {
                                write("value = ((", m.implType, ") this).åccessToDefault", property.capitalizeName() + "();");
                            } else {
                                write("throw new IllegalArgumentException(`The ", property.name, " property requires non-null value.`);");
                            }
                        });
                    }

                    writeTry(() -> {
                        String value = "value";
                        for (MethodInfo inter : m.findInterceptsFor(property)) {
                            value = inter.id() + ".invoke(this, " + value;
                            for (int i = 1; i < inter.paramTypes.size(); i++) {
                                String name = m.findPropertyByName(inter.paramNames.get(i)).name;
                                value += ", (" + use(inter.paramTypes.get(i)) + ") ((" + Assignable + ") this)::" + name;
                            }
                            value += ")";
                        }
                        write(property.name, "Updater.invoke(this, ", value, ");");

                        if (property.custom != null && property.custom.requireSetter) {
                            write(property.name, "Customizer.accept(this.", property.name, ");");
                        }
                    }, Throwable.class, e -> {
                        write("throw quiet(", e, ");");
                    });
                });

                // Hidden super default value accessor
                if (property.isArbitrary) {
                    write();
                    write("/**");
                    write(" * Provide accesser to super default value.");
                    write(" *");
                    write(" * @return A default value.");
                    write(" */");
                    write("private final ", property.type, " åccessToDefault", property.capitalizeName(), "()", () -> {
                        write("return super.", property.name, "();");
                    });
                }

                // customizer's methods
                if (property.custom != null) {
                    for (MethodInfo m : property.custom.methods) {
                        write();
                        javadoc(m.doc, () -> {
                        });
                        write("public final ", m.returnType, " ", m, () -> {
                            if (m.returnType.is(void.class)) {
                                write(property.name, "Customizer.", m.name, "(", m.paramNames, ");");
                            } else {
                                write("return ", property.name, "Customizer.", name(m.name, property), "(", m.paramNames, ");");
                            }
                        });
                    }
                }
            }
        }

        /**
         * Revert customizer method name.
         * 
         * @param name
         * @param p
         * @return
         */
        private String name(String name, PropertyInfo p) {
            return name.replace(p.capitalizeName(), "$").replace(p.name, "$");
        }

        /**
         * Defien model builder methods.
         */
        private void defineBuilder() {
            String builder = icy.builder();

            write();
            write("/** The singleton builder. */");
            write("public static final  ", Instantiator, "<?> ", builder, " = new ", Instantiator, "();");

            write();
            write("/**");
            write(" * Namespace for {@link ", m.implType, "}  builder methods.");
            write(" */");
            write("public static final class ", Instantiator, "<Self extends ", m.implType, " & ", ArbitraryInterface, "<Self>>", () -> {
                m.firstRequiredProperty().ifPresentOrElse(p -> {
                    int group = icy.grouping();
                    List<PropertyInfo> requireds = m.requiredProperties().subList(0, group);

                    requireds.stream()
                            .map(def -> new Synthesizer(m, def))
                            .reduce((prev, next) -> prev.synthesize(next))
                            .ifPresent(synthesizer -> {
                                for (MethodInfo method : synthesizer.methods) {
                                    String[] types = new String[] {m.requiredRouteType(group, "Self"), "Self"};
                                    if (!types[0].equals("Self")) {
                                        types[0] = "<T extends " + types[0] + "> T";
                                        types[1] = "T";
                                    }

                                    write();
                                    javadoc(method.doc, () -> {
                                        write("/**");
                                        write(" * Create new {@link ", m.implType, "} with the specified ", p.name, " property.");
                                        write(" * ");
                                        write(" * @return The next assignable model.");
                                        write(" */");
                                    });
                                    write("public final ", types[0], " ", method, () -> {
                                        write(Assignable, " o = new ", Assignable, "();");

                                        boolean skipFirst = requireds.size() != method.paramNames.size();
                                        int parameterIndex = skipFirst ? -1 : 0;
                                        int index = 0;

                                        for (; index < requireds.size(); index++, parameterIndex++) {
                                            String methodName = index == 0 ? method.name : requireds.get(index).name;

                                            if (0 <= parameterIndex) {
                                                write("o.", methodName, "(", method.paramNames.get(parameterIndex), ");");
                                            } else {
                                                write("o.", methodName, "();");
                                            }
                                        }
                                        write("return (", types[1], ") o;");
                                    });
                                }
                            });
                }, () -> {
                    // =========================================
                    // No Required Property
                    // =========================================
                    write();
                    write("/**");
                    write(" * Create initialized {@link ", m.implType, "}.");
                    write(" */");
                    write("public final Self create()", () -> {
                        write("return (Self) new ", Assignable, "();");
                    });
                });
            });
        }

        /**
         * Define mutable model class.
         */
        private void defineMutableClass() {
            write();
            write("/**");
            write(" * Mutable Model.");
            write(" */");
            write("private static final class ", Assignable, " extends ", m.implType, " implements ", AssignableAll, ", ", ArbitraryInterface, () -> {
            });
        }

        /**
         * Define assignable interfaces.
         */
        private void defineAssignableInterfaces() {
            for (PropertyInfo p : m.ownRequiredProperties()) {
                write();
                write("/**");
                write(" * Property assignment API.");
                write(" */");
                write("public static interface ", p.assignableInterfaceName(), "<Next>", () -> {
                    defineAssignableSetter(p);
                });
            }
        }

        /**
         * Define assignable interfaces.
         */
        private void defineAssignableArbitrary() {
            Optional<String> extend = m.findNearestArbitraryModel()
                    .map(m -> " extends " + use(m.implType) + "." + ArbitraryInterface + "<Next>");
            write();
            write("/**");
            write(" * Property assignment API.");
            write(" */");
            write("public static interface ", ArbitraryInterface, "<Next extends ", m.implType, ">", extend, () -> {
                m.ownArbitraryProperties().forEach(this::defineAssignableSetter);
            });
        }

        /**
         * Define assignable setter.
         * 
         * @param p
         */
        private void defineAssignableSetter(PropertyInfo p) {
            // =========================================
            // Base Setter
            // =========================================
            write();
            write("/**");
            write(" * Assign ", p.name, " property.");
            write(" * ");
            write(" * @param value A new value to assign.");
            write(" * @return The next assignable model.");
            write(" */");
            write("default Next ", p.name, "(", p.type.varargnize(), " value)", () -> {
                write("((", m.implType, ") this).set", p.capitalizeName(), "(value);");
                write("return (Next) this;");
            });

            // =========================================
            // Overload Setter
            // =========================================
            for (MethodInfo m : m.findOverloadsFor(p)) {
                write();
                javadoc(m.doc, () -> {
                    write("/**");
                    write(" * Assign ", p.name, " property.");
                    write(" * ");
                    write(" * @return The next assignable model.");
                    write(" */");
                });
                write("default Next ", m, () -> {
                    writeTry(() -> {
                        write("return ", p.name, "((", m.returnType, ") ", m.id(), ".invoke(", m.namesWithHead("this"), "));");
                    }, Throwable.class, e -> {
                        write("throw quiet(", e, ");");
                    });
                });
            }

            // =========================================
            // Auto-Expanded Overload Setter
            // =========================================
            if (p.autoExpandable) {
                for (String name : Apty.enumConstantNames(p.element.getReturnType())) {
                    write();
                    write("/**");
                    write(" * Assign {@link ", p.type, "#", name, "} to ", p.name, " property.");
                    write(" * ");
                    write(" * @return The next assignable model.");
                    write(" */");
                    write("default Next ", Strings.decapitalize(name), "()", () -> {
                        write("return ", p.name, "(", p.type, ".", name, ");");
                    });
                }
            }
        }

        /**
         * Define assignable interfaces.
         */
        private void defineAssignableAll() {
            StringJoiner apis = new StringJoiner(", ", " extends ", "").setEmptyValue("");
            for (PropertyInfo property : m.ownRequiredProperties()) {
                apis.add(property.assignableInterfaceName());
            }
            if (m.hasParent()) {
                apis.add(use(m.parent.get().implType) + "." + AssignableAll);
            }

            write();
            write("/**");
            write(" * Internal aggregated API.");
            write(" */");
            write("protected static interface ", AssignableAll, apis, () -> {
            });
        }

        /**
         * Define property identity.
         */
        private void definePropertyEnum() {
            write();
            write("/**");
            write(" * The identifier for properties.");
            write(" */");
            write("static final class My", () -> {
                for (PropertyInfo property : m.ownProperties()) {
                    write("static final String ", property.capitalizeName(), " = \"", property.name, "\";");
                }
            });
        }
    }
}
