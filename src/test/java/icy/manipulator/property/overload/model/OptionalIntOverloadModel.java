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

import java.util.OptionalInt;

import icy.manipulator.Icy;

@Icy
public abstract class OptionalIntOverloadModel {

    @Icy.Property
    public abstract OptionalInt num();

    @Icy.Overload("num")
    private OptionalInt num(String value) {
        return OptionalInt.of(Integer.parseInt(value));
    }

    @Icy.Overload("num")
    private OptionalInt one() {
        return OptionalInt.of(1);
    }
}