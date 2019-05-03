/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import icy.manipulator.Icy;

@Icy
public class PropertyStyleModel {

    @Icy.Property(hideGetter = true)
    public int hideGetter;

    @Icy.Property(hideSetter = true)
    public int age;

    @Icy.Property(nullable = false)
    public String rejectNull;
}
