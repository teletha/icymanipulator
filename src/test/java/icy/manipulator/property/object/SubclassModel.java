/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.object;

import icy.manipulator.Icy;

@Icy
abstract class SubclassModel extends Single {

    /**
     * @param name
     */
    public SubclassModel(String name) {
        super(name);
    }

    @Icy.Property
    public abstract String nickname();
}