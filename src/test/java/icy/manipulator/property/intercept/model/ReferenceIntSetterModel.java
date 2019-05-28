/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.intercept.model;

import java.util.function.IntConsumer;

import icy.manipulator.Icy;

@Icy
public abstract class ReferenceIntSetterModel {

    @Icy.Property
    public abstract int size();

    @Icy.Property
    public int square() {
        return 0;
    }

    @Icy.Intercept("size")
    private int deriveBySize(int size, IntConsumer square) {
        square.accept(size * size);
        return size;
    }
}
