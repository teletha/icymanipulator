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
import icy.manipulator.property.group.model.EnumGroup;
import icy.manipulator.property.group.model.EnumGroupModel;
import icy.manipulator.property.group.model.EnumGroupSubclassModel;

class EnumGroupSubclassTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, EnumGroupSubclassModel.class);

    @Test
    void normal() {
        EnumGroup o = EnumGroup.with.blue(10);
        assert o.color == EnumGroupModel.Color.Blue;
        assert o.size == 10;
    }
}