/*
 * Copyright (C) 2020 icymanipulator Development Team
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
import icy.manipulator.property.optional.model.OptionalLong;
import icy.manipulator.property.optional.model.OptionalLongModel;

class OptionalLongTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OptionalLongModel.class);

    @Test
    void property() {
        OptionalLong o = OptionalLong.with.value(10);
        assert o.value.getAsLong() == 10;
    }
}