/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.customize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.customize.model.Customizable;
import icy.manipulator.property.customize.model.CustomizableModel;

class CustomizableTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CustomizableModel.class);

    @Test
    void property() {
        Customizable o = Customizable.with.name("name").value("value");
        assert o.name.equals("name");
        assert o.nameByGetter().equals("name");
        assert o.nameBySetter().equals("name");
        assert o.nameByGetterAsSupplier().get().equals("name");
        assert o.value.equals("value");
        assert o.valueFromSub().equals("value");
    }
}