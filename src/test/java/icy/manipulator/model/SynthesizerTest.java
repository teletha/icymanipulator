/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.model;

import org.junit.jupiter.api.Test;

class SynthesizerTest {

    @Test
    void synthesize() {
        MethodDefinition one1 = new MethodDefinition("first", void.class, String.class, "name");
        Synthesizer one = new Synthesizer(one1);

        MethodDefinition second1 = new MethodDefinition("second", void.class, String.class, "type");
        Synthesizer second = new Synthesizer(second1);

        Synthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new MethodDefinition("first", void.class, String.class, "name", String.class, "type"));
    }

    @Test
    void synthesize2() {
        MethodDefinition one1 = new MethodDefinition("first", void.class, String.class, "name");
        MethodDefinition one2 = new MethodDefinition("first", void.class, int.class, "age");
        Synthesizer one = new Synthesizer(one1, one2);

        MethodDefinition second1 = new MethodDefinition("second", void.class, String.class, "type");
        MethodDefinition second2 = new MethodDefinition("second", void.class, int.class, "pattern");
        Synthesizer second = new Synthesizer(second1, second2);

        Synthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 4;
        assert synthesized.methods.get(0).equals(new MethodDefinition("first", void.class, String.class, "name", String.class, "type"));
        assert synthesized.methods.get(1).equals(new MethodDefinition("first", void.class, String.class, "name", int.class, "pattern"));
        assert synthesized.methods.get(2).equals(new MethodDefinition("first", void.class, int.class, "age", String.class, "type"));
        assert synthesized.methods.get(3).equals(new MethodDefinition("first", void.class, int.class, "age", int.class, "pattern"));
    }

    @Test
    void sameName() {
        MethodDefinition one1 = new MethodDefinition("first", void.class, String.class, "name");
        Synthesizer one = new Synthesizer(one1);

        MethodDefinition second1 = new MethodDefinition("second", void.class, String.class, "name");
        Synthesizer second = new Synthesizer(second1);

        Synthesizer synthesized = one.synthesize(second);
        assert synthesized.methods.size() == 1;
        assert synthesized.methods.get(0).equals(new MethodDefinition("first", void.class, String.class, "name", String.class, "name1"));
    }
}
