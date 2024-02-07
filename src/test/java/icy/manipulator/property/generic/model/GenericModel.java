/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic.model;

import java.util.Map;

import icy.manipulator.Icy;

@Icy
public interface GenericModel<P, Q extends Number> {

    @Icy.Property
    P value();

    @Icy.Property
    Q number();

    @Icy.Property
    Map<P, Q> mapper();

    @Icy.Property
    String text();
}