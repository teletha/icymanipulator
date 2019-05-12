/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload.model;

import java.time.LocalTime;

import icy.manipulator.Icy;

@Icy
public abstract class RequiredRequiredModel extends Overload {

    @Icy.Property
    abstract LocalTime time();

    @Icy.Overload("time")
    private LocalTime time(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }
}
