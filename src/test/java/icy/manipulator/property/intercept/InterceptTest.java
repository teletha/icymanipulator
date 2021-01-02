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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.intercept.model.Intercept;
import icy.manipulator.property.intercept.model.InterceptModel;

class InterceptTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, InterceptModel.class);

    @Test
    void intercept() {
        Intercept normal = Intercept.with.size(10);
        assert normal.size == 10;

        Intercept normalized = Intercept.with.size(-10);
        assert normalized.size == 0;
    }
}