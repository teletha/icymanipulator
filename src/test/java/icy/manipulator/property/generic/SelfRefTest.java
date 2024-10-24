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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.generic.model.SelfRef;
import icy.manipulator.property.generic.model.SelfRefModel;

class SelfRefTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, SelfRefModel.class);

    @Test
    void generic() {
        SelfRef ref = SelfRef.with().value(10).calc(x -> x.value() * 2);
        assert ref.value == 10;
        assert ref.calc.applyAsInt(ref) == 20;
    }
}