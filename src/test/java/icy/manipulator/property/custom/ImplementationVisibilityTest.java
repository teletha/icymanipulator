/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.custom;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;

class ImplementationVisibilityTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ImplementationVisibilityModel.class);

    @Test
    void visibility() {
        assert Modifier.isPublic(ImplementationVisibility.class.getModifiers()) == false;
        assert Modifier.isProtected(ImplementationVisibility.class.getModifiers()) == false;
        assert Modifier.isPrivate(ImplementationVisibility.class.getModifiers()) == false;
    }
}
