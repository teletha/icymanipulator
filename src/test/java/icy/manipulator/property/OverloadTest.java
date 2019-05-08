/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.Overload;
import icy.manipulator.property.overload.OverloadModel;

class OverloadTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OverloadModel.class);

    @Test
    void overload() {
        Overload instance = Overload.with.sizeByText("12").date(2015, 7, 12);
        assert instance.size.intValue() == 12;
        assert instance.date.isEqual(LocalDate.of(2015, 7, 12));
    }
}
