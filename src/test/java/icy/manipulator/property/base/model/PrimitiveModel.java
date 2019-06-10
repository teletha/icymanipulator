/*
 * Copyright (C) 2019 icymanipulator Development Team
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
public abstract class PrimitiveModel {

    @Icy.Property
    public abstract int intX();

    @Icy.Property
    public abstract long longX();

    @Icy.Property
    public abstract float floatX();

    @Icy.Property
    public abstract double doubleX();

    @Icy.Property
    public abstract byte byteX();

    @Icy.Property
    public abstract short shortX();

    @Icy.Property
    public abstract char charX();

    @Icy.Property
    public abstract boolean booleanX();
}
