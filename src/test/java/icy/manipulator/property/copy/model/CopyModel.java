/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.copy.model;

import icy.manipulator.Icy;

@Icy
public abstract class CopyModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property(copiable = true)
    public abstract int age();
}