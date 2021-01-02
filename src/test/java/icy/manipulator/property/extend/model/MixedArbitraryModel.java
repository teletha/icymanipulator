/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.extend.model;

import icy.manipulator.Icy;
import icy.manipulator.property.base.model.Mixed;

@Icy
public abstract class MixedArbitraryModel extends Mixed {

    @Icy.Property
    public String optionZip() {
        return "";
    }
}