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

import java.util.List;

import javax.lang.model.element.TypeElement;
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

import icy.manipulator.tool.coder.ParameterVariable;

/**
 * @version 2015/06/07 0:34:00
 */
class Type {

    /** The package name. */
    final String packageName;

    /** The class name. */
    final String className;

    /** The variable expression. */
    final ParameterVariable variable = new ParameterVariable();

    /** The generic flag. */
    final boolean generic;

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param type
     */
    Type(Class type) {
        this(type.getPackage().getName(), type.getSimpleName(), false);
    }

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param fqcn
     * @param generics
     */
    Type(String fqcn, List<? extends TypeMirror> generics) {
        if (generics != null && !generics.isEmpty()) {
            for (TypeMirror generic : generics) {
                variable.add(IcyManipulator.importer.use(of(generic)));
            }
        }

        int index = fqcn.lastIndexOf(".");

        if (index == -1) {
            packageName = "";
            className = fqcn;
        } else {
            packageName = fqcn.substring(0, index);
            className = fqcn.substring(index + 1);
        }
        this.generic = false;
    }

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param packageName
     * @param className
     * @param generic
     */
    Type(String packageName, String className, boolean generic) {
        this.packageName = packageName;
        this.className = className;
        this.generic = generic;
    }

    /**
     * <p>
     * Check default package.
     * </p>
     * 
     * @return
     */
    boolean isDefault() {
        return packageName.equals("java.lang");
    }

    /**
     * <p>
     * Check primitive type.
     * </p>
     * 
     * @return
     */
    boolean isPrimitive() {
        switch (className) {
        case "int":
        case "long":
        case "float":
        case "double":
        case "char":
        case "byte":
        case "short":
        case "boolean":
        case "void":
            return true;

        default:
            return false;
        }
    }

    /**
     * <p>
     * Wrap type.
     * </p>
     * 
     * @param type
     * @return
     */
    Type wrap() {
        switch (className) {
        case "int":
            return new Type(Integer.class);

        case "long":
            return new Type(Long.class);

        case "float":
            return new Type(Float.class);

        case "double":
            return new Type(Double.class);

        case "byte":
            return new Type(Byte.class);

        case "char":
            return new Type(Character.class);

        case "boolean":
            return new Type(Boolean.class);

        case "void":
            return new Type(Void.class);

        default:
            return this;
        }
    }

    /**
     * Compute default value literal.
     * 
     * @return
     */
    String defaultValue() {
        switch (className) {
        case "int":
        case "byte":
        case "short":
            return "0";

        case "long":
            return "0L";

        case "float":
            return "0";

        case "double":
            return "0D";

        case "char":
            return "' '";

        case "boolean":
            return "false";

        default:
            return "null";
        }
    }

    /**
     * @param propertyType
     * @return
     */
    boolean match(TypeMirror propertyType) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Type == false) {
            return false;
        }

        Type other = (Type) obj;

        if (!packageName.equals(other.packageName)) {
            return false;
        }

        if (!className.equals(other.className)) {
            return false;
        }

        if (!variable.toString().equals(other.variable.toString())) {
            return false;
        }

        if (generic != other.generic) {
            return false;
        }
        return true;
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
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    static final Type of(TypeMirror type) {
        return type.accept(new TypeDetector(), null);
    }

    /**
     * @version 2015/06/06 11:44:40
     */
    private static class TypeDetector implements TypeVisitor<Type, Void> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visit(TypeMirror t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visit(TypeMirror t) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitPrimitive(PrimitiveType t, Void p) {
            return new Type(t.toString(), null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitNull(NullType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitArray(ArrayType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitDeclared(DeclaredType t, Void p) {
            return new Type(((TypeElement) t.asElement()).getQualifiedName().toString(), t.getTypeArguments());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitError(ErrorType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitTypeVariable(TypeVariable t, Void p) {
            return new Type("", t.toString(), true);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitWildcard(WildcardType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitExecutable(ExecutableType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitNoType(NoType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitUnknown(TypeMirror t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitUnion(UnionType t, Void p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitIntersection(IntersectionType t, Void p) {
            return null;
        }
    }

}