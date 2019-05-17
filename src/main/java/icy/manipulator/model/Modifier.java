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

import icy.manipulator.Icy;
import icy.manipulator.Icy.Property;

public class Modifier {

    /** The getter modifier. */
    public final String getter;

    /** The setter modifier. */
    public final String setter;

    /**
     * Parse modifier setting.
     * 
     * @param property
     * @param icy
     */
    public Modifier(PropertyDefinition def, Icy icy) {
        Property property = def.element.getAnnotation(Icy.Property.class);

        String getter = property.getterModifier().trim();
        if (getter.equals("cascade")) {
            getter = icy.getterModifier().trim();
        }
        if (!getter.isEmpty()) {
            getter += " ";
        }
        this.getter = getter;

        String setter = property.setterModifier().trim();
        if (setter.equals("cascade")) {
            setter = icy.setterModifier().trim();
        }
        if (!setter.isEmpty()) {
            setter += " ";
        }
        this.setter = setter;
    }

    /**
     * Detect getter modifier.
     * 
     * @return
     */
    public boolean isPrivateGetter() {
        return getter.contains("private");
    }

    /**
     * Detect setter modifier.
     * 
     * @return
     */
    public boolean isPrivateSetter() {
        return setter.contains("private");
    }
}
