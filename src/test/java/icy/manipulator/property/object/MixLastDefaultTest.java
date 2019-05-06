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

class MixLastDefaultTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MixLastDefaultModel.class);

    @Test
    void property() {
        MixLastDefault instance = MixLastDefault.create().name("Giorno Giovanna");
        assert instance.name.equals("Giorno Giovanna");
        assert instance.age == 15;
    }

    @Test
    void overrideDefault() {
        MixLastDefault instance = MixLastDefault.create().name("Guido Mista").age(18);
        assert instance.name.equals("Guido Mista");
        assert instance.age == 18;
    }
}
