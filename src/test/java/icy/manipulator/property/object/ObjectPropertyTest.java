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
import icy.manipulator.tool.IcyManipulator2;

class ObjectPropertyTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator2.class, ObjectPropertyModel.class);

    @Test
    void attribute() {
        ObjectProperty instance = ObjectProperty.with(base -> base.name("String").age(12));
        assert instance.name.equals("ok");
    }
}
