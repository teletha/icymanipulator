/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.group;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.group.model.CopiableGroup;
import icy.manipulator.property.group.model.CopiableGroupModel;

class CopiableGroupTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CopiableGroupModel.class);

    @Test
    void normal() {
        CopiableGroup o = CopiableGroup.with.name("ok", 10);
        assert o.name.equals("ok");
        assert o.size == 10;

        CopiableGroup copied = o.withSize(20);
        assert copied.name.equals("ok");
        assert copied.size == 20;
    }
}