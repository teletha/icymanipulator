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

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.intercept.model.MultiIntercepts;
import icy.manipulator.property.intercept.model.MultiInterceptsModel;

class MultiInterceptsTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MultiInterceptsModel.class);

    @Test
    void intercept() {
        MultiIntercepts normal = MultiIntercepts.with.size(10);
        assert normal.size == 10;
        assert normal.value.equals("Size10");

        MultiIntercepts normalized = MultiIntercepts.with.size(-10);
        assert normalized.size == 0;
        assert normalized.value.equals("Size0");
    }
}
