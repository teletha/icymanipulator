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

import icy.manipulator.Icy;

@Icy
public abstract class AutoExpandEnumModel {

    @Icy.Property(overloadEnumAutomatically = true)
    public abstract Answer answer();

    public static enum Answer {
        Yes, No;
    }
}