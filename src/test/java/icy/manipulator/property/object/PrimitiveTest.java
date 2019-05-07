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

class PrimitiveTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, PrimitiveModel.class);

    @Test
    void property() {
        Primitive instance = Primitive.with.intX(10)
                .longX(20)
                .floatX(3.2F)
                .doubleX(0.12)
                .byteX((byte) 2)
                .shortX((short) 5)
                .charX('o')
                .booleanX(true);

        assert instance.intX == 10;
        assert instance.intX() == 10;
        assert instance.longX == 20;
        assert instance.longX() == 20;
        assert instance.floatX == 3.2F;
        assert instance.floatX() == 3.2F;
        assert instance.doubleX == 0.12;
        assert instance.doubleX() == 0.12;
        assert instance.byteX == 2;
        assert instance.byteX() == 2;
        assert instance.shortX == 5;
        assert instance.shortX() == 5;
        assert instance.booleanX == true;
        assert instance.booleanX() == true;
    }
}
