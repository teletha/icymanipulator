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

class DefaultTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator2.class, DefaultModel.class);

    @Test
    void property() {
        Default instance = Default.create();
        assert instance.name.equals("Bruno Bucciarati");
        assert instance.name().equals("Bruno Bucciarati");
        assert instance.stand.equals("Sticky Fingers");
        assert instance.stand().equals("Sticky Fingers");
    }
}
