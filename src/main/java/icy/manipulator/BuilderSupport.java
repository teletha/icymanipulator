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
import java.util.stream.Stream;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import apty.Apty;
import apty.code.Type;

/**
 * Built-in support for builder assistants.
 */
class BuilderSupport {

    /** The built-in support. */
    private static final Map<DeclaredType, BuilderSupport> supports = new HashMap();

    static {
        new BuilderSupport(Collection.class) //
                .register("add$", "add", p -> p.type.variables.subList(0, 1))
                .register("add$All", "addAll", p -> List.of(Type.of(Collection.class, Type.wildcardExtend(p.type.variables.get(0)))));

        new BuilderSupport(Map.class) //
                .register("put$", "put", p -> p.type.variables.subList(0, 2))
                .register("put$All", "putAll", p -> List.of(p.type));
    }

    /**
     * Detect built-in support by type.
     * 
     * @param type
     * @return
     */
    static final Optional<BuilderSupport> by(TypeMirror type) {
        return supports.entrySet().stream().filter(e -> Apty.isSubType(type, e.getKey())).map(Entry::getValue).findFirst();
    }

    /** The optional type. */
    private final DeclaredType type;

    /** The method holder. */
    private final List<RepeatableMethod> methods = new ArrayList();

    /**
     * Register support.
     * 
     * @param optionalType
     * @param extractType
     * @param noneMethodName
     * @param collectMethod
     */
    private BuilderSupport(Class type) {
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
    private BuilderSupport register(String implemetMethodNamePattern, String delegationMethodName, Function<PropertyInfo, List<Type>> paramTypeExtractor) {
        methods.add(new RepeatableMethod(implemetMethodNamePattern, delegationMethodName, paramTypeExtractor));
        return this;
    }

    /**
     * Compute the methods for the property.
     * 
     * @param property
     * @return
     */
    Stream<MethodInfo> computeMethodsFor(PropertyInfo property) {
        return methods.stream().map(m -> {
            AtomicInteger index = new AtomicInteger();
            String name = m.implemetMethodNamePattern.replace("$", property.capitalizeName());
            List<Type> types = m.paramTypeExtractor.apply(property).stream().map(Type::stripWild).collect(Collectors.toList());
            List<String> names = types.stream().map(t -> "value" + index.incrementAndGet()).collect(Collectors.toList());

            MethodInfo method = new MethodInfo(name, Type.of(void.class), types, names, "");
            method.userInfo = m.delegationMethodName;

            return method;
        });
    }

    /**
     * 
     */
    private static class RepeatableMethod {

        /** The implemetation method name pattern. */
        private final String implemetMethodNamePattern;

        /** The actual delegation method name. */
        private final String delegationMethodName;

        /** The parameter calculater. */
        private final Function<PropertyInfo, List<Type>> paramTypeExtractor;

        /**
         * Holder.
         * 
         * @param implemetMethodNamePattern
         * @param delegationMethodName
         * @param paramTypeExtractor
         */
        private RepeatableMethod(String implemetMethodNamePattern, String delegationMethodName, Function<PropertyInfo, List<Type>> paramTypeExtractor) {
            this.implemetMethodNamePattern = implemetMethodNamePattern;
            this.delegationMethodName = delegationMethodName;
            this.paramTypeExtractor = paramTypeExtractor;
        }
    }
}
