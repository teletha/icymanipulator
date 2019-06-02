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

class MethodSynthesizerTest {

    @Test
    void synthesize() {
        MethodInfo one1 = new TestableMethodInfo("first", void.class, String.class, "name");
        MethodSynthesizer one = new MethodSynthesizer(one1);

        MethodInfo second1 = new TestableMethodInfo("second", void.class, String.class, "type");
        MethodSynthesizer second = new MethodSynthesizer(second1);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new TestableMethodInfo("first", void.class, String.class, "name", String.class, "type"));
    }

    @Test
    void synthesize2() {
        MethodInfo one1 = new TestableMethodInfo("first", void.class, String.class, "name");
        MethodInfo one2 = new TestableMethodInfo("first", void.class, int.class, "age");
        MethodSynthesizer one = new MethodSynthesizer(one1, one2);

        MethodInfo second1 = new TestableMethodInfo("second", void.class, String.class, "type");
        MethodInfo second2 = new TestableMethodInfo("second", void.class, int.class, "pattern");
        MethodSynthesizer second = new MethodSynthesizer(second1, second2);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 4;
        assert synthesized.methods.get(0).equals(new TestableMethodInfo("first", void.class, String.class, "name", String.class, "type"));
        assert synthesized.methods.get(1).equals(new TestableMethodInfo("first", void.class, String.class, "name", int.class, "pattern"));
        assert synthesized.methods.get(2).equals(new TestableMethodInfo("first", void.class, int.class, "age", String.class, "type"));
        assert synthesized.methods.get(3).equals(new TestableMethodInfo("first", void.class, int.class, "age", int.class, "pattern"));
    }

    @Test
    void sameName() {
        MethodInfo one1 = new TestableMethodInfo("first", void.class, String.class, "name");
        MethodSynthesizer one = new MethodSynthesizer(one1);

        MethodInfo second1 = new TestableMethodInfo("second", void.class, String.class, "name");
        MethodSynthesizer second = new MethodSynthesizer(second1);

        MethodSynthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new TestableMethodInfo("first", void.class, String.class, "name", String.class, "name1"));
    }
}
