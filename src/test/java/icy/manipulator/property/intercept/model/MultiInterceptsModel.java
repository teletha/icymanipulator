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
    private int stringlize(int size, MultiIntercepts.ÅssignableÅrbitrary model) {
        model.value("Size" + size);
        return size;
    }
}
