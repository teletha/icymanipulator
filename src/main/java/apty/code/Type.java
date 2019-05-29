/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor9;

/**
 * @version 2015/06/07 0:34:00
 */
public class Type implements Codable {

    /** The identical notation. */
    protected final String className;

    /** The variable expression. */
    protected final List<Type> variables = new ArrayList();

    /** The type kind. */
    protected final TypeKind kind;

    /**
     * @param className
     * @param variables
     * @param kind
     */
    protected Type(String className, List<Type> variables, TypeKind kind) {
        this.className = className;
        this.variables.addAll(variables);
        this.kind = kind;
    }

    /**
     * Compute the suitable notation of this type.
     * 
     * @return
     */
    public String notation() {
        return className;
    }

    protected String imports(ImportManager manager) {

        if (kind == TypeKind.WILDCARD) {
            StringJoiner join = new StringJoiner(" & ", className, "");
            variables.forEach(v -> join.add(manager.require(v)));
            return join.toString();
        }

        StringJoiner types = new StringJoiner(", ", "<", ">").setEmptyValue("");
        for (Type variable : variables) {
            types.add(manager.require(variable));
        }
        return manager.require(className).concat(types.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        StringJoiner joiner = new StringJoiner(", ", "<", ">").setEmptyValue("");
        for (Type type : variables) {
            joiner.add(type.write(coder));
        }

        switch (kind) {
        case DECLARED:
        case ARRAY:
            return coder.require(className).concat(joiner.toString());
        }

        if (kind == TypeKind.WILDCARD) {
            StringJoiner join = new StringJoiner(" & ", className, "");
            variables.forEach(v -> join.add(v.write(coder)));
            return join.toString();
        }

        return className.concat(joiner.toString());
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

    public boolean isVoid() {
        return className.equals("void");
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
        return notation().equals(type.getName());
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Type type) {
        return notation().equals(type.notation());
    }

    /**
     * Create vararged type if this type is array.
     * 
     * @return
     */
    public final Type varargnize() {
        if (kind == TypeKind.ARRAY) {
            return new VarArgs(className.replaceAll("\\[\\]$", ""));
        } else {
            return this;
        }
    }

    /**
     * 
     */
    private static class VarArgs extends Type {

        /**
         * @param notation
         * @param variables
         * @param kind
         */
        public VarArgs(String notation) {
            super(notation, List.of(), TypeKind.DECLARED);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String imports(ImportManager manager) {
            return manager.require(className).concat("...");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(className, variables, kind);
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

        if (!className.equals(other.className)) {
            return false;
        }

        if (!variables.toString().equals(other.variables.toString())) {
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
        return new Type(name, List.of(), TypeKind.TYPEVAR);
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
        return new Type(fqcn, List.of(), TypeKind.DECLARED);
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
        return new Type(type.getName(), List.of(), TypeKind.DECLARED);
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
    private static class TypeDetector extends SimpleTypeVisitor9<Type, List<Type>> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitPrimitive(PrimitiveType type, List<Type> p) {
            return new Type(type.toString(), List.of(), type.getKind());
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
            return new Type(type.toString(), List.of(), TypeKind.ARRAY);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitDeclared(DeclaredType type, List<Type> outer) {
            String fqcn = ((TypeElement) type.asElement()).getQualifiedName().toString();
            List<Type> variables = outer != null ? outer : type.getTypeArguments().stream().map(Type::of).collect(Collectors.toList());

            return new Type(fqcn, variables, TypeKind.DECLARED);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitTypeVariable(TypeVariable t, List<Type> p) {
            return new Type(t.toString(), List.of(), TypeKind.TYPEVAR);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitWildcard(WildcardType type, List<Type> p) {
            TypeMirror extendType = type.getExtendsBound();

            if (extendType != null) {
                return new Type("? extends ", List.of(extendType.accept(this, null)), TypeKind.WILDCARD);
            }

            TypeMirror superType = type.getSuperBound();

            if (superType != null) {
                return new Type("? super ", List.of(superType.accept(this, null)), TypeKind.WILDCARD);
            }

            return new Type("?", List.of(), TypeKind.WILDCARD);
        }
    }
}
