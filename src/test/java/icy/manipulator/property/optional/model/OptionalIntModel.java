/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.optional.model;

import java.util.OptionalInt;

import icy.manipulator.Icy;

@Icy
public abstract class OptionalIntModel {

    @Icy.Property
    public abstract OptionalInt value();

    @Icy.Property
    public OptionalInt defaults() {
        return OptionalInt.of(10);
    }
}