/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.group;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.group.model.EnumGroupModel;
import icy.manipulator.property.group.model.Group;

class EnumGroupTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, EnumGroupModel.class);

    @Test
    void normal() {
        Group o = Group.with.x(1, 5).z(3);
        assert o.x == 1;
        assert o.y == 5;
        assert o.z == 3;
    }
}
