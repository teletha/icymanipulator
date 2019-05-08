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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.object.SubclassModel;

class SubclassTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, SubclassModel.class);

    @Test
    void property() {
        // Subclass name = Subclass.with.name("test").nickname("ok");
        // Single instance = Subclass.with.name("Giorno Giovanna");
        // assert instance.name.equals("Giorno Giovanna");
    }
}
