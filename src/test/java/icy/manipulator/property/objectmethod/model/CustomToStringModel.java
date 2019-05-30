/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.objectmethod.model;

import icy.manipulator.Icy;

@Icy
public abstract class CustomToStringModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property
    public abstract int age();

    @Override
    public String toString() {
        return "[" + name() + ":" + age() + "]";
    }
}
