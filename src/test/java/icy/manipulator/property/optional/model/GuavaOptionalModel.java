/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.optional.model;

import icy.manipulator.Icy;

@Icy
public interface GuavaOptionalModel {

    @Icy.Property
    com.google.common.base.Optional<String> value();
}