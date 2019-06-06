/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import org.junit.jupiter.api.Test;

import apty.MethodLike;
import apty.TestableMethodLike;

class MethodSynthesizerTest {

    @Test
    void synthesize() {
        MethodLike one1 = new TestableMethodLike("first", void.class, String.class, "name");
        MethodSynthesizer one = new MethodSynthesizer(one1);

        MethodLike second1 = new TestableMethodLike("second", void.class, String.class, "type");
        MethodSynthesizer second = new MethodSynthesizer(second1);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new TestableMethodLike("first", void.class, String.class, "name", String.class, "type"));
    }

    @Test
    void synthesize2() {
        MethodLike one1 = new TestableMethodLike("first", void.class, String.class, "name");
        MethodLike one2 = new TestableMethodLike("first", void.class, int.class, "age");
        MethodSynthesizer one = new MethodSynthesizer(one1, one2);

        MethodLike second1 = new TestableMethodLike("second", void.class, String.class, "type");
        MethodLike second2 = new TestableMethodLike("second", void.class, int.class, "pattern");
        MethodSynthesizer second = new MethodSynthesizer(second1, second2);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 4;
        assert synthesized.methods.get(0).equals(new TestableMethodLike("first", void.class, String.class, "name", String.class, "type"));
        assert synthesized.methods.get(1).equals(new TestableMethodLike("first", void.class, String.class, "name", int.class, "pattern"));
        assert synthesized.methods.get(2).equals(new TestableMethodLike("first", void.class, int.class, "age", String.class, "type"));
        assert synthesized.methods.get(3).equals(new TestableMethodLike("first", void.class, int.class, "age", int.class, "pattern"));
    }

    @Test
    void sameName() {
        MethodLike one1 = new TestableMethodLike("first", void.class, String.class, "name");
        MethodSynthesizer one = new MethodSynthesizer(one1);

        MethodLike second1 = new TestableMethodLike("second", void.class, String.class, "name");
        MethodSynthesizer second = new MethodSynthesizer(second1);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new TestableMethodLike("first", void.class, String.class, "name", String.class, "name1"));
    }
}
