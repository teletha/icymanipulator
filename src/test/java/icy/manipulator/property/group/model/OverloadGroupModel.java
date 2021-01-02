/*
 * Copyright (C) 2021 icymanipulator Development Team
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
public abstract class OverloadGroupModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property
    public abstract int size();

    /**
     * Set
     * 
     * @param value
     * @return
     */
    @Icy.Overload("size")
    private int size(String value) {
        return Integer.valueOf(value);
    }
}