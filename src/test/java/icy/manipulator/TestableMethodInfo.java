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

import java.util.List;
import java.util.stream.Collectors;

import apty.Type;

class TestableMethodInfo extends MethodInfo {

    /**
     * Create {@link MethodInfo}.
     * 
     * @param name
     * @param returnType
     */
    TestableMethodInfo(String name, Class returnType) {
        this(name, returnType, List.of(), List.of());
    }

    /**
     * Create {@link MethodInfo}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    TestableMethodInfo(String name, Class returnType, Class type1, String name1) {
        this(name, returnType, List.of(type1), List.of(name1));
    }

    /**
     * Create {@link MethodInfo}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    TestableMethodInfo(String name, Class returnType, Class type1, String name1, Class type2, String name2) {
        this(name, returnType, List.of(type1, type2), List.of(name1, name2));
    }

    /**
     * Create {@link MethodInfo}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    private TestableMethodInfo(String name, Class returnType, List<Class> types, List<String> names) {
        super(name, Type.of(returnType), types.stream().map(Type::of).collect(Collectors.toUnmodifiableList()), names, "");
    }
}
