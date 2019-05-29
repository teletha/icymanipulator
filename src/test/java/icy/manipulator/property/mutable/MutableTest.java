/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.mutable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.mutable.model.Mutable;
import icy.manipulator.property.mutable.model.MutableModel;

class MutableTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MutableModel.class);

    @Test
    void property() {
        Mutable o = Mutable.with.value("value");
        assert o.value.equals("value");

        o.value(now -> now + " updated");
        assert o.value.equals("value updated");
    }
}
