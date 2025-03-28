/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.intercept;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.intercept.model.ReferenceDoubleSetter;
import icy.manipulator.property.intercept.model.ReferenceDoubleSetterModel;

class ReferenceDoubleSetterTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ReferenceDoubleSetterModel.class);

    @Test
    void reference() {
        ReferenceDoubleSetter o = ReferenceDoubleSetter.with.size(10);
        assert o.size == 10;
        assert o.square == 100;
    }
}