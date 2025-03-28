/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.error.model;

import icy.manipulator.Icy;

@Icy
public abstract class NullValueModel {

    @Icy.Property
    public abstract String rejectNull();

    @Icy.Property(nullable = true)
    public abstract String acceptNull();

    @Icy.Property
    public String defaultValue() {
        return "default";
    }
}