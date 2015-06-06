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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

import icy.manipulator.Accessor;
import icy.manipulator.Icy;
import icy.manipulator.Manipulatable;
import icy.manipulator.Manipulator;

/**
 * @version 2015/06/02 16:33:00
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("icy.manipulator.Icy")
public class IcyManipulator extends AbstractProcessor {

    /** The name of model manipulator class. */
    private static final String ManipulatorClass = "Manipulator";

    /** The name of model manipulator method. */
    private static final String ManipulatorMethod = "manipulate";

    /** The suffix of model definition. */
    static final String ModelDefinitionSuffix = "Model";

    /** The indent. */
    private static final String __ = "    ";

    /** The line feed. */
    static final String END = "\r\n";

    /** The utility. */
    static Types types;

    /** The utility. */
    static Elements elements;

    /** The utility. */
    static Messager messager;

    static ClassImporter importer;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations.isEmpty()) {
            return true;
        }

        // save utilities and constants
        types = processingEnv.getTypeUtils();
        elements = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();

        for (Element element : env.getElementsAnnotatedWith(Icy.class)) {
            importer = new ClassImporter(element.toString());

            SourceCodeReader analyzer = element.accept(new SourceCodeReader(), null);

            if (analyzer.properties.isEmpty()) {
                ErrorNotifier.notify("No property.", element);
            }

            if (ErrorNotifier.hasNoError()) {
                SourceCodeWriter coder = new SourceCodeWriter(analyzer);
                System.out.println(coder.body);

                try {
                    JavaFileObject generated = processingEnv.getFiler()
                            .createSourceFile(element.toString().replaceAll(ModelDefinitionSuffix + "$", ""));
                    Writer writer = generated.openWriter();
                    writer.write(coder.body.toString());
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;

    }

    /**
     * @version 2015/06/02 22:27:11
     */
    private static class SourceCodeReader implements ElementVisitor<SourceCodeReader, VariableElement> {

        /** The fully qualified model class name. */
        private Type model;

        /** The fully qualified class name. */
        private Type fqcn;

        /** The property list. */
        private final List<Property> properties = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visit(Element e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visit(Element e) {
            return visit(e, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitPackage(PackageElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitType(TypeElement e, VariableElement p) {
            switch (e.getKind()) {
            case CLASS:
                visitClass(e);
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
         * <p>
         * Analyze Class.
         * </p>
         * 
         * @param e
         */
        private void visitClass(TypeElement e) {
            String name = e.getQualifiedName().toString();
            DeclaredType declared = (DeclaredType) e.asType();
            List<? extends TypeMirror> variables = declared.getTypeArguments();

            model = new Type(name, variables);
            fqcn = new Type(name.replaceAll(ModelDefinitionSuffix + "$", ""), variables);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitVariable(VariableElement e, VariableElement p) {
            switch (e.getKind()) {
            case FIELD:
                visitField(e);
                break;

            default:
                break;
            }
            return this;
        }

        /**
         * <p>
         * Analyze filed.
         * </p>
         * 
         * @param e
         */
        private void visitField(VariableElement e) {
            Set<Modifier> modifiers = e.getModifiers();

            if (modifiers.contains(Modifier.FINAL)) {
                return;
            }

            if (modifiers.contains(Modifier.PRIVATE)) {
                return;
            }

            if (modifiers.contains(Modifier.STATIC)) {
                return;
            }

            Type type = TypeDetector.detect(e.asType());

            if (type != null) {
                properties.add(new Property(type, e.getSimpleName().toString()));
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitExecutable(ExecutableElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitTypeParameter(TypeParameterElement e, VariableElement p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitUnknown(Element e, VariableElement p) {
            return this;
        }
    }

    /**
     * @version 2015/06/02 22:54:40
     */
    private static class SourceCodeWriter {

        /** The target model class. */
        private final Type clazz;

        /** The code body. */
        private StringBuilder body = new StringBuilder();

        /** The indent size. */
        private int indent;

        /**
         * @param reader
         */
        private SourceCodeWriter(SourceCodeReader reader) {
            clazz = reader.fqcn;

            write("package ", clazz.packageName, ";");
            write();
            int importPosition = body.length();
            write();
            write("/**");
            write(" * {@link ", Manipulatable.class, "} model for {@link ", reader.model, "}.");
            write(" *");
            write(" * @version ", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            write(" */");
            write("public abstract class ", clazz, " extends ", reader.model, " implements ", Manipulatable.class, "<", clazz, "> {");
            write();
            write("     /** The model manipulator for reuse. */");
            write("     private static final ", ManipulatorClass, " MANIPULATOR = new ", ManipulatorClass, "(null);");
            write();
            write("     /**");
            write("      * HIDE CONSTRUCTOR");
            write("      */");
            write("     protected ", clazz.className, "() {");
            write("     }");
            write();
            for (Property property : reader.properties) {
                // GETTER
                write("     /**");
                write("     * Retrieve ", property.name, " property.");
                write("     */");
                write("     public ", property.type, " ", property.name, "() {");
                write("         return this.", property.name, ";");
                write("     }");
                write();

                // SETTER
                write("     /**");
                write("     * Modify ", property.name, " property.");
                write("     */");
                write("     public ", clazz, " ", property.name, "(", property.type, " value) {");
                write("         this.", property.name, " = value;");
                write();
                write("         return this;");
                write("     }");
                write();
            }

            // Builder methods
            write("     /**");
            write("      * Create model builder without base model.");
            write("      */");
            write("     public static final ", $(clazz.variables), clazz, " with() {");
            write("         return new Melty(null);");
            write("     }");
            write();
            write("     /**");
            write("      * Create model builder using the specified definition as base model.");
            write("      */");
            write("     public static final ", $(clazz.variables), clazz, " with(", clazz, " base) {");
            write("         return new Melty(base);");
            write("     }");
            write();

            // Manipulator methods
            String manipulatorType;
            if (clazz.variables.isEmpty()) {
                manipulatorType = ManipulatorClass + "<" + clazz.className + ">";
            } else {
                manipulatorType = ManipulatorClass + "<" + clazz.className + clazz.variables + ", " + clazz.variables
                        .substring(1);
            }
            write("     /**");
            write("      * Create model manipulator.");
            write("      */");
            write("     public static final ", $(clazz.variables), manipulatorType, ManipulatorMethod, "() {");
            write("         return MANIPULATOR;");
            write("     }");
            write();

            // Immutable model
            write("     /**");
            write("      * Immutable Model.");
            write("      */");
            write("     private static final class Icy", clazz.variables, " extends ", clazz, " {");
            write();
            write("         /**");
            write("          * HIDE CONSTRUCTOR");
            write("          */");
            write("         private Icy(", parameterWithType(reader.properties), ") {");
            for (Property property : reader.properties) {
                if (property.isModel) {
                    write("                 this.", property.name, " = ", property.name, " == null ? null : " + property.name, ".ice();");
                } else {
                    write("                 this.", property.name, " = ", property.name, ";");
                }
            }
            write("         }");
            write();
            write("         /**");
            write("          * {@inheritDoc}");
            write("          */");
            write("         @Override");
            write("         public ", clazz, " melt() {");
            write("             return new Melty(this);");
            write("         }");
            write();
            // Override Setters
            for (Property property : reader.properties) {
                write("         /**");
                write("          * {@inheritDoc}");
                write("          */");
                write("         @Override");
                write("         public ", clazz, " ", property.name, "(", property.type, " value) {");
                write("             if (this.", property.name, " == value) {");
                write("                 return this;");
                write("             }");
                write("             return new Icy(", parameterReplaceable(reader.properties, property), ");");
                write("         }");
                write();
            }
            write("     }");

            // Mutable model
            write("     /**");
            write("      * Mutable Model.");
            write("      */");
            write("     private static final class Melty", clazz.variables, " extends ", clazz, " {");
            write();
            write("         /**");
            write("          * HIDE CONSTRUCTOR");
            write("          */");
            write("         private Melty(", clazz, " base) {");
            write("             if (base != null) {");
            for (Property property : reader.properties) {
                write("                 this.", property.name, " = base.", property.name, ";");
            }
            write("             }");
            write("         }");
            write();
            write("         /**");
            write("          * {@inheritDoc}");
            write("          */");
            write("         @Override");
            write("         public ", clazz, " ice() {");
            write("             return new Icy(", parameter(reader.properties), ");");
            write("         }");
            write("     }");

            // MANIPULATOR
            String TYPES = "";
            if (!clazz.variables.isEmpty()) {
                TYPES = ", " + clazz.variables.substring(1, clazz.variables.length() - 1);
            }

            write("     /**");
            write("      * Model Manipulator.");
            write("      */");
            write("     public static final class ", ManipulatorClass, "<RootModel", TYPES, "> extends ", Manipulator.class
                    .getName(), "<RootModel,", clazz, "> {");
            write();
            for (Property property : reader.properties) {
                write("         /** The accessor for ", property.name, " property. */");
                write("         private static final ", Accessor.class, " ", property.NAME, " = ", Accessor.class, ".<", clazz.className, ", ", property.type.generic
                        ? "Object"
                        : property.TYPE.className, "> of(", clazz.className, "::", property.name, ",  ", clazz.className, "::", property.name, ");");
                write();
            }
            write("         /**");
            write("          * Construct operator.");
            write("          */");
            write("         public ", ManipulatorClass, "(", Accessor.class, "<RootModel,", clazz, "> parent) {");
            write("             super(parent);");
            write("         }");
            write();
            for (Property property : reader.properties) {
                write("         /**");
                write("          * Property operator.");
                write("          */");
                if (property.isModel) {
                    if (property.TYPE.variables.isEmpty()) {
                        write("         public ", property.TYPE.className, ".", ManipulatorClass, "<", clazz, "> ", property.name, "() {");
                    } else {
                        write("         public ", property.TYPE.className, ".", ManipulatorClass, "<", clazz, ", ", property.TYPE, "> ", property.name, "() {");
                    }
                    write("             return new ", property.TYPE.className, ".", ManipulatorClass, "(parent.then(", property.NAME, "));");
                    write("         }");
                } else {
                    write("         public ", Accessor.class, "<RootModel,", property.TYPE, "> ", property.name, "() {");
                    write("             return parent.then(", property.NAME, ");");
                    write("         }");
                }
                write();
            }
            write("     }");
            write("}");

            // generate code fragments
            body.insert(importPosition, importer);
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
         * Write indent.
         * </p>
         */
        private void indent() {

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
    }
}
