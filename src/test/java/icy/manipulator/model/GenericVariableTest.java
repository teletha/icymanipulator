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

/**
 * @version 2015/06/03 17:06:43
 */
public class GenericVariableTest {

    @Test
    public void propertyChangeMelty() {
        GenericVariable<String, Integer> melty = GenericVariable.<String, Integer> with().value1("小路 綾");
        GenericVariable<String, Integer> modified = melty.value1("あやや");
        assert melty == modified;
        assert melty.value1().equals("あやや");
    }

    @Test
    public void propertyChangeIcy() {
        GenericVariable<String, Integer> melty = GenericVariable.<String, Integer> with().value1("小路 綾").ice();
        GenericVariable<String, Integer> modified = melty.value1("あやや");
        assert melty != modified;
        assert modified.value1().equals("あやや");
    }

    @Test
    public void manipulator() {
        GenericVariable<String, Integer> melty = GenericVariable.<String, Integer> with().value1("小路 綾").ice();
        GenericVariable<String, Integer> modified = GenericVariable.<String, Integer> manipulate().value1().set(melty, "あやや");
        assert melty != modified;
        assert modified.value1().equals("あやや");
    }
}
