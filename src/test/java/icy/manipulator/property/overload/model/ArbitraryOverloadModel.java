/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload.model;

import icy.manipulator.Icy;

@Icy
public abstract class ArbitraryOverloadModel {

    @Icy.Property
    public int size() {
        return 10;
    }

    @Icy.Overload("size")
    private int size(String number) {
        return Integer.valueOf(number);
    }
}