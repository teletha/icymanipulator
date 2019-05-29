/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.model.Multiple;
import icy.manipulator.property.model.MultipleModel;

class MultipleTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MultipleModel.class);

    @Test
    void property() {
        Multiple instance = Multiple.with.name("Giorno Giovanna").stand("Gold Experience").age(15);
        assert instance.name.equals("Giorno Giovanna");
        assert instance.stand().equals("Gold Experience");
        assert instance.age == 15;
    }
}
