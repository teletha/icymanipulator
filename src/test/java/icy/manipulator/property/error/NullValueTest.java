/*
 * Copyright (C) 2020 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.error;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.error.model.NullValue;
import icy.manipulator.property.error.model.NullValueModel;

class NullValueTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, NullValueModel.class);

    @Test
    void rejectNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NullValue.with.rejectNull(null));
    }

    @Test
    void acceptNull() {
        NullValue o = NullValue.with.rejectNull("ok").acceptNull(null);
        assert o.acceptNull == null;
    }

    @Test
    void defaultNull() {
        NullValue o = NullValue.with.rejectNull("ok").acceptNull("ok").defaultValue(null);
        assert o.defaultValue.equals("default");
    }
}