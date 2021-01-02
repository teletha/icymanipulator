/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.base.model;

import icy.manipulator.Icy;

@Icy
public interface ArrayModel {

    @Icy.Property
    public abstract String[] array();

    @Icy.Property
    public default String[][] nest() {
        return new String[][] {{"one"}, {"ONE"}};
    }
}