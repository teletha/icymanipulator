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
import icy.manipulator.property.group.model.Group;
import icy.manipulator.property.group.model.GroupModel;

class GroupTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, GroupModel.class);

    @Test
    void normal() {
        Group o = Group.with.x(1, 5).z(3);
        assert o.x() == 1;
        assert o.y() == 5;
        assert o.z() == 3;
    }
}