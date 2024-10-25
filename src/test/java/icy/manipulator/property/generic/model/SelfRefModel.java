/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic.model;

import java.util.function.ToIntFunction;

import icy.manipulator.Icy;

@Icy
public interface SelfRefModel<SELF extends SelfRefModel> {

    @Icy.Property
    int value();

    @Icy.Overload("value")
    private int values(double value) {
        return (int) Math.round(value);
    }

    @Icy.Property
    ToIntFunction<SELF> calc();
}