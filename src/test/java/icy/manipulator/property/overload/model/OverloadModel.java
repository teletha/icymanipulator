/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.overload.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import icy.manipulator.Icy;
import icy.manipulator.property.overload.model.Overload.My;

@Icy
public abstract class OverloadModel {

    @Icy.Property
    public abstract BigDecimal size();

    @Icy.Overload("size")
    private BigDecimal size(int number) {
        return new BigDecimal(number);
    }

    @Icy.Overload("size")
    private BigDecimal sizeByText(String number) {
        return new BigDecimal(number);
    }

    @Icy.Property
    public abstract LocalDate date();

    @Icy.Overload(My.Date)
    private LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}