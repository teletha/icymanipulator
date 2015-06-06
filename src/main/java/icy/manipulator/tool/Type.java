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

import java.util.List;
import java.util.StringJoiner;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/**
 * @version 2015/06/02 23:07:45
 */
class Type {

    /** The package name. */
    final String packageName;

    /** The class name. */
    final String className;

    /** The variable expression. */
    final String variables;

    /** The generic flag. */
    final boolean generic;

    /**
     * @param packageName
     * @param className
     * @param generics
     */
    Type(String fqcn, List<? extends TypeMirror> generics) {
        if (generics == null || generics.isEmpty()) {
            variables = "";
        } else {
            StringJoiner joiner = new StringJoiner(", ", "<", ">");
            for (TypeMirror generic : generics) {
                joiner.add(IcyManipulator.importer.use(Type.of(generic)));
            }
            variables = joiner.toString();
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
     * @param variables
     * @param generic
     */
    Type(String packageName, String className, String variables, boolean generic) {
        this.packageName = packageName;
        this.className = className;
        this.variables = variables;
        this.generic = generic;
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
     * Create {@link Type} from {@link Class}.
     * </p>
     * 
     * @param type
     * @return
     */
    static Type of(Class type) {
        return new Type(type.getPackage().getName(), type.getSimpleName(), "", false);
    }

    /**
     * <p>
     * Create {@link Type} from {@link TypeVariable}.
     * </p>
     * 
     * @param type
     * @return
     */
    static Type of(TypeVariable type) {
        return new Type("", type.toString(), "", true);
    }

    /**
     * <p>
     * Create {@link Type} from {@link TypeMirror}.
     * </p>
     * 
     * @param type
     * @return
     */
    static Type of(TypeMirror type) {
        return type.accept(new TypeDetector(), null);
    }

    /**
     * <p>
     * Create {@link Type} from {@link TypeVariable}.
     * </p>
     * 
     * @param type
     * @return
     */
    static Type of(TypeElement type) {
        return new Type(type.getQualifiedName().toString(), ((DeclaredType) type.asType()).getTypeArguments());
    }

    /**
     * <p>
     * Create {@link Type} from {@link TypeVariable}.
     * </p>
     * 
     * @param type
     * @return
     */
    static Type of(DeclaredType type) {
        return new Type(((TypeElement) type.asElement()).getQualifiedName().toString(), type.getTypeArguments());
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
        case "boolean":
        case "void":
            return true;

        default:
            return false;
        }
    }

    /**
     * <p>
     * Check generic type.
     * </p>
     * 
     * @return
     */
    boolean isGeneric() {
        return generic;
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
            return of(Integer.class);

        case "long":
            return of(Long.class);

        case "float":
            return of(Float.class);

        case "double":
            return of(Double.class);

        case "byte":
            return of(Byte.class);

        case "char":
            return of(Character.class);

        case "boolean":
            return of(Boolean.class);

        case "void":
            return of(Void.class);

        default:
            return this;
        }
    }
}