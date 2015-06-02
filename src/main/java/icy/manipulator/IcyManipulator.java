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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
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
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import icy.manipulator.compiler.SourceFile;
import icy.manipulator.model.Person;

/**
 * @version 2015/06/02 16:33:00
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("icy.manipulator.Icy")
public class IcyManipulator extends AbstractProcessor {

    /** The indent. */
    private static final String __ = "    ";

    /** The line feed. */
    private static final String END = "\r\n";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations.isEmpty()) {
            return true;
        }

        Elements util = processingEnv.getElementUtils();

        for (Element element : env.getElementsAnnotatedWith(Icy.class)) {
            SourceCodeAnalyzer analyzer = element.accept(new SourceCodeAnalyzer(), null);
            SourceCodeWriter coder = new SourceCodeWriter(analyzer);

            System.out.println(coder.body);

            try {
                SourceFile source = SourceFile.of(Person.class);
                JavaFileObject generated = processingEnv.getFiler()
                        .createSourceFile(element.toString().replaceAll("Model$", ""));
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

        /** The type name. */
        private FQCN type;

        /**
         * @param type
         * @param name
         */
        public Property(TypeMirror type, String name) {
            this.name = name;

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
            type = FQCN.of(((TypeElement) t.asElement()).getQualifiedName());
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
    private static class SourceCodeAnalyzer implements ElementVisitor<SourceCodeAnalyzer, Void> {

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
        public SourceCodeAnalyzer visit(Element e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visit(Element e) {
            return visit(e, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitPackage(PackageElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitType(TypeElement e, Void p) {
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
            fqcn = FQCN.of(model.toString().replaceAll("Model$", ""));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitVariable(VariableElement e, Void p) {
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
            properties.add(new Property(e.asType(), e.getSimpleName().toString()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitExecutable(ExecutableElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitTypeParameter(TypeParameterElement e, Void p) {
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceCodeAnalyzer visitUnknown(Element e, Void p) {
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
         * @param analyzer
         */
        private SourceCodeWriter(SourceCodeAnalyzer analyzer) {
            this.imports = new Imports(clazz = analyzer.fqcn);

            write("package ", clazz.packageName, ";");
            write();
            write(imports);
            write();
            write("public abstract class ", clazz.className, " implements ", parameterize(Operatable.class, clazz), "{");
            write();
            write("     /** The current model. */");
            write("     private ", imports.use(analyzer.model), " model;");
            write();
            write("     /**");
            write("      * HIDDEN CONSTRUCTOR");
            write("      */");
            write("     private ", clazz.className, "() {");
            write("     }");
            write();
            for (Property property : analyzer.properties) {
                // getter
                write("     /**");
                write("     * Retrieve ", property.name, " property.");
                write("     */");
                write("     public ", property.type, " ", property.name, "() {");
                write("         return model.", property.name, ";");
                write("     }");
                write();

                // setter
                write("     /**");
                write("     * Apply ", property.name, " property.");
                write("     */");
                write("     public ", clazz, " ", property.name, "(", property.type, " value) {");
                write("         if (model.", property.name, " == value) {");
                write("             return this;");
                write("         }");
                write("         return with(this).", property.name, "(value).ice();");
                write("     }");
                write();
            }
            write("}");

            // generate code fragments
            imports.generate();
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
