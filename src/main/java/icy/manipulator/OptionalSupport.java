/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Function;

import apty.code.Type;

/**
 * Built-in support for {@link Optional} like classes.
 */
class OptionalSupport {

    /** The built-in support. */
    private static final Map<Type, OptionalSupport> supports = new HashMap();

    static {
        new OptionalSupport(Type.of(Optional.class), p -> p.type.variables.get(0), "empty", "of");
        new OptionalSupport(Type.of(OptionalInt.class), p -> Type.of(int.class), "empty", "of");
        new OptionalSupport(Type.of(OptionalLong.class), p -> Type.of(long.class), "empty", "of");
        new OptionalSupport(Type.of(OptionalDouble.class), p -> Type.of(double.class), "empty", "of");
        new OptionalSupport(Type.of("com.google.common.base.Optional"), p -> p.type.variables.get(0), "absent", "of");
        new OptionalSupport(Type.of("com.atlassian.fugue.Option"), p -> p.type.variables.get(0), "none", "some");
        new OptionalSupport(Type.of("io.atlassian.fugue.Option"), p -> p.type.variables.get(0), "none", "some");
        new OptionalSupport(Type.of("fj.data.Option"), p -> p.type.variables.get(0), "none", "some");
        new OptionalSupport(Type.of("io.vavr.control.Option"), p -> p.type.variables.get(0), "none", "some");
        new OptionalSupport(Type.of("kiss.Variable"), p -> p.type.variables.get(0), "empty", "of");
    }

    /**
     * Detect built-in support by type.
     * 
     * @param type
     * @return
     */
    static final Optional<OptionalSupport> by(Type type) {
        return supports.entrySet().stream().filter(e -> e.getKey().is(type)).map(Entry::getValue).findFirst();
    }

    /** The optional type. */
    final Type type;

    /** The type extractor. */
    final Function<PropertyInfo, Type> extractor;

    /** The empty method name. */
    final String noneMethod;

    /** The value method name. */
    final String someMethod;

    /**
     * Register support.
     * 
     * @param optionalType
     * @param extractType
     * @param noneMethodName
     * @param someMethodName
     */
    private OptionalSupport(Type optionalType, Function<PropertyInfo, Type> extractType, String noneMethodName, String someMethodName) {
        this.type = Objects.requireNonNull(optionalType);
        this.extractor = Objects.requireNonNull(extractType);
        this.noneMethod = Objects.requireNonNull(noneMethodName);
        this.someMethod = Objects.requireNonNull(someMethodName);

        supports.put(optionalType, this);
    }
}