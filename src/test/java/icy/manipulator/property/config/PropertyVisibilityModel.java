/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.config;

import icy.manipulator.Icy;

@Icy(packagePrivate = true)
abstract class PropertyVisibilityModel {

    @Icy.Property
    abstract String packagePrivateProperty();

    @Icy.Property
    protected abstract String protectedProperty();
}