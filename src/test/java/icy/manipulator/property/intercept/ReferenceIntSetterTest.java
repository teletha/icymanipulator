/*
 * Copyright (C) 2020 icymanipulator Development Team
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
import icy.manipulator.property.intercept.model.ReferenceIntSetter;
import icy.manipulator.property.intercept.model.ReferenceIntSetterModel;

class ReferenceIntSetterTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ReferenceIntSetterModel.class);

    @Test
    void reference() {
        ReferenceIntSetter o = ReferenceIntSetter.with.size(10);
        assert o.size == 10;
        assert o.square == 100;
    }
}