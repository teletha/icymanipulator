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
        new CollectionSupport(Type.of(List.class), p -> p.type.variables.get(0), Type.of(ArrayList.class), "add");
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

    /** The type extractor. */
    final Function<PropertyInfo, Type> extractor;

    /** The empty method name. */
    final Type impl;

    /** The value method name. */
    final String collectMethod;

    /**
     * Register support.
     * 
     * @param optionalType
     * @param extractType
     * @param noneMethodName
     * @param collectMethod
     */
    private CollectionSupport(Type optionalType, Function<PropertyInfo, Type> extractType, Type impl, String collectMethod) {
        this.type = Objects.requireNonNull(optionalType);
        this.extractor = Objects.requireNonNull(extractType);
        this.impl = Objects.requireNonNull(impl);
        this.collectMethod = Objects.requireNonNull(collectMethod);

        supports.put(optionalType, this);
    }
}
