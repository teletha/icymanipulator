/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
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
import icy.manipulator.property.copy.model.CopySub;
import icy.manipulator.property.copy.model.CopySubModel;

class CopySubTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, CopySubModel.class);

    @Test
    void copy() {
        CopySub original = CopySub.with.name("name").age(15).address("address");
        assert original.name.equals("name");
        assert original.age == 15;
        assert original.address.equals("address");

        CopySub copied = original.withAge(17);
        assert copied.name.equals("name");
        assert copied.age == 17;
        assert copied.address.equals("address");

        assert original != copied;
        assert original.name.equals("name");
        assert original.age == 15;
        assert original.address.equals("address");
    }

    @Test
    void same() {
        CopySub original = CopySub.with.name("name").age(15).address("address");
        assert original.name.equals("name");
        assert original.age == 15;

        CopySub copied = original.withAge(15);
        assert original == copied;
    }
}