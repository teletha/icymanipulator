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
import icy.manipulator.property.group.model.EnumGroup;
import icy.manipulator.property.group.model.EnumGroupModel;

class EnumGroupTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, EnumGroupModel.class);

    @Test
    void normal() {
        EnumGroup o = EnumGroup.with.blue(10);
        assert o.color == EnumGroupModel.Color.Blue;
        assert o.size == 10;
    }
}