/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.model;

import icy.manipulator.Icy;

@Icy
public abstract class PrimitiveModel {

    @Icy.Property
    abstract int intX();

    @Icy.Property
    abstract long longX();

    @Icy.Property
    abstract float floatX();

    @Icy.Property
    abstract double doubleX();

    @Icy.Property
    abstract byte byteX();

    @Icy.Property
    abstract short shortX();

    @Icy.Property
    abstract char charX();

    @Icy.Property
    abstract boolean booleanX();
}
