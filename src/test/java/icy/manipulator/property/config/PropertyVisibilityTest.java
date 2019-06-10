/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.config;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;

class PropertyVisibilityTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, PropertyVisibilityModel.class);

    @Test
    void packagePrivateProperty() throws Exception {
        Method method = PropertyVisibility.class.getDeclaredMethod("packagePrivateProperty");
        assert Modifier.isPublic(method.getModifiers()) == false;
        assert Modifier.isProtected(method.getModifiers()) == false;
        assert Modifier.isPrivate(method.getModifiers()) == false;

        Field field = PropertyVisibility.class.getDeclaredField("packagePrivateProperty");
        assert Modifier.isPublic(field.getModifiers()) == false;
        assert Modifier.isProtected(field.getModifiers()) == false;
        assert Modifier.isPrivate(field.getModifiers()) == false;
    }

    @Test
    void protectedProperty() throws Exception {
        Method method = PropertyVisibility.class.getDeclaredMethod("protectedProperty");
        assert Modifier.isProtected(method.getModifiers()) == true;

        Field field = PropertyVisibility.class.getDeclaredField("protectedProperty");
        assert Modifier.isProtected(field.getModifiers()) == true;
    }
}
