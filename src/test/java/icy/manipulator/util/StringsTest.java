/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.util;

import org.junit.jupiter.api.Test;

import icy.manipulator.util.Strings;

class StringsTest {

    @Test
    void decapitalize() {
        assert Strings.decapitalize("Test").equals("test");
        assert Strings.decapitalize("TEST").equals("test");
        assert Strings.decapitalize("TEst").equals("tEst");
    }
}
