/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.AutoExpandList;
import icy.manipulator.property.overload.model.AutoExpandListModel;

class AutoExpandListTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandListModel.class);

    @Test
    void variableArguments() {
        AutoExpandList o = AutoExpandList.with.values("one", "two", "three");
        assert o.values.get(0).equals("one");
        assert o.values.get(1).equals("two");
        assert o.values.get(2).equals("three");
    }
}
