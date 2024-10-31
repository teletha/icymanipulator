/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.extend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.extend.model.ArbitraryRequired;
import icy.manipulator.property.extend.model.ArbitraryRequiredModel;

class ArbitraryReuqiredTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ArbitraryRequiredModel.class);

    @Test
    void defaults() {
        ArbitraryRequired o = ArbitraryRequired.with.id(10);
        assert o.id == 10;
        assert o.optionNum == 10;
        assert o.optionComment.isEmpty();
    }

    @Test
    void override() {
        ArbitraryRequired o = ArbitraryRequired.with.id(10).optionNum(5).optionComment("Comment");
        assert o.id == 10;
        assert o.optionNum == 5;
        assert o.optionComment.equals("Comment");
    }
}