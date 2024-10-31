/*
 * Copyright (C) 2021 icymanipulator Development Team
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
import icy.manipulator.property.group.model.OverloadGroup;
import icy.manipulator.property.group.model.OverloadGroupModel;

class OverloadGroupTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OverloadGroupModel.class);

    @Test
    void normal() {
        OverloadGroup o = OverloadGroup.with.name("ok", 10);
        assert o.name.equals("ok");
        assert o.size == 10;
    }
}