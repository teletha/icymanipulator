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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import apty.code.Type;

/**
 * Built-in support for {@link Optional} like classes.
 */
class CollectionSupport {

    /** The built-in support. */
    private static final Map<Type, CollectionSupport> supports = new HashMap();

    static {
        new CollectionSupport(Type.of(List.class)) //
                .register("add$", "add", p -> p.type.variables.get(0))
                .register("add$All", "addAll", p -> Type.of(Collection.class));
    }

    /**
     * Detect built-in support by type.
     * 
     * @param type
     * @return
     */
    static final Optional<CollectionSupport> by(Type type) {
        return supports.entrySet().stream().filter(e -> e.getKey().is(type)).map(Entry::getValue).findFirst();
    }

    /** The optional type. */
    final Type type;

    /**
     * Register support.
     * 
     * @param optionalType
     * @param extractType
     * @param noneMethodName
     * @param collectMethod
     */
    private CollectionSupport(Type optionalType) {
        this.type = Objects.requireNonNull(optionalType);

        supports.put(optionalType, this);
    }

    private CollectionSupport register(String methodName, String impleMethodName, Function<PropertyInfo, Type> prameterType) {
        return this;
    }
}
