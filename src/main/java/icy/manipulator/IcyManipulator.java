/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

/**
 * @version 2015/06/02 16:33:00
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("icy.manipulator.Icy")
public class IcyManipulator extends AbstractProcessor {

    /** The suffix of model definition. */
    private static final String ModelDefinitionSuffix = "Definition";

    /** The indent. */
    private static final String __ = "    ";

    /** The line feed. */
    private static final String END = "\r\n";

    /** The utility. */
    private static Types types;

    /** The utility. */
    private static Elements elements;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations.isEmpty()) {
            return true;
        }

        // save utilities and constants
        types = processingEnv.getTypeUtils();
        elements = processingEnv.getElementUtils();

        for (Element element : env.getElementsAnnotatedWith(Icy.class)) {
            SourceCodeReader analyzer = element.accept(new SourceCodeReader(), null);
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

        return true;
    }

    private void log(String msg) {
        if (processingEnv.getOptions().containsKey("debug")) {
            processingEnv.getMessager().printMessage(Kind.NOTE, msg);
        }
    }

    /**
     * @version 2015/06/02 23:07:45
     */
    private static class FQCN {

        /** The package name. */
        private final String packageName;

        /** The class name. */
        private final String className;

        /**
         * @param packageName
         * @param className
         */
        private FQCN(String packageName, String className) {
            this.packageName = packageName;
            this.className = className;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            if (packageName.isEmpty()) {
                return className;
            } else {
                return packageName + "." + className;
            }
        }

        /**
         * <p>
         * Resolve {@link FQCN} by {@link Name}.
         * </p>
         * 
         * @param name
         * @return
         */
        private static FQCN of(Name name) {
            return of(name.toString());
        }

        /**
         * <p>
         * Resolve {@link FQCN} by {@link Name}.
         * </p>
         * 
         * @param name
         * @return
         */
        private static FQCN of(Class name) {
            return of(name.getName());
        }

        /**
         * <p>
         * Resolve {@link FQCN} by {@link Name}.
         * </p>
         * 
         * @param type
         * @return
         */
        private static FQCN of(String fqcn) {
            int index = fqcn.lastIndexOf(".");

            if (index == -1) {
                return new FQCN("", fqcn);
            } else {
                return new FQCN(fqcn.substring(0, index), fqcn.substring(index + 1));
            }
        }

        /**
         * <p>
         * Check default package.
         * </p>
         * 
         * @return
         */
        private boolean isDefault() {
            return packageName.equals("java.lang");
        }

        /**
         * <p>
         * Check primitive type.
         * </p>
         * 
         * @return
         */
        private boolean isPrimitive() {
            switch (className) {
            case "int":
            case "long":
            case "float":
            case "double":
            case "char":
            case "byte":
            case "boolean":
            case "void":
                return true;

            default:
                return false;
            }
        }
    }

    /**
     * @version 2015/06/02 22:49:43
     */
    private static class Property implements TypeVisitor<Property, Void> {

        /** The property name. */
        private final String name;

        /** The property name. */
        private final String NAME;

        /** The type name. */
        private FQCN type;

        /** The type name. */
        private FQCN TYPE;

        /** The state. */
        private boolean isModel;

        /**
         * @param model
         * @param type
         * @param name
         */
        public Property(TypeMirror type, String name) {
            this.name = name;
            this.NAME = name.toUpperCase();

            try {
                this.isModel = Class.forName(type + ModelDefinitionSuffix).isAnnotationPresent(Icy.class);
            } catch (ClassNotFoundException e) {
                this.isModel = false;
            }
            type.accept(this, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visit(TypeMirror t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visit(TypeMirror t) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitPrimitive(PrimitiveType t, Void p) {
            type = FQCN.of(t.toString());

            switch (t.toString()) {
            case "int":
                TYPE = FQCN.of(Integer.class);
                break;

            case "long":
                TYPE = FQCN.of(Long.class);
                break;

            case "float":
                TYPE = FQCN.of(Float.class);
                break;

            case "double":
                TYPE = FQCN.of(Double.class);
                break;

            case "byte":
                TYPE = FQCN.of(Byte.class);
                break;

            case "char":
                TYPE = FQCN.of(Character.class);
                break;

            case "boolean":
                TYPE = FQCN.of(Boolean.class);
                break;

            case "void":
                TYPE = FQCN.of(Void.class);
                break;
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitNull(NullType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitArray(ArrayType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitDeclared(DeclaredType t, Void p) {
            type = TYPE = FQCN.of(((TypeElement) t.asElement()).getQualifiedName());
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitError(ErrorType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitTypeVariable(TypeVariable t, Void p) {
            type = TYPE = FQCN.of(t.toString());
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitWildcard(WildcardType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitExecutable(ExecutableType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitNoType(NoType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitUnknown(TypeMirror t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitUnion(UnionType t, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Property visitIntersection(IntersectionType t, Void p) {
            return this;
        }
    }

    /**
     * @version 2015/06/02 22:27:11
     */
    private static class SourceCodeReader implements ElementVisitor<SourceCodeReader, Void> {

        /** The fully qualified model class name. */
        private FQCN model;

        /** The fully qualified class name. */
        private FQCN fqcn;

        /** The property list. */
        private final List<Property> properties = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visit(Element e, Void p) {
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
        public SourceCodeReader visitPackage(PackageElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitType(TypeElement e, Void p) {
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
            model = FQCN.of(e.getQualifiedName());
            fqcn = FQCN.of(model.toString().replaceAll(ModelDefinitionSuffix + "$", ""));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitVariable(VariableElement e, Void p) {
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

            if (!modifiers.contains(Modifier.PRIVATE) && !modifiers.contains(Modifier.FINAL)) {
                properties.add(new Property(e.asType(), e.getSimpleName().toString()));
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitExecutable(ExecutableElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitTypeParameter(TypeParameterElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeReader visitUnknown(Element e, Void p) {
            return this;
        }
    }

    /**
     * @version 2015/06/02 22:54:40
     */
    private static class SourceCodeWriter {

        /** The target model class. */
        private final FQCN clazz;

        /** The import manager. */
        private final Imports imports;

        /** The code body. */
        private StringBuilder body = new StringBuilder();

        /** The indent size. */
        private int indent;

        /**
         * @param reader
         */
        private SourceCodeWriter(SourceCodeReader reader) {
            this.imports = new Imports(clazz = reader.fqcn);

            write("package ", clazz.packageName, ";");
            write();
            write(imports);
            write();
            write("/**");
            write(" * {@link ", Manipulatable.class, "} model for {@link ", reader.model, "}.");
            write(" *");
            write(" * @version ", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            write(" */");
            write("public abstract class ", clazz.className, " extends ", reader.model, " implements ", parameterize(Manipulatable.class, clazz), "{");
            write();
            write("     /** The model manipulator for reuse. */");
            write("     private static final Manipulator<", clazz, "> MANIPULATOR = new Manipulator(null);");
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
            write("     public static final ", clazz.className, " with() {");
            write("         return new Melty(null);");
            write("     }");
            write();
            write("     /**");
            write("      * Create model builder using the specified definition as base model.");
            write("      */");
            write("     public static final ", clazz.className, " with(", clazz.className, " base) {");
            write("         return new Melty(base);");
            write("     }");
            write();

            // Manipulator methods
            write("     /**");
            write("      * Create model manipulator.");
            write("      */");
            write("     public static final Manipulator<", clazz.className, "> in() {");
            write("         return MANIPULATOR;");
            write("     }");
            write();

            // Immutable model
            write("     /**");
            write("      * Immutable Model.");
            write("      */");
            write("     private static final class Icy extends ", clazz.className, " {");
            write();
            write("         /**");
            write("          * HIDE CONSTRUCTOR");
            write("          */");
            write("         private Icy(", parameterWithType(reader.properties), ") {");
            for (Property property : reader.properties) {
                write("                 this.", property.name, " = ", property.name, property.isModel ? ".ice()" : "", ";");
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
            write("     private static final class Melty extends ", clazz.className, " {");
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
            write("     /**");
            write("      * Model Manipulator.");
            write("      */");
            write("     public static final class Manipulator<M> extends ", Manipulator.class
                    .getName(), "<M,", clazz, "> {");
            write();
            for (Property property : reader.properties) {
                write("         /** The lens for ", property.name, " property. */");
                write("         private static final ", Accessor.class, "<", clazz, ",", property.TYPE, "> ", property.NAME, " = ", Accessor.class, ".of(", clazz, "::", property.name, ",  ", clazz, "::", property.name, ");");
                write();
            }
            write("         /**");
            write("          * Construct operator.");
            write("          */");
            write("         public Manipulator(", Accessor.class, "<M,", clazz, "> parent) {");
            write("             super(parent);");
            write("         }");
            write();
            for (Property property : reader.properties) {
                write("         /**");
                write("          * Property operator.");
                write("          */");
                if (property.isModel) {
                    write("         public ", property.TYPE, ".Manipulator<", clazz, "> ", property.name, "() {");
                    write("             return new ", property.TYPE, ".Manipulator(parent.then(", property.NAME, "));");
                    write("         }");
                } else {
                    write("         public ", Accessor.class, "<M,", property.TYPE, "> ", property.name, "() {");
                    write("             return parent.then(", property.NAME, ");");
                    write("         }");
                }
                write();
            }
            write("     }");

            write("}");

            // generate code fragments
            imports.generate();
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
                joiner.add(property.type.className + " " + property.name);
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
                if (code instanceof CodeFragment) {
                    ((CodeFragment) code).mark(body);
                    return;
                } else if (code instanceof Class) {
                    Class clazz = (Class) code;
                    body.append(imports.use(clazz));
                } else if (code instanceof FQCN) {
                    FQCN clazz = (FQCN) code;
                    body.append(imports.use(clazz));
                } else {
                    body.append(code.toString());
                }
            }
            body.append(END);
        }

        /**
         * <p>
         * Write parameterized body.
         * </p>
         * 
         * @param clazz
         * @param param
         * @return
         */
        private String parameterize(Class clazz, FQCN param) {
            imports.use(FQCN.of(clazz));
            imports.use(param);

            return clazz.getSimpleName() + "<" + param.className + ">";
        }
    }

    /**
     * @version 2015/06/03 2:29:03
     */
    private static abstract class CodeFragment {

        /** The index to append code. */
        private int insertionPoint;

        /** The code fragment. */
        private StringBuilder code;

        /**
         * <p>
         * Mark insertion point.
         * </p>
         * 
         * @param code
         */
        private void mark(StringBuilder code) {
            this.code = code;
            this.insertionPoint = code.length();
        }

        /**
         * <p>
         * Generate code.
         * </p>
         */
        final void generate() {
            StringBuilder code = new StringBuilder();
            generate(code);

            this.code.insert(insertionPoint, code);
        }

        /**
         * <p>
         * Generate code.
         * </p>
         */
        protected abstract void generate(StringBuilder code);
    }

    /**
     * @version 2015/06/03 2:24:50
     */
    private static class Imports extends CodeFragment {

        /** The target model class. */
        private final FQCN clazz;

        /** The imported classes. */
        private final Set<String> imports = new TreeSet();

        /**
         * @param clazz
         */
        private Imports(FQCN clazz) {
            this.clazz = clazz;
        }

        /**
         * <p>
         * Import class.
         * </p>
         */
        private String use(Class imported) {
            return use(FQCN.of(imported));
        }

        /**
         * <p>
         * Import class.
         * </p>
         */
        private String use(FQCN imported) {
            if (!imported.packageName.equals(clazz.packageName) && !imported.isDefault() && !imported.isPrimitive()) {
                imports.add(imported.toString());
            }
            return imported.className;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void generate(StringBuilder code) {
            for (String fqcn : imports) {
                code.append("import ").append(fqcn).append(";").append(END);
            }
        }
    }
}
