/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.error.model.ThrowOriginalError;
import icy.manipulator.property.error.model.ThrowOriginalErrorModel;

class ThrowOriginalErrorTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ThrowOriginalErrorModel.class);

    @Test
    void validationWillThrowOriginalError() {
        assertThrows(IllegalArgumentException.class, () -> ThrowOriginalError.with.size(-1));
    }
}
