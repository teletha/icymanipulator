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

/**
 * @version 2015/06/02 22:49:43
 */
class Property {

    /** The property name. */
    final String name;

    /** The property name. */
    final String NAME;

    /** The type name. */
    Type type;

    /** The type name. */
    Type TYPE;

    /** The state. */
    boolean isModel;

    /**
     * 
     */
    Property(Type type, String name) {
        this.type = type;
        this.TYPE = type.wrap();
        this.name = name;
        this.NAME = name.toUpperCase();

        try {
            this.isModel = Class.forName(type + IcyManipulator.ModelDefinitionSuffix).isAnnotationPresent(Icy.class);
        } catch (ClassNotFoundException e) {
            this.isModel = false;
        }
    }
}