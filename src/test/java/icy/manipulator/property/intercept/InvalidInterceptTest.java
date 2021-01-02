/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.intercept;

import java.util.function.Consumer;

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
        private int intercept(long value) {
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

        @Icy.Intercept("value")
        private long intercept(int value) {
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

        @Icy.Intercept("notFound")
        private int intercept(int value) {
            return value;
        }
    }

    @Test
    void nonSetterParam() {
        assert processor.captureError(NonSetterParam.class).contains("2nd argument [java.lang.String] is invalid");
    }

    @Icy
    static abstract class NonSetterParam {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        private int intercept(int value, String invalid) {
            return value;
        }
    }

    @Test
    void setterPropertyName() {
        assert processor.captureError(NonSetterName.class).contains("property is not defined");
    }

    @Icy
    static abstract class NonSetterName {

        @Icy.Property
        abstract int value();

        @Icy.Intercept("value")
        private int intercept(int value, Consumer<String> notFound) {
            return value;
        }
    }
}