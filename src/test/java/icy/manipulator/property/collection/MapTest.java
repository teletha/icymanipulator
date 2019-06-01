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

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.collection.model.Map;
import icy.manipulator.property.collection.model.MapModel;

class MapTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MapModel.class);

    @Test
    void property() {
        Map o = Map.with.values(new HashMap<>())
                .putValues("key1", 1)
                .putValuesAll(java.util.Map.of("map1", 10, "map2", 20))
                .putValues("key2", 2)
                .age(15);

        assert o.values.get("key1") == 1;
        assert o.values.get("key2") == 2;
        assert o.values.get("map1") == 10;
        assert o.values.get("map2") == 20;
        assert o.age == 15;
    }
}
