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
public class IgnorablePropertyModel {

    public static String ignoreStatic;

    private String ignorePrivate;

    public String[] ignoreArray;

    public int[] ignorePrimitiveArray;
}
