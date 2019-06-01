/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.collection;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.collection.model.List;
import icy.manipulator.property.collection.model.ListModel;

class ListTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ListModel.class);

    @Test
    void property() {
        List o = List.with.name("name")
                .values(new ArrayList<>())
                .addValues("value")
                .addValuesAll(java.util.List.of("from", "list"))
                .addValues("any order")
                .age(15);

        assert o.name.equals("name");
        assert o.values.contains("value");
        assert o.values.contains("from");
        assert o.values.contains("list");
        assert o.values.contains("any order");
        assert o.age == 15;
    }
}
