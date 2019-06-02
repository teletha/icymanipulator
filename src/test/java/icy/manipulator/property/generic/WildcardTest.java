/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.generic.model.Wildcard;
import icy.manipulator.property.generic.model.WildcardModel;

class WildcardTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, WildcardModel.class);

    @Test
    void extendType() {
        Wildcard o = Wildcard.with.create().extendType(ArrayList.class);
        assert o.extendType == ArrayList.class;
    }

    @Test
    void superType() {
        List<Integer> integers = new ArrayList();
        Wildcard o = Wildcard.with.create().superType(integers);
        assert o.superType == integers;

        List<Number> numbers = new ArrayList();
        o = Wildcard.with.create().superType(numbers);
        assert o.superType == numbers;
    }

    @Test
    void wildcard() {
        Wildcard o = Wildcard.with.create().wildcard(() -> "10");
        assert o.wildcard.get().equals("10");
    }

    @Test
    void combine() {
        Map<String, List<Class<? extends Number>>> map = new HashMap();
        Wildcard o = Wildcard.with.create().combine(map);
        assert o.combine == map;
    }
}
