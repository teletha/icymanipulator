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
 * @version 2015/06/03 17:06:43
 */
public class GenericVariableTest {

    @Test
    public void propertyChangeMelty() {
        GenericVariable<String> melty = GenericVariable.<String> with().value("小路 綾");
        GenericVariable<String> modified = melty.value("あやや");
        assert melty == modified;
        assert melty.value().equals("あやや");
    }

    @Test
    public void propertyChangeIcy() {
        GenericVariable<String> melty = GenericVariable.<String> with().value("小路 綾").ice();
        GenericVariable<String> modified = melty.value("あやや");
        assert melty != modified;
        assert modified.value().equals("あやや");
    }

    @Test
    public void manipulator() {
        GenericVariable<String> melty = GenericVariable.<String> with().value("小路 綾").ice();
        GenericVariable<String> modified = GenericVariable.<String> manipulate().value().set(melty, "あやや");
        assert melty != modified;
        assert modified.value().equals("あやや");
    }
}
