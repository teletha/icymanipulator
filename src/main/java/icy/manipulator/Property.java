/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import javax.lang.model.element.ExecutableElement;

class Property {

    /** The property name. */
    final String name;

    /** The actual source element. */
    final ExecutableElement element;

    /** The type name. */
    Type type;

    /** The state. */
    String derive;

    /** The state. */
    boolean isDerived;

    /** The property state. */
    boolean isArbitrary;

    /** The next property. */
    String next;

    Property nextProperty;

    /**
     * 
     */
    Property(Type type, String name, ExecutableElement element) {
        this.type = type;
        this.name = name;
        this.element = element;
    }

    /**
     * Compute visibilitt of setter method.
     * 
     * @return A visibility.
     */
    String setterVisibility() {
        return isDerived ? "protected" : "public";
    }

    /**
     * Compute assignable interface name of this property.
     * 
     * @return An interface name.
     */
    String assignableInterfaceName() {
        if (isArbitrary) {
            return CodeAnalyzer.ArbitraryInterface;
        } else {
            return CodeAnalyzer.Assignable + Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
    }

    /**
     * Compute assignable interface name of this property.
     * 
     * @return An interface name.
     */
    String assignableInterfaceType(String last) {
        String type = assignableInterfaceName();

        if (nextProperty != null) {
            type = type + "<" + nextProperty.assignableInterfaceType(last) + ">";
        } else {
            type = type + "<" + last + ">";
        }
        return type;
    }

    /**
     * Compute capitalized property name.
     * 
     * @return
     */
    String capitalizeName() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    /**
     * @param className
     * @return
     */
    String nextAssignable(String className) {
        if (nextProperty == null) {
            return className;
        } else {
            return nextProperty.assignableInterfaceType(className);
        }
    }

    /**
     * @return
     */
    static Property empty() {
        return null;
    }
}