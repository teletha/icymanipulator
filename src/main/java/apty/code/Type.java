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
import java.util.stream.Stream;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;

import apty.Apty;
import apty.ClassLike;
import apty.MethodLike;

public class Type implements Codable, ClassLike {

    /** The reusable wild card type. */
    public static final Type WILD = Type.var("?");

    /** The package name. */
    public final String packageName;

    /** The base name. */
    public final String base;

    /** The managed variables. */
    public final List<Type> variables;

    /** The type kind. */
    public final TypeKind kind;

    /** The actual type holder. */
    private final ClassLike detector;

    /**
     * Build Type.
     * 
     * @param fqcn
     * @param variables
     * @param kind
     */
    private Type(String fqcn, List<Type> variables, TypeKind kind, ClassLike detector) {
        this(computePackage(fqcn), computeName(fqcn), variables, kind, detector);
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
    private Type(String packageName, String base, List<Type> variables, TypeKind kind, ClassLike detector) {
        this.packageName = packageName;
        this.base = base;
        this.variables = variables;
        this.kind = kind;
        this.detector = detector;
    }

    /**
     * Compute fully qualified class name.
     * 
     * @return
     */
    public String name() {
        if (packageName.isEmpty()) {
            return base;
        } else {
            return packageName + "." + base;
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
     * Returns the elements of this enum class or empty if this Class object does not represent an
     * enum type.
     * 
     * @return A stream containing the values comprising the enum class represented by this type in
     *         the order they're declared, or empty if this type does not represent an enum type.
     */
    @Override
    public Stream<String> getEnumConstants() {
        return detector.getEnumConstants();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<MethodLike> getMethod() {
        return detector.getMethod();
    }

    /**
     * Check whether this is primitive type or not.
     * 
     * @return A result.
     */
    @Override
    public boolean isPrimitive() {
        return kind.isPrimitive();
    }

    /**
     * Check whether this is array type or not.
     * 
     * @return A result.
     */
    @Override
    public boolean isArray() {
        return kind == TypeKind.ARRAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnnotation() {
        return detector.isAnnotation();
    }

    /**
     * Check whether this is enum type or not.
     * 
     * @return A result.
     */
    @Override
    public boolean isEnum() {
        return detector.isEnum();
    }

    /**
     * Check whether this type is interface or not.
     * 
     * @return A result.
     */
    @Override
    public boolean isInterface() {
        return detector.isInterface();
    }

    /**
     * Check whether this is void type or not.
     * 
     * @return A result.
     */
    public boolean isVoid() {
        return kind == TypeKind.VOID;
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
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Element type) {
        return is(type.asType());
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(TypeMirror type) {
        return is(Type.of(type));
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(Class parent) {
        return detector.isAssignableFrom(parent);
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(TypeElement parent) {
        return detector.isAssignableFrom(parent);
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(TypeMirror parent) {
        return detector.isAssignableFrom(parent);
    }

    /**
     * Create raw type, all variables are removed.
     * 
     * @return
     */
    public Type raw() {
        return new Type(packageName, base, List.of(), kind, detector);
    }

    /**
     * Create declared type, all variables are viewable.
     * 
     * @return
     */
    public Type declared() {
        return new Type(packageName, base, variables, TypeKind.INTERSECTION, detector);
    }

    /**
     * Create vararged type if this type is array.
     * 
     * @return
     */
    public Type varargnize() {
        if (kind == TypeKind.ARRAY) {
            return new Type(packageName, base.replaceAll("\\[\\]$", "..."), variables, TypeKind.DECLARED, detector);
        } else {
            return this;
        }
    }

    public Type stripWild() {
        if (kind == TypeKind.WILDCARD) {
            return variables.get(0);
        } else {
            return this;
        }
    }

    /**
     * Create {@link Type} list with this and the specifieds.
     * 
     * @param types
     * @return
     */
    public List<Type> with(Object... types) {
        List<Type> list = new ArrayList();
        list.add(this);
        list.addAll(flatten(types));
        return list;
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

        case INTERSECTION:
            StringJoiner vars = new StringJoiner(" & ", " extends ", "").setEmptyValue("");
            variables.stream().forEach(v -> vars.add(v.write(coder)));
            return base.concat(vars.toString());

        case WILDCARD:
            vars = new StringJoiner(" & ", base, "");
            variables.stream().forEach(v -> vars.add(v.write(coder)));
            return vars.toString();

        default:
            vars = new StringJoiner(", ", "<", ">").setEmptyValue("");
            variables.stream().forEach(v -> vars.add(v.write(coder)));
            return coder.imports(packageName, base).concat(vars.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(packageName, base, variables, kind.name());
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

        if (!base.equals(other.base)) {
            return false;
        }

        if (!variables.equals(other.variables)) {
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
     * Flatten all types.
     * 
     * @param types
     * @return
     */
    private static List<Type> flatten(Object... types) {
        List<Type> list = new ArrayList();

        for (Object type : types) {
            if (type instanceof String) {
                list.add(Type.var((String) type));
            } else if (type instanceof Class) {
                list.add(Type.of((Class) type));
            } else if (type instanceof Type) {
                list.add((Type) type);
            } else if (type instanceof List) {
                ((List) type).stream().forEach(item -> list.addAll(flatten(item)));
            } else {
                throw new Error("Bug!");
            }
        }
        return list;
    }

    /**
     * Build {@link Type} from the variable name.
     * 
     * @param name A variable name.
     * @param parameters A list of parameter variables.
     * @return The created {@link Type}.
     */
    public static final Type var(String name, Object... parameters) {
        return new Type("", name, flatten(parameters), TypeKind.INTERSECTION, Apty.Unknown);
    }

    /**
     * Build {@link Type} from the class name.
     * 
     * @param fqcn A fully qualified class name.
     * @param parameters A list of parameter variables.
     * @return The created {@link Type}.
     */
    public static final Type of(String fqcn, Object... parameter) {
        return new Type(fqcn, flatten(parameter), TypeKind.DECLARED, Apty.detect(fqcn));
    }

    /**
     * Build {@link Type} from {@link Class}.
     * 
     * @param type A base type.
     * @param parameters A list of parameter variables.
     * @return The created {@link Type}.
     */
    public static final Type of(Class type, Object... parameters) {
        if (type.isPrimitive()) {
            return new Type(type.getName(), flatten(parameters), TypeKind.valueOf(type.getName().toUpperCase()), Apty.detect(type));
        } else {
            return new Type(type.getName(), flatten(parameters), TypeKind.DECLARED, Apty.detect(type));
        }
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
            return new Type(type.toString(), List.of(), kind, Apty.detect(type));

        case ARRAY:
            return new Type(type.toString(), List.of(), kind, Apty.detect(type));

        case TYPEVAR:
            TypeVariable var = (TypeVariable) type;
            TypeMirror upper = var.getUpperBound();
            if (!Apty.same(upper, Object.class)) {
                return new Type("", type.toString(), List.of(of(upper)), kind, Apty.detect(type));
            }
            return new Type("", type.toString(), List.of(), kind, Apty.detect(type));

        case WILDCARD:
            WildcardType wild = (WildcardType) type;
            if (wild.getExtendsBound() != null)
                return new Type("", "? extends ", List.of(of(wild.getExtendsBound())), kind, Apty.detect(type));
            if (wild.getSuperBound() != null) return new Type("", "? super ", List.of(of(wild.getSuperBound())), kind, Apty.detect(type));
            return new Type("", "?", List.of(), kind, Apty.detect(type));

        case DECLARED:
            DeclaredType declared = (DeclaredType) type;
            String fqcn = ((TypeElement) declared.asElement()).getQualifiedName().toString();
            if (variables == null) variables = declared.getTypeArguments().stream().map(Type::of).collect(Collectors.toList());
            return new Type(fqcn, variables, TypeKind.DECLARED, Apty.detect(type));

        default:
            throw new Error("Bug! " + type);
        }
    }

}
