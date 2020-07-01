/*
 * Copyright (C) 2020 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload.model;

import java.util.Map;
import java.util.function.Supplier;

import icy.manipulator.Icy;

@Icy
public abstract class AutoExpandMapModel {

    @Icy.Property
    public abstract Map<String, Integer> values();

    @Icy.Property
    public Map<String, Supplier<String>> generics() {
        return Map.of();
    }
}