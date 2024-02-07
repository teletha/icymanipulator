/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.generic.model.Generic;
import icy.manipulator.property.generic.model.GenericModel;

class GenericTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, GenericModel.class);

    @Test
    void generic() {
        Generic<String, Integer> o = Generic.<String, Integer> with().value("value").number(10).mapper(Map.of("key", 20)).text("X");
        assert o.value.equals("value");
        assert o.number == 10;
        assert o.mapper.get("key") == 20;

    }
}