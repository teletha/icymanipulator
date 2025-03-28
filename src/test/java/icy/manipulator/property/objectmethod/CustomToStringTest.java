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
import icy.manipulator.property.objectmethod.model.CustomToString;
import icy.manipulator.property.objectmethod.model.CustomToStringModel;

class CustomToStringTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CustomToStringModel.class);

    @Test
    void custom() {
        CustomToString o = CustomToString.with.name("Kirito").age(16);
        assert o.toString().equals("[Kirito:16]");
    }
}