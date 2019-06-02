/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.base.model.Array;
import icy.manipulator.property.base.model.ArrayModel;

class ArrayTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ArrayModel.class);

    @Test
    void array() {
        Array o = Array.with.names(new String[] {"one", "two"});
        assert o.names[0].equals("one");
        assert o.names[1].equals("two");
    }

    @Test
    void vararg() {
        Array o = Array.with.names("one", "two");
        assert o.names[0].equals("one");
        assert o.names[1].equals("two");
    }
}
