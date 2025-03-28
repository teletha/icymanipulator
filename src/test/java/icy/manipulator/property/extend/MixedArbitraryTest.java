/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.extend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.extend.model.MixedArbitrary;
import icy.manipulator.property.extend.model.MixedArbitraryModel;

class MixedArbitraryTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MixedArbitraryModel.class);

    @Test
    void property() {
        MixedArbitrary o = MixedArbitrary.with.name("Name").age(18).optionAddress("Address").optionZip("543210");
        assert o.name.equals("Name");
        assert o.age == 18;
        assert o.optionAddress.equals("Address");
        assert o.optionZip.equals("543210");
    }
}