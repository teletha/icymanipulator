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
public abstract class ArbitraryModel {

    @Icy.Property
    int optionNum() {
        return 10;
    }

    @Icy.Property
    String optionComment() {
        return "";
    }
}
