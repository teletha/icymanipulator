/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import apty.Apty;
import apty.code.Type;

/**
 * Built-in support for {@link Optional} like classes.
 */
class RepeatableSupport {

    /** The built-in support. */
    private static final Map<DeclaredType, RepeatableSupport> supports = new HashMap();

    static {
        new RepeatableSupport(Collection.class) //
                .register("add$", "add", p -> p.type.variables.subList(0, 1))
                .register("add$All", "addAll", p -> List.of(Type.of(Collection.class, Type.wildcardExtend(p.type.variables.get(0)))));

        new RepeatableSupport(Map.class) //
                .register("put$", "put", p -> p.type.variables.subList(0, 2))
                .register("put$All", "putAll", p -> List.of(p.type));
    }

    /**
     * Detect built-in support by type.
     * 
     * @param type
     * @return
     */
    static final Optional<RepeatableSupport> by(TypeMirror type) {
        return supports.entrySet().stream().filter(e -> Apty.isSubType(type, e.getKey())).map(Entry::getValue).findFirst();
    }

    /** The optional type. */
    final DeclaredType type;

    /** The method holder. */
    final List<RepeatableMethod> methods = new ArrayList();

    /**
     * Register support.
     * 
     * @param optionalType
     * @param extractType
     * @param noneMethodName
     * @param collectMethod
     */
    private RepeatableSupport(Class type) {
        this.type = IcyManipulator.by(type);

        supports.put(this.type, this);
    }

    /**
     * Register supported methods.
     * 
     * @param implemetMethodNamePattern
     * @param delegationMethodName
     * @param paramTypeExtractor
     * @return
     */
    private RepeatableSupport register(String implemetMethodNamePattern, String delegationMethodName, Function<PropertyInfo, List<Type>> paramTypeExtractor) {
        methods.add(new RepeatableMethod(implemetMethodNamePattern, delegationMethodName, paramTypeExtractor));
        return this;
    }

    /**
     * 
     */
    static class RepeatableMethod {

        /** The implemetation method name pattern. */
        private final String implemetMethodNamePattern;

        /** The actual delegation method name. */
        private final String delegationMethodName;

        /** The parameter calculater. */
        private final Function<PropertyInfo, List<Type>> paramTypeExtractor;

        /**
         * @param implemetMethodNamePattern
         * @param delegationMethodName
         * @param paramTypeExtractor
         */
        private RepeatableMethod(String implemetMethodNamePattern, String delegationMethodName, Function<PropertyInfo, List<Type>> paramTypeExtractor) {
            this.implemetMethodNamePattern = implemetMethodNamePattern;
            this.delegationMethodName = delegationMethodName;
            this.paramTypeExtractor = paramTypeExtractor;
        }

        /**
         * Calculate the method for the property.
         * 
         * @param property
         * @return
         */
        MethodInfo method(PropertyInfo property) {
            AtomicInteger index = new AtomicInteger();
            String name = implemetMethodNamePattern.replace("$", property.capitalizeName());
            List<Type> types = paramTypeExtractor.apply(property).stream().map(Type::stripWild).collect(Collectors.toList());
            List<String> names = types.stream().map(t -> "value" + index.incrementAndGet()).collect(Collectors.toList());

            return new MethodInfo(name, Type.of(void.class), types, names, "");
        }

        String delegationMethodName(PropertyInfo property) {
            return delegationMethodName;
        }
    }
}
