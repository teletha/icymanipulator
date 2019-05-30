/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.optional.model;

import icy.manipulator.Icy;
import kiss.Variable;

@Icy
public interface SinobuVariableModel {

    @Icy.Property
    Variable<String> value();
}
