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

public class IntercepteSetterTest {

    @Test
    void intercept() {
        IntercepteSetter melty = IntercepteSetter.with().text("abcde");
        assert melty.text.equals("abcde");
        assert melty.upper.equals("ABCDE");
        assert melty.size == 5;
    }

    @Test
    void meltyWith() {
        IntercepteSetter model = IntercepteSetter.with().text("abc");
        IntercepteSetter copy = IntercepteSetter.with(model);
        assert copy.upper.equals(model.upper);
        assert copy.size == model.size;
    }

    @Test
    void icyWith() {
        IntercepteSetter model = IntercepteSetter.with().text("abc").ice();
        IntercepteSetter copy = IntercepteSetter.with(model);
        assert copy.upper.equals(model.upper);
        assert copy.size == model.size;
    }
}
