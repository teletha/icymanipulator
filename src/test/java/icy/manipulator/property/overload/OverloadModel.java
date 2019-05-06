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

import icy.manipulator.Icy;

@Icy
abstract class OverloadModel {

    @Icy.Overload
    public int number(String number) {
        return Integer.valueOf(number);
    }

    @Icy.Property
    public abstract int number();
}