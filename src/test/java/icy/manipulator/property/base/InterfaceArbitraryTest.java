/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.base.model.InterfaceArbitrary;
import icy.manipulator.property.base.model.InterfaceArbitraryModel;

class InterfaceArbitraryTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, InterfaceArbitraryModel.class);

    @Test
    void property() {
        InterfaceArbitrary o = InterfaceArbitrary.with.create();
        assert o.optional.equals("default");

        o = InterfaceArbitrary.with.create().optional("assign");
        assert o.optional.equals("assign");
    }
}
