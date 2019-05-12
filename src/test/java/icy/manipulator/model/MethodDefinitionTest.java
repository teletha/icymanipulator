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

class MethodDefinitionTest {

    @Test
    void constructor() {
        MethodDefinition m = new MethodDefinition("name", void.class, String.class, "text");
        assert m.name.equals("name");
        assert m.returnType.is(void.class);
        assert m.paramTypes.get(0).is(String.class);
        assert m.paramNames.get(0).equals("text");
    }

    @Test
    void addParam() {
        MethodDefinition m = new MethodDefinition("base", void.class);
        assert m.hasParameter() == false;

        MethodDefinition created = m.withFirst(String.class, "value");
        assert m != created;
        assert created.name.equals("base");
        assert created.returnType.is(void.class);
        assert created.paramTypes.get(0).is(String.class);
        assert created.paramNames.get(0).equals("value");
    }
}
