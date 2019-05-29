/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.intercept;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.Icy;
import icy.manipulator.IcyManipulator;

class InvalidInterceptTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class);

    @Test
    void modifier() {
        assert processor.captureError(PublicModifierModel.class).contains("must be private");
        assert processor.captureError(ProtectedModifierModel.class).contains("must be private");
        assert processor.captureError(PackagePrivateModifierModel.class).contains("must be private");
    }

    @Icy
    static abstract class PublicModifierModel {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        public int intercept(int value) {
            return value;
        }
    }

    @Icy
    static abstract class ProtectedModifierModel {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        protected int intercept(int value) {
            return value;
        }
    }

    @Icy
    static abstract class PackagePrivateModifierModel {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        int intercept(int value) {
            return value;
        }
    }

    @Test
    void paramType() {
        assert processor.captureError(DifferentParamType.class).contains("requires the same parameter type");
    }

    @Icy
    static abstract class DifferentParamType {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        private int intercept2(long value) {
            return (int) value;
        }
    }
}
