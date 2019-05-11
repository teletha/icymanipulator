/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
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
