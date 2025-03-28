/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.config;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
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