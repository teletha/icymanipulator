/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
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
        Array o = Array.with.array(new String[] {"one", "two"}).nest(new String[][] {{"a"}, {"b"}});
        assert o.array[0].equals("one");
        assert o.array[1].equals("two");
        assert o.nest[0][0].equals("a");
        assert o.nest[1][0].endsWith("b");
    }

    @Test
    void vararg() {
        Array o = Array.with.array("one", "two").nest(new String[] {"a"}, new String[] {"b"});
        assert o.array[0].equals("one");
        assert o.array[1].equals("two");
        assert o.nest[0][0].equals("a");
        assert o.nest[1][0].endsWith("b");
    }
}