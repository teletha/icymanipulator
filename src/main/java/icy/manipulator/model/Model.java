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

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

import icy.manipulator.CodeAnalyzer;
import icy.manipulator.Fail;
import icy.manipulator.Type;
import icy.manipulator.Utility;

public class Model {

    /** The source code location. */
    private final TypeElement e;

    /** The parent model. */
    private final Optional<Model> parent;

    /** The model name. */
    private final String name;

    /** The required properties API. */
    private final List<Type> requiredPropertyAPI = new LinkedList();

    /**
     * 
     */
    public Model(Element element) {
        if (element.getKind() != ElementKind.CLASS) {
            throw new Fail(element, Model.class.getSimpleName() + " requires class.");
        }
        this.e = (TypeElement) element;
        this.name = e.getSimpleName().toString();
        this.parent = analyzeParent(e);
    }

    /**
     * Analuze {@link Model} by its {@link Element}.
     * 
     * @return Chainable API.
     */
    private Model analyze() {
        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() != ElementKind.INTERFACE) {
                continue;
            }

            TypeElement type = (TypeElement) element;
            String name = type.getSimpleName().toString();

            if (name.equals(CodeAnalyzer.AssignableAll)) {
                continue;
            }

            if (name.equals(CodeAnalyzer.ArbitraryInterface)) {
                continue;
            }
            requiredPropertyAPI.add(Type.of(element.asType()));
        }

        return this;
    }

    /**
     * Analyze parent class recursively.
     * 
     * @param e
     * @return
     */
    private Optional<Model> analyzeParent(TypeElement e) {
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
                .map(i -> new Model(parent).analyze())
                .or(() -> analyzeParent(parent));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Model [" + name + " api: " + requiredPropertyAPI + " parent: " + parent + "]";
    }
}
