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

import java.util.function.LongConsumer;

import icy.manipulator.Icy;

@Icy
public abstract class ReferenceLongSetterModel {

    @Icy.Property
    public abstract int size();

    @Icy.Property
    public long square() {
        return 0L;
    }

    @Icy.Intercept
    private int deriveBySize(int size, LongConsumer square) {
        square.accept(size * size);
        return size;
    }
}
