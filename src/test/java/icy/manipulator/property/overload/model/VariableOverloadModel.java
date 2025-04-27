/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload.model;

import icy.manipulator.Icy;
import kiss.Variable;

@Icy
public abstract class VariableOverloadModel {

    @Icy.Property
    public abstract Variable<String> num();

    @Icy.Overload("num")
    private Variable<String> one() {
        return Variable.of("1");
    }
}