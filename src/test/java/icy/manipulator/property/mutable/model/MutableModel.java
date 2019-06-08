/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.mutable.model;

import icy.manipulator.Icy;

@Icy
public abstract class MutableModel {

    @Icy.Property(mutable = true)
    public abstract String value();

    @Icy.Property(mutable = true)
    public abstract int intNum();

    @Icy.Property(mutable = true)
    public abstract long longNum();

    @Icy.Property(mutable = true)
    public abstract float floatNum();

    @Icy.Property(mutable = true)
    public abstract double doubleNum();
}
