/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.mutable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.mutable.model.Mutable;
import icy.manipulator.property.mutable.model.MutableModel;

class MutableTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MutableModel.class);

    @Test
    void setter() {
        Mutable o = Mutable.with.value("value").intNum(10).longNum(10L).floatNum(3.14F).doubleNum(3.14);
        assert o.value.equals("value");
        assert o.intNum == 10;
        assert o.longNum == 10L;
        assert o.floatNum == 3.14F;
        assert o.doubleNum == 3.14D;

        o.assignValue("updated");
        assert o.value.equals("updated");

        o.assignIntNum(20).assignLongNum(20).assignFloatNum(-0.1F).assignDoubleNum(-0.1);
        assert o.intNum == 20;
        assert o.longNum == 20L;
        assert o.floatNum == -0.1F;
        assert o.doubleNum == -0.1D;
    }

    @Test
    void mutator() {
        Mutable o = Mutable.with.value("value").intNum(10).longNum(10L).floatNum(3.14F).doubleNum(3.14);
        assert o.value.equals("value");
        assert o.intNum == 10;
        assert o.longNum == 10L;
        assert o.floatNum == 3.14F;
        assert o.doubleNum == 3.14D;

        o.assignValue(now -> now + " updated");
        assert o.value.equals("value updated");

        o.assignIntNum(now -> now * 2).assignLongNum(now -> now * 2).assignFloatNum(now -> now * 2).assignDoubleNum(now -> now * 2);
        assert o.intNum == 20;
        assert o.longNum == 20L;
        assert o.floatNum == 6.28F;
        assert o.doubleNum == 6.28D;
    }
}