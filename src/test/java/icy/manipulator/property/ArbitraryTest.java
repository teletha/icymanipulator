/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.model.Arbitrary;
import icy.manipulator.property.model.ArbitraryModel;

class ArbitraryTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ArbitraryModel.class);

    @Test
    void defaults() {
        Arbitrary o = Arbitrary.with.create();
        assert o.optionComment.isEmpty();
        assert o.optionNum == 10;
    }

    @Test
    void configOneOption() {
        Arbitrary o = Arbitrary.with.create().optionNum(5);
        assert o.optionComment.isEmpty();
        assert o.optionNum == 5;
    }

    @Test
    void configOtherOption() {
        Arbitrary o = Arbitrary.with.create().optionComment("ok");
        assert o.optionComment.equals("ok");
        assert o.optionNum == 10;
    }

    @Test
    void configOneOptionThenOtherOption() {
        Arbitrary o = Arbitrary.with.create().optionNum(5).optionComment("ok");
        assert o.optionComment.equals("ok");
        assert o.optionNum == 5;
    }

    @Test
    void configOtherOptionThenOneOption() {
        Arbitrary o = Arbitrary.with.create().optionComment("ok").optionNum(5);
        assert o.optionComment.equals("ok");
        assert o.optionNum == 5;
    }
}
