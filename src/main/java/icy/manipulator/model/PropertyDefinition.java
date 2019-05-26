/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.model;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;

import icy.manipulator.Abyss;
import icy.manipulator.CodeGenerator;
import icy.manipulator.Fail;
import icy.manipulator.Icy;
import icy.manipulator.Icy.Property;
import icy.manipulator.Type;
import icy.manipulator.util.Strings;

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
    public final boolean nullable;

    /** The property type. */
    public final boolean mutable;

    /** The proeprty type. */
    public final boolean autoExpandable;

    /** The classic getter modifier. */
    public final String getterModifier;

    /** The classic setter modifier. */
    public final String setterModifier;

    /** The customizer definition. */
    public final CustomizerDefinition custom;

    /**
     * @param method
     */
    public PropertyDefinition(ExecutableElement method) {
        this.element = method;
        this.name = method.getSimpleName().toString();
        this.type = Type.of(method.getReturnType());
        this.isArbitrary = !method.getModifiers().contains(Modifier.ABSTRACT);

        Property annotation = method.getAnnotation(Icy.Property.class);

        if (annotation == null) {
            this.nullable = false;
            this.mutable = false;
            this.autoExpandable = true;
            this.getterModifier = "";
            this.setterModifier = "";
            this.custom = null;
        } else {
            this.nullable = annotation.nullable();
            this.mutable = annotation.mutable();
            this.autoExpandable = Abyss.isEnum(method.getReturnType()) ? annotation.overloadEnum() : true;

            Icy icy = method.getEnclosingElement().getAnnotation(Icy.class);
            this.getterModifier = validate(method, annotation.getterModifier(), icy.getterModifier());
            this.setterModifier = validate(method, annotation.setterModifier(), icy.setterModifier());
            this.custom = Abyss.annotationClassValue(method, Icy.Property.class, "custom")
                    .filter(Abyss::isNotInterface)
                    .map(Abyss::cast)
                    .map(customizer -> new CustomizerDefinition(this, customizer))
                    .orElse(null);
        }
    }

    /**
     * Validate accessor modifier.
     * 
     * @param e
     * @param modifiers
     * @param parent
     * @return
     */
    private String validate(Element e, String modifiers, String parent) {
        modifiers = modifiers.trim();

        if (modifiers.equals("cascade")) {
            modifiers = parent.trim();
            e = e.getEnclosingElement();
        }

        for (String modifier : modifiers.split("\\s+")) {
            switch (modifier) {
            case "public":
            case "protected":
            case "private":
            case "synchronized":
            case "final":
                break;

            default:
                throw new Fail(e, "Modifier [" + modifier + "] is not accepted on accessor method.");
            }
        }
        return modifiers.isEmpty() ? "" : modifiers.concat(" ");
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
            return CodeGenerator.Assignable + Strings.capitalize(name);
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
     * Detect getter modifier.
     * 
     * @return
     */
    public boolean isPrivateGetter() {
        return getterModifier.contains("private");
    }

    /**
     * Detect setter modifier.
     * 
     * @return
     */
    public boolean isPrivateSetter() {
        return setterModifier.contains("private");
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
