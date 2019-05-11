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

import java.util.Optional;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;

import icy.manipulator.CodeGenerator;
import icy.manipulator.Icy;
import icy.manipulator.Icy.Property;
import icy.manipulator.Type;
import icy.manipulator.TypeUtil;

public class PropertyDefinition {

    /** The actual source element. */
    public final ExecutableElement element;

    /** The property name. */
    public final String name;

    /** The type name. */
    public final Type type;

    /** The property state. */
    public final boolean isArbitrary;

    /** The state. */
    public String derive;

    /** The state. */
    public boolean isDerived;

    /** The property type. */
    public final boolean mutable;

    /** The proeprty type. */
    public final boolean autoExpandable;

    /**
     * @param method
     */
    public PropertyDefinition(ExecutableElement method) {
        this.element = method;
        this.name = method.getSimpleName().toString();
        this.type = Type.of(method.getReturnType());
        this.isArbitrary = !method.getModifiers().contains(Modifier.ABSTRACT);
        this.mutable = Optional.ofNullable(method.getAnnotation(Icy.Property.class)).map(Property::mutable).orElse(false);
        this.autoExpandable = Optional.ofNullable(method.getAnnotation(Icy.Property.class))
                .map(Property::overloadEnum)
                .filter(p -> TypeUtil.isEnum(method.getReturnType()))
                .orElse(true);
    }

    /**
     * Compute visibilitt of setter method.
     * 
     * @return A visibility.
     */
    public String setterVisibility() {
        return isDerived ? "protected" : "public";
    }

    /**
     * Compute assignable interface name of this property.
     * 
     * @return An interface name.
     */
    public String assignableInterfaceName() {
        if (isArbitrary) {
            return CodeGenerator.ArbitraryInterface;
        } else {
            return CodeGenerator.Assignable + TypeUtil.capitalize(name);
        }
    }

    /**
     * Compute capitalized property name.
     * 
     * @return
     */
    public String capitalizeName() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("(").append(type.className).append(")");
        return builder.toString();
    }
}