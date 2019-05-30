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
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;

public class Type implements Codable {

    /** The package name. */
    private final String packagee;

    /** The base name. */
    private final String base;

    /** The managed variables. */
    private final List<Type> variables = new ArrayList();

    /** The type kind. */
    public final TypeKind kind;

    /**
     * Build Type.
     * 
     * @param fqcn
     * @param variables
     * @param kind
     */
    private Type(String fqcn, List<Type> variables, TypeKind kind) {
        this(computePackage(fqcn), computeName(fqcn), variables, kind);
    }

    /**
     * Compute package name.
     * 
     * @param fqcn
     * @return
     */
    private static String computePackage(String fqcn) {
        int index = fqcn.lastIndexOf(".");

        return index == -1 ? "" : fqcn.substring(0, index);
    }

    /**
     * Compute base name.
     * 
     * @param fqcn
     * @return
     */
    private static String computeName(String fqcn) {
        int index = fqcn.lastIndexOf(".");

        return index == -1 ? fqcn : fqcn.substring(index + 1);
    }

    /**
     * Build Type.
     * 
     * @param packageName
     * @param base
     * @param variables
     * @param kind
     */
    private Type(String packageName, String base, List<Type> variables, TypeKind kind) {
        this.packagee = packageName;
        this.base = base;
        this.variables.addAll(variables);
        this.kind = kind;
    }

    /**
     * Compute fully qualified class name.
     * 
     * @return
     */
    public String name() {
        if (packagee.isEmpty()) {
            return base;
        } else {
            return packagee + "." + base;
        }
    }

    /**
     * Compute default value literal.
     * 
     * @return
     */
    public String defaultValue() {
        switch (kind) {
        case INT:
        case BYTE:
        case SHORT:
            return "0";

        case LONG:
            return "0L";

        case FLOAT:
            return "0";

        case DOUBLE:
            return "0D";

        case CHAR:
            return "' '";

        case BOOLEAN:
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
        return name().equals(type.getName());
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Type type) {
        return name().equals(type.name());
    }

    /**
     * Create vararged type if this type is array.
     * 
     * @return
     */
    public Type varargnize() {
        if (kind == TypeKind.ARRAY) {
            return new Type(packagee, base.replaceAll("\\[\\]$", "..."), variables, TypeKind.DECLARED);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        switch (kind) {
        case BOOLEAN:
        case INT:
        case LONG:
        case FLOAT:
        case DOUBLE:
        case CHAR:
        case BYTE:
        case SHORT:
        case TYPEVAR:
            return base;

        case WILDCARD:
            StringJoiner vars = new StringJoiner(" & ", base, "");
            variables.forEach(v -> vars.add(v.write(coder)));
            return vars.toString();

        default:
            vars = new StringJoiner(", ", "<", ">").setEmptyValue("");
            for (Type type : variables) {
                vars.add(type.write(coder));
            }
            return coder.imports(packagee, base).concat(vars.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(packagee, base, variables, kind.name());
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

        if (!packagee.equals(other.packagee)) {
            return false;
        }

        if (!base.equals(other.base)) {
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name();
    }

    /**
     * Build {@link Type} from the variable name.
     * 
     * @param name A variable name.
     * @return The created {@link Type}.
     */
    public static final Type variable(String name) {
        return new Type("", name, List.of(), TypeKind.TYPEVAR);
    }

    /**
     * Build {@link Type} from the class name.
     * 
     * @param fqcn A fully qualified class name.
     * @return The created {@link Type}.
     */
    public static final Type of(String fqcn) {
        return new Type(fqcn, List.of(), TypeKind.DECLARED);
    }

    /**
     * Build {@link Type} from {@link Class}.
     * 
     * @param type A base type.
     * @return The created {@link Type}.
     */
    public static final Type of(Class type) {
        return new Type(type.getName(), List.of(), TypeKind.DECLARED);
    }

    /**
     * Build {@link Type} from {@link TypeElement}
     * 
     * @param type A base type.
     * @return The created {@link Type}.
     */
    public static final Type of(TypeElement type) {
        return of(type.asType());
    }

    /**
     * Build {@link Type} from {@link TypeMirror}.
     * 
     * @param type A base type.
     * @return The created {@link Type}.
     */
    public static final Type of(TypeMirror type) {
        return of(type, null);
    }

    /**
     * Build {@link Type} from {@link TypeMirror} and its type variables.
     * 
     * @param type A base type.
     * @param variables A list of type variables.
     * @return The created {@link Type}.
     */
    public static final Type of(TypeMirror type, List<Type> variables) {
        TypeKind kind = type.getKind();

        switch (kind) {
        case BOOLEAN:
        case INT:
        case LONG:
        case FLOAT:
        case DOUBLE:
        case CHAR:
        case BYTE:
        case SHORT:
        case VOID:
            return new Type(type.toString(), List.of(), kind);

        case ARRAY:
            return new Type(type.toString(), List.of(), kind);

        case TYPEVAR:
            return new Type("", type.toString(), List.of(), kind);

        case WILDCARD:
            WildcardType wild = (WildcardType) type;
            if (wild.getExtendsBound() != null) return new Type("", "? extends ", List.of(of(wild.getExtendsBound())), kind);
            if (wild.getSuperBound() != null) return new Type("", "? super ", List.of(of(wild.getSuperBound())), kind);
            return new Type("", "?", List.of(), kind);

        case DECLARED:
            DeclaredType declared = (DeclaredType) type;
            String fqcn = ((TypeElement) declared.asElement()).getQualifiedName().toString();
            if (variables == null) variables = declared.getTypeArguments().stream().map(Type::of).collect(Collectors.toList());
            return new Type(fqcn, variables, TypeKind.DECLARED);

        default:
            throw new Error("Bug! " + type);
        }
    }
}