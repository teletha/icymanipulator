/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

/**
 * @version 2015/06/07 0:34:00
 */
public class Type {

    /** The package name. */
    public final String packageName;

    /** The simple class name. */
    public final String className;

    /** The variable expression. */
    public final List<Type> variable = new ArrayList();

    /** The generic flag. */
    public final boolean generic;

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param type
     */
    public Type(Class type) {
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
    public Type(String fqcn, List<? extends Type> generics) {
        if (generics != null && !generics.isEmpty()) {
            this.variable.addAll(generics);
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
    public Type(String packageName, String className, boolean generic) {
        this.packageName = packageName;
        this.className = className;
        this.generic = generic;
    }

    /**
     * Compute fully qualified class name.
     * 
     * @return
     */
    public String fqcn() {
        if (packageName.isEmpty()) {
            return className;
        } else {
            return packageName + "." + className;
        }
    }

    public Type resetVariable(Type variable) {
        this.variable.clear();
        this.variable.add(variable);

        return this;
    }

    /**
     * <p>
     * Check default package.
     * </p>
     * 
     * @return
     */
    public boolean isDefault() {
        return packageName.equals("java.lang");
    }

    /**
     * <p>
     * Check array type.
     * </p>
     * 
     * @return
     */
    public boolean isArray() {
        return className.endsWith("[]");
    }

    /**
     * <p>
     * Check primitive type.
     * </p>
     * 
     * @return
     */
    public boolean isPrimitive() {
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
    public Type wrap() {
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
    public String defaultValue() {
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
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Class type) {
        return fqcn().equals(type.getName());
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Type type) {
        return fqcn().equals(type.fqcn());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(packageName, className, variable.toString(), generic);
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
        return fqcn();
    }

    /**
     * <p>
     * Resoleve {@link Type} by the generic variable type.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type generic(String name) {
        return new Type("", name, true);
    }

    /**
     * <p>
     * Resoleve {@link Type} by the fully qualified class name.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type of(String fqcn) {
        return new Type(fqcn, null);
    }

    /**
     * <p>
     * Resoleve {@link Type} by the fully qualified class name.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type of(Class type) {
        return new Type(type.getName(), null);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeMirror type) {
        return type.accept(new TypeDetector(), null);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeMirror type, List<Type> variables) {
        return type.accept(new TypeDetector(), variables);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeElement type) {
        return type.asType().accept(new TypeDetector(), null);
    }

    /**
     * @version 2015/06/06 11:44:40
     */
    private static class TypeDetector implements TypeVisitor<Type, List<Type>> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visit(TypeMirror t, List<Type> p) {
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
        public Type visitPrimitive(PrimitiveType t, List<Type> p) {
            return new Type(t.toString(), null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitNull(NullType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitArray(ArrayType t, List<Type> p) {
            return new Type(t.toString(), null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitDeclared(DeclaredType t, List<Type> p) {
            return new Type(((TypeElement) t.asElement()).getQualifiedName().toString(), p != null ? p
                    : t.getTypeArguments().stream().map(Type::of).collect(Collectors.toList()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitError(ErrorType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitTypeVariable(TypeVariable t, List<Type> p) {
            return new Type("", t.toString(), true);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitWildcard(WildcardType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitExecutable(ExecutableType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitNoType(NoType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitUnknown(TypeMirror t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitUnion(UnionType t, List<Type> p) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitIntersection(IntersectionType t, List<Type> p) {
            return null;
        }
    }
}
