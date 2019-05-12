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

class TypeUtilTest {

    @Test
    void decapitalize() {
        assert TypeUtil.decapitalize("Test").equals("test");
        assert TypeUtil.decapitalize("TEST").equals("test");
        assert TypeUtil.decapitalize("TEst").equals("tEst");
    }
}
