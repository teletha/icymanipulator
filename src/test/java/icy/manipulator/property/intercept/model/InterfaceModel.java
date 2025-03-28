/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
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
public interface InterfaceModel {

    @Icy.Property
    int size();

    @Icy.Intercept("size")
    private int normalizeSize(int size) {
        if (size < 0) {
            size = 0;
        }
        return size;
    }
}