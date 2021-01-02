/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.optional.model;

import java.util.Optional;

import icy.manipulator.Icy;

@Icy
public interface OptionalModel {

    @Icy.Property
    Optional<String> name();

    @Icy.Property
    default Optional<String> defaults() {
        return Optional.of("default");
    }
}