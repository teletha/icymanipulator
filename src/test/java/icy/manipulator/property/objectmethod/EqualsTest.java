/*
 * Copyright (C) 2021 icymanipulator Development Team
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
import icy.manipulator.property.objectmethod.model.Equals;
import icy.manipulator.property.objectmethod.model.EqualsModel;

class EqualsTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, EqualsModel.class);

    @Test
    void same() {
        Equals o = Equals.with.name("JoJo").age(16);
        Equals same = Equals.with.name("JoJo").age(16);
        assert o.equals(same);
    }

    @Test
    void diff() {
        Equals o = Equals.with.name("JoJo").age(16);
        Equals diff = Equals.with.name("JoJo").age(15);
        assert o.equals(diff) == false;
    }
}