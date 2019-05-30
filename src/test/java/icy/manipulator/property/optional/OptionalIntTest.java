/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.optional.model.OptionalInt;
import icy.manipulator.property.optional.model.OptionalIntModel;

class OptionalIntTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OptionalIntModel.class);

    @Test
    void property() {
        OptionalInt o = OptionalInt.with.value(10);
        assert o.value.getAsInt() == 10;
    }
}
