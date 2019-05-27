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

import icy.manipulator.MethodInfo;

class MethodInfoTest {

    @Test
    void constructor() {
        MethodInfo m = new MethodInfo("name", void.class, String.class, "text");
        assert m.name.equals("name");
        assert m.returnType.is(void.class);
        assert m.paramTypes.get(0).is(String.class);
        assert m.paramNames.get(0).equals("text");
    }

    @Test
    void addParam() {
        MethodInfo m = new MethodInfo("base", void.class);
        assert m.hasParameter() == false;

        MethodInfo created = m.withFirst(String.class, "value");
        assert m != created;
        assert created.name.equals("base");
        assert created.returnType.is(void.class);
        assert created.paramTypes.get(0).is(String.class);
        assert created.paramNames.get(0).equals("value");
    }
}
