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

/**
 * @version 2015/06/08 1:01:38
 */
@Icy
public class WithMethodModel {

    public String property;

    public String getPropertyWith(String suffix) {
        return property + suffix;
    }
}
