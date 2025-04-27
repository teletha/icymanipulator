/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
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
import icy.manipulator.property.overload.model.OptionalIntOverload;
import icy.manipulator.property.overload.model.OptionalIntOverloadModel;

class OptionalIntOverloadTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OptionalIntOverloadModel.class);

    @Test
    void overload() {
        OptionalIntOverload o = OptionalIntOverload.with.num("1");
        assert o.num.getAsInt() == 1;
    }

    @Test
    void noParam() {
        OptionalIntOverload o = OptionalIntOverload.with.one();
        assert o.num.getAsInt() == 1;
    }

    @Test
    void createOverload() {
        OptionalIntOverload o = OptionalIntOverload.with.create().num(1);
        assert o.num.getAsInt() == 1;
    }

    @Test
    void createNoParam() {
        OptionalIntOverload o = OptionalIntOverload.with.create().one();
        assert o.num.getAsInt() == 1;
    }
}