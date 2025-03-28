/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

import java.util.List;
import java.util.stream.Collectors;

import apty.code.Type;

public class TestableMethodLike extends MethodLike {

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     */
    public TestableMethodLike(String name, Class returnType) {
        this(name, returnType, List.of(), List.of());
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    public TestableMethodLike(String name, Class returnType, Class type1, String name1) {
        this(name, returnType, List.of(type1), List.of(name1));
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    public TestableMethodLike(String name, Class returnType, Class type1, String name1, Class type2, String name2) {
        this(name, returnType, List.of(type1, type2), List.of(name1, name2));
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    private TestableMethodLike(String name, Class returnType, List<Class> types, List<String> names) {
        super(name, Type.of(returnType), types.stream().map(Type::of).collect(Collectors.toUnmodifiableList()), names, "");
    }
}