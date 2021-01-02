/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.intercept.model;

import java.util.function.Consumer;

import icy.manipulator.Icy;

@Icy
public abstract class MultiInterceptsModel {

    @Icy.Property
    public abstract int size();

    @Icy.Property
    public String value() {
        return "";
    }

    @Icy.Intercept("size")
    private int checkLower(int size) {
        if (size < 0) {
            size = 0;
        }
        return size;
    }

    @Icy.Intercept("size")
    private int stringlize(int size, Consumer<String> value) {
        value.accept("Size" + size);
        return size;
    }
}