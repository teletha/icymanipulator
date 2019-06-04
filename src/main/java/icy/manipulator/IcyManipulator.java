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
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.UnaryOperator;

import javax.annotation.processing.Generated;

import apty.Apty;
import apty.AptyProcessor;
import apty.Modifiers;
import apty.code.Coder;
import apty.code.Type;
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

        /** The fully qualified type variables on the model. */
        private final List<Type> declarations;

        /** The reusable ArbitraryInterface type. */
        private final Type ArbitraryInterfaceType;

        /**
         * @param model
         */
        public IcyCoder(ModelInfo model) {
            super(model.implType.name());
            this.m = model;
            this.icy = model.e.getAnnotation(Icy.class);
            this.declarations = model.type.declaredVariables();
            this.ArbitraryInterfaceType = Type.of(m.implType + "." + ArbitraryInterface);

            String visibility = icy.packagePrivate() ? "" : "public ";
            String inheritance = Apty.isInterface(model.e) ? " implements " : " extends ";

            write("/**");
            write(" * Generated model for {@link ", model.type, "}.");
            write(" */");
            write("@", Generated.class, "(`Icy Manipulator`)");
            write(visibility, "abstract class ", model.implType.raw(), declare(declarations), inheritance, model.type, () -> {
                defineErrorHandler();
                defineMethodInvokerBuilder();
                defineMethodInvoker();
                defineFiledUpdaterBuilder();
                defineFieldUpdater();
                defineField();
                defineConstructor();
                defineAccessors();
                defineToString();
                defineHashCode();
                defineEquals();
                defineCopy();
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
            if (m.ownProperties().isEmpty()) {
                return;
            }

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
            if (m.ownProperties().isEmpty() || (!m.hasOwnUserDefinedOverload() && !m.hasIntercept())) {
                return;
            }

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
                    write(Method.class, " method = ", m.type, ".class.getDeclaredMethod(name, parameterTypes);");
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
                for (MethodInfo method : Lists.merge(m.findUserDefinedOverloadsFor(property), m.findInterceptsFor(property))) {
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
            if (m.ownProperties().isEmpty()) {
                return;
            }

            write();
            write("/**");
            write(" * Create special property updater.");
            write(" *");
            write(" * @param name A target property name.");
            write(" * @return A special property updater.");
            write(" */");
            write("private static final ", MethodHandle.class, " updater(String name) ", () -> {
                writeTry(() -> {
                    write(Field.class, " field = ", classLiteral(m.implType), ".getDeclaredField(name);");
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
            write("protected ", m.implType.raw(), "()", () -> {
                // initialize field
                for (PropertyInfo p : m.ownProperties()) {
                    write("this.", p.name, " = ", (p.arbitrary ? defaultValueCallFor(p) : p.type.defaultValue()), ";");
                }
            });
        }

        /**
         * Write super method call for retrieving the default value.
         * 
         * @param property A target property.
         * @return
         */
        private String defaultValueCallFor(PropertyInfo property) {
            if (property.element.isDefault()) {
                return use(m.type) + ".super." + property.name + "()";
            } else if (!Modifiers.isAbstract(property.element)) {
                return "super." + property.name + "()";
            } else {
                return OptionalSupport.by(property.type).map(s -> use(s.type) + "." + s.noneMethod + "()").orElseThrow();
            }
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
                            if (property.arbitrary) {
                                write("value = ", defaultValueCallFor(property), ";");
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
         * Define {@link Object#toString()} override.
         */
        private void defineToString() {
            if (!m.hasToString) {
                write();
                write("/**");
                write(" * Show all property values.");
                write(" *");
                write(" * @return All property values.");
                write(" */");
                write("@", Override.class);
                write("public String toString()", () -> {
                    write(StringBuilder.class, " builder = new ", StringBuilder.class, "(`", m.implType, " [`);");
                    List<PropertyInfo> properties = m.properties();
                    for (int i = 0; i < properties.size(); i++) {
                        PropertyInfo p = properties.get(i);
                        String tail = i == properties.size() - 1 ? "]" : ", ";

                        if (p.type.isArray()) {
                            write("builder.append(`", p.name, "=`).append(", Arrays.class, ".deepToString(", p.name, ")).append(`", tail, "`);");
                        } else {
                            write("builder.append(`", p.name, "=`).append(", p.name, ").append(`", tail, "`);");
                        }
                    }
                    write("return builder.toString();");
                });
            }
        }

        /**
         * Define {@link Object#hashCode()} override.
         */
        private void defineHashCode() {
            if (!m.hasHashCode) {
                write();
                write("/**");
                write(" * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). ");
                write(" *");
                write(" * @return A hash value of the sequence of property values.");
                write(" */");
                write("@", Override.class);
                write("public int hashCode()", () -> {
                    StringJoiner values = new StringJoiner(", ");
                    for (PropertyInfo p : m.properties()) {
                        if (p.type.isArray()) {
                            values.add(use(Arrays.class) + ".deepHashCode(" + p.name + ")");
                        } else {
                            values.add(p.name);
                        }
                    }
                    write("return ", Objects.class, ".hash(", values, ");");
                });
            }
        }

        /**
         * Define {@link Object#equals(Object)} override.
         */
        private void defineEquals() {
            if (!m.hasEquals) {
                write();
                write("/**");
                write(" * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. ");
                write(" *");
                write(" * @return true if the all properties are equal to each other and false otherwise.");
                write(" */");
                write("@", Override.class);
                write("public boolean equals(Object o)", () -> {
                    write("if (o instanceof ", m.implType.raw(), " == false)", () -> {
                        write("return false;");
                    });
                    write();
                    write(m.implType, " other = (", m.implType, ") o;");
                    for (PropertyInfo p : m.properties()) {
                        if (p.type.isPrimitive()) {
                            write("if (", p.name, " != other.", p.name, ") return false;");
                        } else if (p.type.isArray()) {
                            write("if (!", Objects.class, ".deepEquals(", p.name, ", other.", p.name, ")) return false;");
                        } else {
                            write("if (!", Objects.class, ".equals(", p.name, ", other.", p.name, ")) return false;");
                        }
                    }
                    write("return true;");
                });
            }
        }

        /**
         * Define copy methods.
         */
        private void defineCopy() {
            for (PropertyInfo property : m.copiablePoroperties()) {
                write();
                write("/**");
                write(" * Create new {@link ", m.implType, "} with the specified property and copy other properties from this model.");
                write(" *");
                write(" * @param value A new value to assign.");
                write(" * @return A created new model instance.");
                write(" */");
                write("public ", m.implType, " with", property.capitalizeName(), "(", property.type, " value)", () -> {
                    // check equality
                    write("if (this.", property.name, " == value)", () -> {
                        write("return this;");
                    });

                    StringJoiner code = new StringJoiner(".");
                    for (PropertyInfo p : Lists.merge(m.requiredProperties(), m.arbitraryProperties())) {
                        code.add(p.name + "(" + (property == p ? "value" : "this." + p.name) + ")");
                    }
                    write("return ", icy.builder(), ".", code, ";");
                });
            }
        }

        /**
         * Defien model builder methods.
         */
        private void defineBuilder() {
            write();
            if (m.type.variables.size() == 0) {
                write("/** The singleton builder. */");
                write("public static final  ", Instantiator, "<?> ", icy.builder(), " = new ", Instantiator, "();");
            } else {
                write("public static ", declare(declarations), " ", Instantiator, "<", Type.WILD.with(m.type.variables), "> with()", () -> {
                    write("return new ", Instantiator, "();");
                });
            }

            String parentInstantiator = m.parent.map(p -> " extends " + Type.of(Apty.parent(m.e)) + "." + Instantiator).orElse("");

            Type Self = Type.var("Self", m.implType, ArbitraryInterfaceType.params("Self", m.type.variables));

            write();
            write("/**");
            write(" * Namespace for {@link ", m.implType, "}  builder methods.");
            write(" */");
            write("public static class ", Instantiator, "<", Self.with(declarations), ">", parentInstantiator, () -> {
                m.firstRequiredProperty().ifPresentOrElse(p -> {
                    int group = icy.grouping();
                    List<PropertyInfo> requireds = m.requiredProperties().subList(0, group);

                    requireds.stream()
                            .map(def -> new MethodSynthesizer(m, def))
                            .reduce((prev, next) -> prev.synthesize(next))
                            .stream()
                            .flatMap(s -> s.methods.stream())
                            .forEach(method -> {
                                String type = m.requiredRouteType(group, "Self");

                                write();
                                javadoc(method.doc, () -> {
                                    write("/**");
                                    write(" * Create new {@link ", m.implType, "} with the specified ", p.name, " property.");
                                    write(" * ");
                                    write(" * @return The next assignable model.");
                                    write(" */");
                                });
                                write("public ", type, " ", method, () -> {
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
                                    write("return ", type.equals("Self") ? "(Self)" : "", "o;");
                                });
                            });
                }, () -> {
                    // =========================================
                    // No Required Property
                    // =========================================
                    write();
                    write("/**");
                    write(" * Create initialized {@link ", m.implType, "}.");
                    write(" *");
                    write(" * @return A initialized model.");
                    write(" */");
                    write("public Self create()", () -> {
                        write("return (Self) new ", Assignable, "();");
                    });

                    for (PropertyInfo p : m.arbitraryProperties()) {
                        write();
                        write("/**");
                        write(" * Create initialized {@link ", m.implType, "} with ", p.name, " property.");
                        write(" *");
                        write(" * @param value A value to assign.");
                        write(" * @return A initialized model.");
                        write(" */");
                        write("public Self ", p.name, "(", p.type, " value)", () -> {
                            write("return create().", p.name, "(value);");
                        });

                        // =========================================
                        // Overload
                        // =========================================
                        for (MethodInfo m : m.findOverloadsFor(p)) {
                            write();
                            javadoc(m.doc, () -> {
                                write("/**");
                                write(" * Create initialized {@link ", this.m.implType, "} with ", p.name, " property.");
                                write(" *");
                                write(" * @param value A value to assign.");
                                write(" * @return A initialized model.");
                                write(" */");
                            });
                            write("public Self ", m, () -> {
                                overload(p, m);
                            });
                        }
                    }
                });
            });
        }

        /**
         * Define assignable interfaces.
         */
        private void defineAssignableInterfaces() {
            Type Next = Type.var("Next");

            for (PropertyInfo property : m.ownRequiredProperties()) {
                write();
                write("/**");
                write(" * Property assignment API.");
                write(" */");
                write("public static interface ", property.assignableInterfaceName(), "<", Next.with(declarations), ">", () -> {
                    defineAssignableSetter(property);
                });
            }
        }

        /**
         * Define assignable interfaces.
         */
        private void defineAssignableArbitrary() {
            Optional<String> extend = m.findNearestArbitraryModel()
                    .map(m -> " extends " + use(m.implType) + "." + ArbitraryInterface + "<Next>");

            Type Next = Type.var("Next", m.implType);

            write();
            write("/**");
            write(" * Property assignment API.");
            write(" */");
            write("public static interface ", ArbitraryInterface, "<", Next.with(declarations), ">", extend, () -> {
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
                    overload(p, m);
                });
            }
        }

        /**
         * Write overload method.
         * 
         * @param p A property info.
         * @param m A method info.
         */
        private void overload(PropertyInfo p, MethodInfo m) {
            OptionalSupport.by(p.type).ifPresentOrElse(s -> {
                write("return ", p.name, "(", s.type, ".", s.someMethod, "(", m.paramNames.get(0), "));");
            }, () -> {
                if (Apty.isEnum(p.element.getReturnType())) {
                    write("return ", p.name, "(", p.type, ".", Strings.capitalize(m.name), ");");
                } else {
                    List<String> names = m.withFirst(Type.of(Object.class), "this").paramNames;

                    writeTry(() -> {
                        write("return ", p.name, "((", m.returnType, ") ", m.id(), ".invoke(", names, "));");
                    }, Throwable.class, e -> {
                        write("throw quiet(", e, ");");
                    });
                }
            });
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
         * Define mutable model class.
         */
        private void defineMutableClass() {
            write();
            write("/**");
            write(" * Mutable Model.");
            write(" */");
            write("private static final class ", Assignable, declare(declarations), " extends ", m.implType, " implements ", AssignableAll, ", ", ArbitraryInterface, () -> {
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
