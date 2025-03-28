/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.group.model;

import icy.manipulator.Icy;

@Icy(grouping = 2)
public abstract class EnumGroupModel {

    @Icy.Property
    public abstract Color color();

    @Icy.Property
    public abstract int size();

    public static enum Color {
        Red, Blue, Green;
    }
}