/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.generic.model.Generic;
import icy.manipulator.property.generic.model.GenericModel;
import icy.manipulator.property.generic.model.Wildcard;

class GenericTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, GenericModel.class);

    @Test
    void extendType() {
        Wildcard o = Wildcard.with.create().extendType(ArrayList.class);
        assert o.extendType == ArrayList.class;
    }

    @Test
    void superType() {
        Generic<String, Integer> generic = Generic.<String, Integer> with().value("ok").number(10);
    }
}
