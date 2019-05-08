/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;

class MultipleTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MultipleModel.class);

    @Test
    void property() {
        Multiple instance = Multiple.with.name("Giorno Giovanna").stand("Gold Experience").age(15);
        assert instance.name.equals("Giorno Giovanna");
        assert instance.stand().equals("Gold Experience");
        assert instance.age == 15;
    }
}
