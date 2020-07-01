/*
 * Copyright (C) 2020 icymanipulator Development Team
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
import icy.manipulator.property.extend.model.RequiredRequired;
import icy.manipulator.property.extend.model.RequiredRequiredModel;

class RequiredRequierdTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, RequiredRequiredModel.class);

    @Test
    void property() {
        RequiredRequired instance = RequiredRequired.with.name("Giorno Giovanna").stand("Gold Experience").age(15).nickname("jojo");
        assert instance.name.equals("Giorno Giovanna");
        assert instance.stand.equals("Gold Experience");
        assert instance.age == 15;
        assert instance.nickname.equals("jojo");
    }
}