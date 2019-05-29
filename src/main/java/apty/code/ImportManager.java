/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty.code;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor9;

import icy.manipulator.util.Strings;
import net.florianschoppmann.java.reflect.ReflectionTypes;

class ImportManager {

    /** The base package name. */
    private final String basePackage;

    /** The base class name. */
    private final String baseClass;

    /** The imported classes. */
    final Set<String> imports = new TreeSet();

    /** The imported classes. */
    private final Set<String> shorthands = new TreeSet();

    /** The utility. */
    private final ReflectionTypes types = ReflectionTypes.getInstance();

    /**
     * @param basePackage
     */
    ImportManager(String basePackage, String baseClass) {
        this.basePackage = basePackage;
        this.baseClass = baseClass;
    }

    /**
     * @param type
     */
    String require(Class type) {
        if (type.isPrimitive()) {
            if (type == int.class) {
                return require(types.getPrimitiveType(TypeKind.INT));
            } else if (type == long.class) {
                return require(types.getPrimitiveType(TypeKind.LONG));
            } else if (type == float.class) {
                return require(types.getPrimitiveType(TypeKind.FLOAT));
            } else if (type == double.class) {
                return require(types.getPrimitiveType(TypeKind.DOUBLE));
            } else if (type == byte.class) {
                return require(types.getPrimitiveType(TypeKind.BYTE));
            } else if (type == short.class) {
                return require(types.getPrimitiveType(TypeKind.SHORT));
            } else if (type == char.class) {
                return require(types.getPrimitiveType(TypeKind.CHAR));
            } else if (type == boolean.class) {
                return require(types.getPrimitiveType(TypeKind.BOOLEAN));
            } else if (type == void.class) {
                return require(types.getNoType(TypeKind.VOID));
            }
        }
        return require(types.getDeclaredType(types.typeElement(type)));
    }

    /**
     * @param type
     */
    String require(TypeMirror type) {
        return type.accept(new TypeAnalyzer(), null);
    }

    /**
     * 
     */
    private final class TypeAnalyzer extends SimpleTypeVisitor9<String, Void> {

        /**
         * {@inheritDoc}
         */
        @Override
        public String visitDeclared(DeclaredType type, Void p) {
            StringJoiner join = new StringJoiner(", ", "<", ">").setEmptyValue("");
            type.getTypeArguments().stream().forEach(arg -> join.add(arg.accept(this, null)));

            return name(type).concat(join.toString());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String visitTypeVariable(TypeVariable type, Void p) {
            TypeMirror lower = type.getLowerBound();
            TypeMirror upper = type.getUpperBound();
            System.out.println(lower + "  " + upper);
            return super.visitTypeVariable(type, p);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String visitWildcard(WildcardType type, Void p) {
            TypeMirror extendType = type.getExtendsBound();

            if (extendType != null) {
                return "? extends ".concat(extendType.accept(this, null));
            }

            TypeMirror superType = type.getSuperBound();

            if (superType != null) {
                return "? super ".concat(superType.accept(this, null));
            }
            return "?";
        }

        /**
         * Analyze raw name and package.
         * 
         * @param type
         * @return
         */
        private String name(TypeMirror type) {
            String fqcn = types.toString(types.erasure(type));

            int index = fqcn.lastIndexOf(".");

            String packageName;
            String className;

            if (index == -1) {
                packageName = "";
                className = fqcn;
            } else {
                packageName = fqcn.substring(0, index);
                className = fqcn.substring(index + 1);
            }

            require(packageName, className);

            return className;
        }

        private void require(String packageName, String className) {
            // ignore java.lang
            if (packageName.equals("java.lang")) {
                return;
            }

            // ignore same package
            if (packageName.equals(basePackage)) {
                return;
            }

            String fqcn = packageName == null ? className : packageName + "." + className;

            // ignore inner classes
            if (fqcn.startsWith(basePackage + "." + baseClass + ".")) {
                return;
            }
            imports.add(Strings.sanitize(fqcn));
        }
    }
}
