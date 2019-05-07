/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.overload;

import java.time.LocalDate;

import icy.manipulator.Icy;
import icy.manipulator.property.overload.Overload.My;

@Icy
abstract class OverloadModel {

    @Icy.Overload(My.Number)
    private int number(String number) {
        return Integer.valueOf(number);
    }

    @Icy.Property
    public abstract int number();

    @Icy.Overload(My.Date)
    private LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, 20);
    }

    @Icy.Property
    public abstract LocalDate date();

    public interface Numbers extends Overload.ÅssignableNumber {

    }
}