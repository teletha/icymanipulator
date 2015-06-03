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

import org.junit.Test;

/**
 * @version 2015/06/02 20:30:55
 */
public class PersonTest {

    @Test
    public void propertyChangeMelty() throws Exception {
        Person melty = Person.with().name("小路 綾");
        assert melty.name().equals("小路 綾");

        Person modified = melty.name("あやや");
        assert melty == modified;
        assert melty.name().equals("あやや");
    }

    @Test
    public void propertyChangeIcy() throws Exception {
        Person icy = Person.with().name("小路 綾").ice();
        assert icy.name().equals("小路 綾");

        Person modified = icy.name("あやや");
        assert icy.name().equals("小路 綾");
        assert modified.name().equals("あやや");
    }
}
