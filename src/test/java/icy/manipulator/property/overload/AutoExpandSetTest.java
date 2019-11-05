/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import apty.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.overload.model.AutoExpandSet;
import icy.manipulator.property.overload.model.AutoExpandSetModel;

class AutoExpandSetTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, AutoExpandSetModel.class);

    @Test
    void variableArguments() {
        AutoExpandSet o = AutoExpandSet.with.values("one", "two", "three");
        Assertions.assertIterableEquals(Set.of("one", "two", "three"), o.values);
    }
}
