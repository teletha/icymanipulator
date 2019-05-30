/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.copy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.copy.model.Copy;
import icy.manipulator.property.copy.model.CopyModel;

class CopyTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CopyModel.class);

    @Test
    void copy() {
        Copy original = Copy.with.name("name").age(15);
        assert original.name.equals("name");
        assert original.age == 15;

        Copy copied = original.withAge(17);
        assert copied.name.equals("name");
        assert copied.age == 17;

        assert original != copied;
        assert original.name.equals("name");
        assert original.age == 15;
    }
}
