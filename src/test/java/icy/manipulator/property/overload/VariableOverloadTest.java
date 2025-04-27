/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.VariableOverload;
import icy.manipulator.property.overload.model.VariableOverloadModel;

class VariableOverloadTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, VariableOverloadModel.class);

    @Test
    void overload() {
        VariableOverload o = VariableOverload.with.one();
        assert o.num.is("1");
    }
}