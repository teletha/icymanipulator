/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import org.junit.jupiter.api.Test;

class FinalPersonTest {

    @Test
    void propertyChangeMelty() {
        Person melty = Person.with().name("小路 綾").age(15);
        assert melty.name.equals("小路 綾");
        assert melty.age == 15;

        Person modified = melty.name("あやや").age(16);
        assert melty == modified;
        assert melty.name.equals("あやや");
        assert melty.age == 16;
    }

    @Test
    void propertyChangeIcy() {
        Person icy = Person.with().name("小路 綾").age(15).ice();
        assert icy.name.equals("小路 綾");
        assert icy.age == 15;

        Person modified = icy.name("あやや").age(16);
        assert icy.name.equals("小路 綾");
        assert icy.age == 15;
        assert modified.name.equals("あやや");
        assert modified.age == 16;
    }
}
