/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.AutoExpandMap;
import icy.manipulator.property.overload.model.AutoExpandMapModel;

class AutoExpandMapTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandMapModel.class);

    @Test
    void autoExpand() {
        AutoExpandMap o = AutoExpandMap.with.values("one", 1, "two", 2, "three", 3, "four", 4, "five", 5);
        assert o.values.get("one") == 1;
        assert o.values.get("two") == 2;
        assert o.values.get("three") == 3;
        assert o.values.get("four") == 4;
        assert o.values.get("five") == 5;
    }

    @Test
    void autoExpandWithGenerics() {
        AutoExpandMap o = AutoExpandMap.with.values(Map.of()).generics("one", () -> "1", "two", () -> "2");
        assert o.generics.get("one").get().equals("1");
        assert o.generics.get("two").get().equals("2");
    }
}
