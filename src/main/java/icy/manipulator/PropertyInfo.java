/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.util.Set;
import java.util.function.Supplier;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;

import apty.Apty;
import apty.Fail;
import apty.code.Type;
import icy.manipulator.Icy.Property;
import icy.manipulator.util.Strings;

public class PropertyInfo {

    /** The actual source element. */
    public final ExecutableElement element;

    /** The property name. */
    public final String name;

    /** The type name. */
    public final Type type;

    /** The property state. */
    public final boolean arbitrary;

    /** The property type. */
    public final boolean nullable;

    /** The property type. */
    public final boolean mutable;

    /** The property type. */
    public final boolean copiable;

    /** The proeprty type. */
    public final boolean autoExpandable;

    /** The property modifier. */
    public final String modifier;

    /** The classic getter modifier. */
    public final String getterModifier;

    /** The classic setter modifier. */
    public final String setterModifier;

    /** The customizer definition. */
    public final CustomizerInfo custom;

    /**
     * @param method
     */
    public PropertyInfo(ExecutableElement method) {
        this.element = method;
        this.name = method.getSimpleName().toString();
        this.type = Type.of(method.getReturnType());
        this.modifier = validatePropertyModifier(method);
        this.arbitrary = !method.getModifiers().contains(Modifier.ABSTRACT) || OptionalSupport.by(type).isPresent();

        Property annotation = method.getAnnotation(Icy.Property.class);

        if (annotation == null) {
            this.nullable = false;
            this.mutable = false;
            this.copiable = false;
            this.autoExpandable = true;
            this.getterModifier = "";
            this.setterModifier = "";
            this.custom = null;
        } else {
            this.nullable = annotation.nullable();
            this.mutable = annotation.mutable();
            this.copiable = annotation.copiable();
            this.autoExpandable = annotation.overloadEnum();
            Icy icy = method.getEnclosingElement().getAnnotation(Icy.class);
            this.getterModifier = validate(method, annotation.getterModifier(), icy.getterModifier());
            this.setterModifier = validate(method, annotation.setterModifier(), icy.setterModifier());
            this.custom = Apty.annotationClassValue(method, Icy.Property.class, "custom")
                    .filter(e -> !Apty.same(e, Supplier.class))
                    .flatMap(e -> Apty.asTypeElement(e))
                    .map(customizer -> new CustomizerInfo(this, customizer))
                    .orElse(null);
        }
    }

    /**
     * Validate property modifier.
     * 
     * @param e
     * @return
     */
    private String validatePropertyModifier(Element e) {
        Set<Modifier> modifiers = e.getModifiers();

        if (modifiers.contains(Modifier.PUBLIC)) {
            return "public final ";
        } else if (modifiers.contains(Modifier.PROTECTED)) {
            return "protected final ";
        } else if (modifiers.contains(Modifier.PRIVATE)) {
            throw new Fail(e, "Modifier [private] is not accepted on property.");
        } else {
            return "final ";
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
        if (arbitrary) {
            return IcyManipulator.ArbitraryInterface;
        } else {
            return IcyManipulator.Assignable + Strings.capitalize(name);
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
        return type + " " + element;
    }
}