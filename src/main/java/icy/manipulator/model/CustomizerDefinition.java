/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import javax.lang.model.element.TypeElement;

import icy.manipulator.Type;

public class CustomizerDefinition {

    public final TypeElement e;

    private final PropertyDefinition property;

    public CustomizerDefinition(TypeElement e, PropertyDefinition property) {
        this.e = e;
        this.property = property;
    }

    public Type type() {
        return Type.of(e).addVariable(property.type);
    }
}
