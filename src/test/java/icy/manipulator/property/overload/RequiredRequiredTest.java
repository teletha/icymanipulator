/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.overload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.RequiredRequiredModel;

class RequiredRequiredTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, RequiredRequiredModel.class);

    @Test
    void overload() {
        // RequiredRequired o = RequiredRequired.with.size(10).date(2019, 5, 14).time(12, 51, 34);
        // assert o.size.intValue() == 10;
        // assert o.date.isEqual(LocalDate.of(2019, 5, 14));
        // assert o.time.equals(LocalTime.of(12, 51, 34));
    }
}
