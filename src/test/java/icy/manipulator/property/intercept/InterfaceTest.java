/*
 * Copyright (C) 2019 icymanipulator Development Team
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
import icy.manipulator.property.intercept.model.Interface;
import icy.manipulator.property.intercept.model.InterfaceModel;

class InterfaceTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, InterfaceModel.class);

    @Test
    void intercept() {
        Interface normal = Interface.with.size(10);
        assert normal.size == 10;

        Interface normalized = Interface.with.size(-10);
        assert normalized.size == 0;
    }
}
