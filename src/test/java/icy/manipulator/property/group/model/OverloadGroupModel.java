/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.group.model;

import icy.manipulator.Icy;

@Icy(grouping = 2)
public abstract class OverloadGroupModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property
    public abstract int size();

    @Icy.Overload("size")
    private int size(String value) {
        return Integer.valueOf(value);
    }
}
