/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.extend.model;

import icy.manipulator.Icy;
import icy.manipulator.property.base.model.Arbitrary;

@Icy
public abstract class ArbitraryRequiredModel extends Arbitrary {

    @Icy.Property
    public abstract long id();
}