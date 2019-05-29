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
import icy.manipulator.Icy;
import icy.manipulator.IcyManipulator;

class InvalidOverloadTest {

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

        @Icy.Overload("value")
        public int overload(long value) {
            return (int) value;
        }
    }

    @Icy
    static abstract class ProtectedModifierModel {

        @Icy.Property
        abstract int value();

        @Icy.Overload("value")
        protected int overload(long value) {
            return (int) value;
        }
    }

    @Icy
    static abstract class PackagePrivateModifierModel {

        @Icy.Property
        abstract int value();

        @Icy.Overload("value")
        int overload(long value) {
            return (int) value;
        }
    }

    @Test
    void returnType() {
        assert processor.captureError(DifferentReturnType.class).contains("return the same type");
    }

    @Icy
    static abstract class DifferentReturnType {

        @Icy.Property
        abstract int value();

        @Icy.Overload("value")
        private long overload(int value) {
            return value;
        }
    }

    @Test
    void propertyName() {
        assert processor.captureError(InvalidPropertyName.class).contains("not found");
    }

    @Icy
    static abstract class InvalidPropertyName {

        @Icy.Property
        abstract int value();

        @Icy.Overload("notFound")
        private int overload(int value) {
            return value;
        }
    }
}
