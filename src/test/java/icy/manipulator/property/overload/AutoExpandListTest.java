/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.AutoExpandList;
import icy.manipulator.property.overload.model.AutoExpandListModel;

class AutoExpandListTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandListModel.class);

    @Test
    void autoExpand() {
        AutoExpandList o = AutoExpandList.with.values("one", "two", "three");
        assert o.values.get(0).equals("one");
        assert o.values.get(1).equals("two");
        assert o.values.get(2).equals("three");
    }

    @Test
    void autoExpandWithGenerics() {
        AutoExpandList o = AutoExpandList.with.values(List.of()).generics(() -> "a", () -> "b", () -> "c");
        assert o.generics.get(0).get().equals("a");
        assert o.generics.get(1).get().equals("b");
        assert o.generics.get(2).get().equals("c");
    }
}