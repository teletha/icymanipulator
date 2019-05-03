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
import icy.manipulator.Initializer;

@Icy
public class IntercepteSetterModel {

    public final String text = null;

    public final String upper = null;

    public final int size = Initializer.Int();

    /**
     * Update by text.
     * 
     * @param text
     * @param model
     */
    @Icy.Interceptor
    void text(String text, IntercepteSetter model) {
        model.upper(text.toUpperCase());
        model.size(text.length());
    }
}
