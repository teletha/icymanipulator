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

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.Overload;
import icy.manipulator.property.overload.model.OverloadModel;

class OverloadTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, OverloadModel.class);

    @Test
    void overload() {
        Overload o = Overload.with.sizeByText("12").date(2015, 7, 12);
        assert o.size.intValue() == 12;
        assert o.date.isEqual(LocalDate.of(2015, 7, 12));
    }

    @Test
    void overloadNoParameter() {
        Overload o = Overload.with.size(12).today();
        assert o.size.intValue() == 12;
        assert o.date.isEqual(LocalDate.now());
    }
}
