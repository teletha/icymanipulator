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
import icy.manipulator.property.overload.model.AutoExpandEnum;
import icy.manipulator.property.overload.model.AutoExpandEnumModel;
import icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer;

class AutoExpandEnumTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandEnumModel.class);

    @Test
    void normal() {
        AutoExpandEnum o = AutoExpandEnum.with.answer(Answer.Yes);
        assert o.answer == Answer.Yes;
    }

    @Test
    void overloadAutomatically() {
        AutoExpandEnum o = AutoExpandEnum.with.answer(Answer.Yes);
        assert o.answer == Answer.Yes;
    }
}
