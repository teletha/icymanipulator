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
 * @version 2015/06/08 1:08:20
 */
@Icy
public class WithInnerClassModel {

    public Inner property;

    /**
     * @version 2015/06/08 1:09:20
     */
    public class Inner {

        private String value;
    }
}
