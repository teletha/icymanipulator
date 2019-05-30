/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.objectmethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.objectmethod.model.CustomEquals;
import icy.manipulator.property.objectmethod.model.CustomEqualsModel;

class CustomEqualsTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CustomEqualsModel.class);

    @Test
    void same() {
        CustomEquals o = CustomEquals.with.name("JoJo").age(16);
        CustomEquals same = CustomEquals.with.name("JoJo").age(16);
        assert o.equals(same);
    }

    @Test
    void diff() {
        CustomEquals o = CustomEquals.with.name("JoJo").age(16);
        CustomEquals diff = CustomEquals.with.name("JoJo").age(15);
        assert o.equals(diff);
    }
}
