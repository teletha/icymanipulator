/*
 * Copyright (C) 2020 icymanipulator Development Team
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
import icy.manipulator.property.extend.model.MixedRequired;
import icy.manipulator.property.extend.model.MixedRequiredModel;

class MixedRequiredTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MixedRequiredModel.class);

    @Test
    void property() {
        MixedRequired o = MixedRequired.with.name("Name").age(18).zip("543210").optionAddress("Address");
        assert o.name.equals("Name");
        assert o.age == 18;
        assert o.optionAddress.equals("Address");
        assert o.zip.equals("543210");
    }
}