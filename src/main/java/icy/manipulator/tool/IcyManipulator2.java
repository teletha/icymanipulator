/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.tool;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import icy.manipulator.Icy;
import icy.manipulator.Manipulatable;

@SupportedSourceVersion(SourceVersion.RELEASE_13)
@SupportedAnnotationTypes("icy.manipulator.Icy")
public class IcyManipulator2 extends AbstractProcessor {

    /** The suffix of model definition. */
    static final String ModelDefinitionSuffix = "Model";

    /** The line feed. */
    static final String END = "\r\n";

    /** The utility. */
    static ClassImporter importer;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations.isEmpty()) {
            return true;
        }

        for (Element element : env.getElementsAnnotatedWith(Icy.class)) {
            importer = new ClassImporter(element.toString());
            CodeAnalyzer analyzer = element.accept(new CodeAnalyzer(), null);

            if (analyzer.properties.isEmpty()) {
                analyzer.error("No property.", element);
            }

            if (analyzer.hasError == false) {
                try {
                    analyzer.prepare();
                    String code = analyzer.generateCode();

                    JavaFileObject generated = processingEnv.getFiler().createSourceFile(analyzer.clazz.toString());
                    Writer writer = generated.openWriter();
                    writer.write(code);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    /**
     * 
     */
    private class CodeAnalyzer implements ElementVisitor<CodeAnalyzer, VariableElement> {

        /** The fully qualified model class name. */
        private Type model;

        /** The fully qualified generated class name. */
        private Type clazz;

        /** The property list. */
        private List<Property> properties = new ArrayList();

        /** The required properties. */
        private List<Property> requires;

        /** The optional properties. */
        private List<Property> optionals;

        private StringJoiner apis = new StringJoiner(", ");

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visit(Element e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visit(Element e) {
            return visit(e, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitPackage(PackageElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitType(TypeElement e, VariableElement p) {
            switch (e.getKind()) {
            case CLASS:
                if (model == null) {
                    String name = e.getQualifiedName().toString();
                    DeclaredType declared = (DeclaredType) e.asType();
                    List<? extends TypeMirror> variables = declared.getTypeArguments();

                    model = new Type(name, variables);
                    clazz = new Type(name.replaceAll(ModelDefinitionSuffix + "$", ""), variables);
                }
                break;

            default:
                break;
            }

            for (Element sub : e.getEnclosedElements()) {
                sub.accept(this, p);
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitVariable(VariableElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitExecutable(ExecutableElement e, VariableElement z) {
            if (e.getKind() == ElementKind.METHOD) {
                // Derive derive = e.getAnnotation(Icy.Derive.class);
                //
                // if (derive != null && isDeriveMethod(e)) {
                // Arrays.stream(derive.to()).map(this::findPropertyByName).flatMap(Optional::stream).forEach(p
                // -> p.isDerived = true);
                // Arrays.stream(derive.by())
                // .map(this::findPropertyByName)
                // .flatMap(Optional::stream)
                // .forEach(p -> p.derive = e.getSimpleName().toString());
                // }

                createAsProperty(e);
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitTypeParameter(TypeParameterElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CodeAnalyzer visitUnknown(Element e, VariableElement p) {
            return this;
        }

        /** The code body. */
        private StringBuilder body = new StringBuilder();

        /**
         * Prepare to analyze.
         */
        private void prepare() {
            requires = properties.stream().filter(p -> !p.hasDefault).collect(Collectors.toList());
            optionals = properties.stream().filter(p -> p.hasDefault).collect(Collectors.toList());

            if (requires.size() != 0) {
                for (int i = 0; i < requires.size() - 1; i++) {
                    requires.get(i).next = requires.get(i + 1).NAME;
                }
                requires.get(requires.size() - 1).next = self();
            }

            for (Property property : optionals) {
                property.next = self();
            }

            // compute api
            for (Property property : requires) {
                apis.add(property.NAME);
            }
            if (optionals.size() != 0) {
                apis.add("OPTIONS");
            }
        }

        /**
         * @param reader
         */
        private String generateCode() {
            write("package ", clazz.packageName, ";");
            write();
            int importPosition = body.length();
            write();
            write("/**");
            write(" * {@link ", Manipulatable.class, "} model for {@link ", model, "}.");
            write(" */");
            write("public  class ", clazz, " extends ", model, " {");
            write();
            for (Property property : properties) {
                // SETTER HANDLE
                if (property.isFinal) {
                    write("     /** The final property updater. */");
                    write("     private static final java.lang.invoke.MethodHandle ", property.name, "Updater = icy.manipulator.Manipulator.updater(", clazz, ".class, \"", property.name + "\");");
                    write();
                }
            }
            for (Property property : properties) {
                // property field
                write("     /** The exposed property. */");
                write("     public final ", property.type, " ", property.name, ";");
                write();
            }

            // CONSTRUCTOR
            write("     /**");
            write("      * HIDE CONSTRUCTOR");
            write("      */");
            write("     protected ", clazz, "() {");
            for (Property property : properties) {
                // initialize field
                write("          this.", property.name, " = ", (property.hasDefault ? "super." + property.name + "()"
                        : property.type.defaultValue()), ";");
            }
            write("     }");
            write();
            write("     /**");
            write("      * HIDE CONSTRUCTOR");
            write("      */");
            write("     protected ", clazz, "(", parameterWithType(properties), ") {");
            for (Property property : properties) {
                // initialize field
                write("          this.", property.name, " = ", property.name, ";");
            }
            write("     }");
            write();

            for (Property property : properties) {
                // GETTER
                write("     /**");
                write("     * Retrieve ", property.name, " property.");
                write("     */");
                write("     @Override");
                write("     public final ", property.type, " ", property.name, "() {");
                write("         return this.", property.name, ";");
                write("     }");
                write();
            }

            // =======================================
            // Builders
            // =======================================
            write("     /**");
            write("      * Create model builder without base model.");
            write("      */");
            write("     public static final ", $(clazz.variables), firstRequiredProerptyType(), " create() {");
            write("         return", firstRequiredProerptyType().contains(" extends ") ? " (T)" : "", " new Melty();");
            write("     }");
            write();

            // =======================================
            // Mutable Model
            // =======================================
            write("    /**");
            write("     * Mutable Model.");
            write("    */");
            write("    private static final class Melty", clazz.variables, " extends ", clazz, " implements ", apis, " {");
            for (Property property : properties) {
                // Define Setters
                write();
                write("        /**");
                write("         * Modify ", property.name, " property.");
                write("        */");
                write("        @Override");
                write("        public final ", property.next, " ", property.name, "(", property.type, " value) {");
                if (property.isFinal == false) {
                    write("            this.", property.name, " = value;");
                    if (property.derive != null) write("            super.", property.derive, "(this);");
                } else {
                    write("            try {");
                    write("                ", property.name, "Updater.invoke(this, value);");
                    if (property.derive != null) write("                super.", property.derive, "(this);");
                    write("            } catch (Throwable e) {");
                    write("                throw new Error(e);");
                    write("            }");
                }
                write();
                write("            return", optionals.isEmpty() ? "" : " (T)", " this;");
                write("        }");
            }
            write("     }");

            // =======================================
            // Assignment API
            // =======================================
            for (Property property : requires) {
                write();
                write("    /**");
                write("     * Property assignment API.");
                write("    */");
                write("    public static interface ", property.NAME, " {");
                write("        ", property.next, " ", property.name, "(", property.type, " value);");
                write("    }");
            }

            if (optionals.size() != 0) {
                write();
                write("    /**");
                write("     * Property assignment API.");
                write("    */");
                write("    public static interface OPTIONS {");
                for (Property property : optionals) {
                    write();
                    write("    /**");
                    write("     * Property assignment API.");
                    write("    */");
                    write("    ", property.next, " ", property.name, "(", property.type, " value);");
                }
                write("    }");
            }

            write("}");

            // generate code fragments
            body.insert(importPosition, importer);

            return body.toString();
        }

        /**
         * <p>
         * Write paramter without type.
         * </p>
         * 
         * @return
         */
        private String parameter(List<Property> properties) {
            StringJoiner joiner = new StringJoiner(", ");

            for (Property property : properties) {
                joiner.add(property.name);
            }
            return joiner.toString();
        }

        /**
         * <p>
         * Write paramter without type.
         * </p>
         * 
         * @return
         */
        private String parameterReplaceable(List<Property> properties, Property current) {
            StringJoiner joiner = new StringJoiner(", ");

            for (Property property : properties) {
                if (property == current) {
                    joiner.add("value");
                } else {
                    joiner.add("this." + property.name);
                }
            }
            return joiner.toString();
        }

        /**
         * <p>
         * Write paramter with type.
         * </p>
         * 
         * @return
         */
        private String parameterWithType(List<Property> properties) {
            StringJoiner joiner = new StringJoiner(", ");

            for (Property property : properties) {
                joiner.add(property.type.className + property.type.variables + " " + property.name);
            }
            return joiner.toString();
        }

        /**
         * <p>
         * Write body.
         * </p>
         * 
         * @param texts
         */
        private void write(Object... codes) {
            for (Object code : codes) {
                if (code instanceof Class) {
                    Class clazz = (Class) code;
                    body.append(importer.use(clazz));
                } else if (code instanceof Type) {
                    Type clazz = (Type) code;
                    body.append(importer.use(clazz));
                } else {
                    body.append(code.toString());
                }
            }
            body.append(END);
        }

        /**
         * <p>
         * Helper method to append tailing space.
         * </p>
         * 
         * @param code
         * @return
         */
        private String $(String code) {
            if (code == null || code.isEmpty()) {
                return "";
            } else {
                return code.concat(" ");
            }
        }

        /** The error existence state. */
        private boolean hasError;

        /**
         * <p>
         * Notify error.
         * </p>
         * 
         * @param message
         * @param position
         */
        private void error(String message, Element position) {
            if (message != null && position != null) {
                hasError = true;
                processingEnv.getMessager().printMessage(Kind.ERROR, message, position);
            }
        }

        private Optional<Property> findPropertyByName(String name) {
            for (Property property : properties) {
                if (property.name.equals(name)) {
                    return Optional.of(property);
                }
            }
            return Optional.empty();
        }

        private boolean isDeriveMethod(ExecutableElement method) {
            ExecutableType exe = (ExecutableType) method.asType();

            List<? extends TypeMirror> parameters = exe.getParameterTypes();

            if (parameters.size() != 1) {
                return false;
            }

            Type modelType = Type.of(parameters.get(0));

            if (!modelType.equals(clazz)) {
                return false;
            }
            return true;
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
                error("Property declaring method must have no parameter.", method);
                return;
            }

            Type returnType = Type.of(method.getReturnType());

            if (returnType.className.equalsIgnoreCase("void")) {
                error("Property declaring method must return something.", method);
                return;
            }

            Property property = new Property(returnType, method.getSimpleName().toString(), true);
            property.hasDefault = !method.getModifiers().contains(Modifier.ABSTRACT);

            properties.add(property);
        }

        private String firstRequiredProerptyType() {
            return requires.stream().map(p -> p.NAME).findFirst().orElse(self());
        }

        private String self() {
            return optionals.isEmpty() ? clazz.className : "<T extends " + clazz.className + " & OPTIONS> T";
        }
    }
}
