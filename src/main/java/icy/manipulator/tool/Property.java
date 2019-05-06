/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.tool;

import icy.manipulator.Icy;

class Property {

    /** The property name. */
    final String name;

    /** The property name. */
    final String NAME;

    /** The type name. */
    Type type;

    /** The type name. */
    Type TYPE;

    /** The property modifier. */
    boolean isFinal;

    /** The state. */
    boolean isModel;

    /** The state. */
    String derive;

    /** The state. */
    boolean isDerived;

    /** The property state. */
    boolean isArbitrary;

    /** The next property. */
    String next;

    /**
     * 
     */
    Property(Type type, String name, boolean isFinal) {
        this.type = type;
        this.TYPE = type.wrap();
        this.name = name;
        this.NAME = name.toUpperCase();
        this.isFinal = isFinal;

        try {
            this.isModel = Class.forName(type + IcyManipulator2.ModelDefinitionSuffix).isAnnotationPresent(Icy.class);
        } catch (ClassNotFoundException e) {
            this.isModel = false;
        }
    }

    /**
     * Compute visibilitt of setter method.
     * 
     * @return A visibility.
     */
    String setterVisibility() {
        return isDerived ? "protected" : "public";
    }
}