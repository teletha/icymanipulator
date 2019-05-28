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
import java.util.StringJoiner;
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
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;

import apty.code.Codable;
import apty.code.Coder;

/**
 * @version 2015/06/07 0:34:00
 */
public class Type implements Codable {

    /** The package name. */
    private final String packageName;

    /** The simple class name. */
    private final String className;

    /** The variable expression. */
    private final List<Type> variable = new ArrayList();

    /** The type kind. */
    private final TypeKind kind;

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param type
     */
    public Type(Class type) {
        this(type.getPackage().getName(), type.getSimpleName(), List.of(), TypeKind.DECLARED);
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
        this.kind = TypeKind.DECLARED;
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
    public Type(String packageName, String className, List<Type> variables, TypeKind kind) {
        this.packageName = packageName;
        this.className = className;
        this.variable.addAll(variables);
        this.kind = kind;
    }

    public String className() {
        return className;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        if (kind == TypeKind.DECLARED && !isPrimitive()) {
            coder.require(packageName, className);
        }

        if (kind == TypeKind.WILDCARD) {
            StringJoiner join = new StringJoiner(" & ", className, "");
            variable.forEach(v -> join.add(v.write(coder)));
            return join.toString();
        }

        StringJoiner joiner = new StringJoiner(", ", "<", ">").setEmptyValue("");
        for (Type type : variable) {
            joiner.add(type.write(coder));
        }

        return className().concat(joiner.toString());
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
     * Create vararged type if this type is array.
     * 
     * @return
     */
    public final Type varargnize() {
        if (kind == TypeKind.ARRAY) {
            return new Type(packageName, className, variable, TypeKind.MODULE);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(packageName, className, variable, kind);
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

        if (kind != other.kind) {
            return false;
        }
        return true;
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
        return new Type("", name, List.of(), TypeKind.TYPEVAR);
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
        public Type visitArray(ArrayType type, List<Type> p) {
            return new Type(type.toString(), null);
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
            return new Type("", t.toString(), List.of(), TypeKind.TYPEVAR);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitWildcard(WildcardType type, List<Type> p) {
            TypeMirror extendType = type.getExtendsBound();

            if (extendType != null) {
                return new Type(null, "? extends ", List.of(extendType.accept(this, null)), TypeKind.WILDCARD);
            }

            TypeMirror superType = type.getSuperBound();

            if (superType != null) {
                return new Type(null, "? super ", List.of(superType.accept(this, null)), TypeKind.WILDCARD);
            }

            return new Type(null, "?", List.of(), TypeKind.WILDCARD);
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
