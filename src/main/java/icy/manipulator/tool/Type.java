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

import javax.lang.model.type.TypeMirror;

/**
 * @version 2015/06/07 0:34:00
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
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param type
     */
    Type(Class type) {
        this(type.getPackage().getName(), type.getSimpleName(), "", false);
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
        if (generics == null || generics.isEmpty()) {
            variables = "";
        } else {
            StringJoiner joiner = new StringJoiner(", ", "<", ">");
            for (TypeMirror generic : generics) {
                joiner.add(IcyManipulator.importer.use(TypeDetector.detect(generic)));
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

}