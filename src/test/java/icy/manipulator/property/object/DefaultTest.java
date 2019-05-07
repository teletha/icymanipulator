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

class DefaultTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, DefaultModel.class);

    @Test
    void defaults() {
        Default instance = Default.with.create();
        assert instance.name.equals("Bruno Bucciarati");
        assert instance.name().equals("Bruno Bucciarati");
        assert instance.stand.equals("Sticky Fingers");
        assert instance.stand().equals("Sticky Fingers");
    }

    @Test
    void property() {
        Default instance = Default.with.create().name("Guido Mista").stand("Sex Pistols");
        assert instance.name.equals("Guido Mista");
        assert instance.name().equals("Guido Mista");
        assert instance.stand.equals("Sex Pistols");
        assert instance.stand().equals("Sex Pistols");
    }
}
