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
import icy.manipulator.Icy;
import icy.manipulator.IcyManipulator;

class InvalidPropertyTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class);

    @Test
    void modifier() {
        assert processor.captureError(PrivateModifierModel.class).contains("must not be private");
    }

    @Icy
    static abstract class PrivateModifierModel {

        @Icy.Property
        private int value() {
            return 10;
        }
    }

    @Test
    void parameter() {
        assert processor.captureError(ParameterModel.class).contains("must have no parameter");
    }

    @Icy
    static abstract class ParameterModel {

        @Icy.Property
        abstract int value(int invalid);
    }

    @Test
    void noReturn() {
        assert processor.captureError(NoReturnModel.class).contains("must return something");
    }

    @Icy
    static abstract class NoReturnModel {

        @Icy.Property
        abstract void value();
    }
}