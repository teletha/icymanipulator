/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
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
import icy.manipulator.property.objectmethod.model.HashCode;
import icy.manipulator.property.objectmethod.model.HashCodeModel;

class HashCodeTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, HashCodeModel.class);

    @Test
    void generated() {
        HashCode o = HashCode.with.name("JoJo").age(16);
        assert o.hashCode() == 71722887;
    }
}