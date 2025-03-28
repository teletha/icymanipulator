/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import java.lang.annotation.RetentionPolicy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.AutoExpandEnum;
import icy.manipulator.property.overload.model.AutoExpandEnumModel;
import icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer;

class AutoExpandEnumTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandEnumModel.class);

    @Test
    void normal() {
        AutoExpandEnum o = AutoExpandEnum.with.answer(Answer.Yes).policy(RetentionPolicy.CLASS);
        assert o.answer == Answer.Yes;
        assert o.policy == RetentionPolicy.CLASS;
    }

    @Test
    void overloadAutomatically() {
        AutoExpandEnum o = AutoExpandEnum.with.no().runtime();
        assert o.answer == Answer.No;
        assert o.policy == RetentionPolicy.RUNTIME;
    }
}