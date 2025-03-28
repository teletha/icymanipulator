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

import java.util.Set;
import java.util.function.Supplier;

import icy.manipulator.Icy;

@Icy
public abstract class AutoExpandSetModel {

    @Icy.Property
    public abstract Set<String> values();

    @Icy.Property
    public Set<Supplier<String>> generics() {
        return Set.of();
    }

    @Icy.Property
    public Set<CharSequence> upperBoundable() {
        return Set.of("");
    }
}