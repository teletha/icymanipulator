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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import icy.manipulator.CodeAnalyzer;
import icy.manipulator.Fail;
import icy.manipulator.Type;
import icy.manipulator.Utility;

public class ModelDefinition {

    /** The source code location. */
    private final TypeElement e;

    /** The parent model. */
    private final Optional<ModelDefinition> parent;

    /** The model name. */
    private final String name;

    /** The required properties. */
    private final List<PropertyDefinition> requiredProperties = new LinkedList();

    /** The required properties API. */
    private final List<Type> requiredPropertyAPI = new LinkedList();

    /** The arbitrary properties. */
    private final List<PropertyDefinition> arbitraryProperties = new LinkedList();

    /** The arbitrary properties API. */
    private final List<Type> arbitraryPropertyAPI = new LinkedList();

    /**
     * 
     */
    public ModelDefinition(Element element) {
        if (element.getKind() != ElementKind.CLASS) {
            throw new Fail(element, ModelDefinition.class.getSimpleName() + " requires class.");
        }
        this.e = (TypeElement) element;
        this.name = e.getSimpleName().toString();
        this.parent = analyzeParent(e);
    }

    /**
     * Add required property.
     */
    public void addRequiredProperty(PropertyDefinition property) {
        requiredProperties.add(property);
    }

    /**
     * Add arbitrary property.
     */
    public void addArbitraryProperty(PropertyDefinition property) {
        arbitraryProperties.add(property);
    }

    /**
     * List up all proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyDefinition> ownProperties() {
        return merge(requiredProperties, arbitraryProperties);
    }

    /**
     * List up all required proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyDefinition> ownRequiredProperties() {
        return Collections.unmodifiableList(requiredProperties);
    }

    /**
     * List up all required proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyDefinition> ownArbitraryProperties() {
        return Collections.unmodifiableList(arbitraryProperties);
    }

    /**
     * Analuze {@link ModelDefinition} by its {@link Element}.
     * 
     * @return Chainable API.
     */
    private ModelDefinition analyze() {
        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() != ElementKind.INTERFACE) {
                continue;
            }

            TypeElement type = (TypeElement) element;
            String name = type.getSimpleName().toString();

            if (name.equals(CodeAnalyzer.AssignableAll)) {
                for (TypeMirror interfaceType : type.getInterfaces()) {
                    requiredPropertyAPI.add(Type.of(interfaceType));
                }
            } else if (name.equals(CodeAnalyzer.ArbitraryInterface)) {
                arbitraryPropertyAPI.add(Type.of(type));
            }
        }

        return this;
    }

    /**
     * Analyze parent class recursively.
     * 
     * @param e
     * @return
     */
    private Optional<ModelDefinition> analyzeParent(TypeElement e) {
        // search parent class
        TypeElement parent = (TypeElement) Utility.types.asElement(e.getSuperclass());

        if (parent == null) {
            return Optional.empty();
        }

        return parent.getEnclosedElements()
                .stream()
                .filter(i -> i.getKind() == ElementKind.INTERFACE)
                .map(i -> (TypeElement) i)
                .filter(i -> i.getQualifiedName().toString().endsWith(CodeAnalyzer.ArbitraryInterface))
                .findFirst()
                .map(i -> new ModelDefinition(parent).analyze())
                .or(() -> analyzeParent(parent));
    }

    private static final String End = "\r\n";

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        parent.ifPresent(m -> {
            builder.append(m.toString());
        });

        builder.append(name).append(" ").append(e.getAnnotationMirrors()).append(End);
        builder.append("    required: ").append(merge(requiredProperties, requiredPropertyAPI)).append(End);
        builder.append("    arbitrary: ").append(merge(arbitraryProperties, arbitraryPropertyAPI)).append(End);

        return builder.toString();
    }

    /**
     * Helper.
     * 
     * @param one
     * @param other
     * @return
     */
    private List merge(List one, List other) {
        List merged = new ArrayList(one.size() + other.size());
        merged.addAll(one);
        merged.addAll(other);

        return merged;
    }
}
