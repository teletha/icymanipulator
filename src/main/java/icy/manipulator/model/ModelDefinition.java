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
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import icy.manipulator.CodeGenerator;
import icy.manipulator.Fail;
import icy.manipulator.Icy;
import icy.manipulator.Type;
import icy.manipulator.TypeUtil;

public class ModelDefinition {

    /** The source code location. */
    public final TypeElement e;

    /** The parent model. */
    public final Optional<ModelDefinition> parent;

    /** The model name. */
    public final String name;

    /** The model type. */
    public final Type type;

    /** The implementaion type. */
    public final Type implementationType;

    /** The required properties. */
    private final List<PropertyDefinition> requiredProperties = new LinkedList();

    /** The arbitrary properties. */
    private final List<PropertyDefinition> arbitraryProperties = new LinkedList();

    /** The overload method holder. */
    private final List<Method> overloads = new ArrayList();

    /** The overload method for each property */
    private final PropetyInfo<Method> overloadForProperty = new PropetyInfo();

    /**
     * 
     */
    public ModelDefinition(Element element) {
        if (element.getKind() != ElementKind.CLASS) {
            throw new Fail(element, ModelDefinition.class.getSimpleName() + " requires class.");
        }
        this.e = (TypeElement) element;

        Icy icy = element.getAnnotation(Icy.class);

        if (icy == null) {
            // by generated implementation
            TypeElement model = TypeUtil.parent(e);
            this.name = model.getSimpleName().toString();
            this.type = Type.of(model);
            this.implementationType = Type.of(e);
        } else {
            // by defined model
            this.name = e.getSimpleName().toString();
            this.type = Type.of(e);
            this.implementationType = Type.of(e.getQualifiedName().toString().replaceAll(icy.modelBase() + "$", ""));
            TypeUtil.methods(e).forEach(m -> {
                analyzeProperty(m);
            });
        }

        this.parent = analyzeParent(e);
    }

    /**
     * Analyze property methods.
     */
    private void analyzeProperty(ExecutableElement method) {
        // require annotation
        icy.manipulator.Icy.Property annotation = method.getAnnotation(Icy.Property.class);

        if (annotation == null) {
            return;
        }

        // require no parameter
        if (method.getParameters().size() != 0) {
            throw new Fail(method, "Property declaring method must have no parameter.");
        }

        Type returnType = Type.of(method.getReturnType());

        if (returnType.className.equalsIgnoreCase("void")) {
            throw new Fail(method, "Property declaring method must return something.");
        }

        PropertyDefinition property = new PropertyDefinition(method);

        if (property.isArbitrary) {
            addArbitraryProperty(property);
        } else {
            addRequiredProperty(property);
        }
    }

    /**
     * Analyze overload methods.
     */
    private void analyzeOverload() {

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
     * Find the first required property from ancestors and own.
     * 
     * @return
     */
    public Optional<PropertyDefinition> firstRequiredProperty() {
        return parent.flatMap(p -> p.firstRequiredProperty()).or(() -> requiredProperties.stream().findFirst());
    }

    /**
     * Check whether this model is subclass of other model or not.
     * 
     * @return
     */
    public boolean hasParent() {
        return parent.isPresent();
    }

    /**
     * Check whether this model is subclass of other model or not.
     * 
     * @return
     */
    public boolean hasNoParent() {
        return parent.isEmpty();
    }

    /**
     * Check whether this model has any required property on self or ancestors.
     * 
     * @return
     */
    public boolean hasRequiredProperty() {
        if (requiredProperties.size() != 0) {
            return true;
        }
        return parent.map(p -> p.hasRequiredProperty()).orElse(false);
    }

    /**
     * Check whether this model has any required property on self or ancestors.
     * 
     * @return
     */
    public boolean hasArbitraryProperty() {
        if (arbitraryProperties.size() != 0) {
            return true;
        }
        return parent.map(p -> p.hasArbitraryProperty()).orElse(false);
    }

    /**
     * Compute API route variable for required properties.
     * 
     * @param destination
     * @return
     */
    public String ownRequiredRouteType(String destination) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < requiredProperties.size(); i++) {
            builder.append(requiredProperties.get(i).assignableInterfaceName()).append("<");
        }
        builder.append(destination);
        for (int i = 0; i < requiredProperties.size(); i++) {
            builder.append(">");
        }
        return builder.toString();
    }

    /**
     * Compute API route variable for required properties.
     * 
     * @param destination
     * @return
     */
    public String ownRequiredRouteTypeWithoutFirst(String destination) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < requiredProperties.size(); i++) {
            builder.append(requiredProperties.get(i).assignableInterfaceName()).append("<");
        }
        builder.append(destination);
        for (int i = 1; i < requiredProperties.size(); i++) {
            builder.append(">");
        }
        return builder.toString();
    }

    /**
     * Find property by name.
     * 
     * @param name A property name.
     * @return
     */
    public PropertyDefinition findPropertyByName(String name) {
        return requiredProperties.stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .or(() -> parent.map(m -> m.findPropertyByName(name)))
                .orElseThrow(() -> new Fail(e, "Although you specify the property [" + name + "], it is not found. Specify the correct property name."));
    }

    /**
     * Analuze {@link ModelDefinition} by its {@link Element}.
     * 
     * @return Chainable API.
     */
    private ModelDefinition analyze() {
        List<ExecutableElement> parentMethods = TypeUtil.methods(TypeUtil.parent(e));

        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() != ElementKind.INTERFACE) {
                continue;
            }

            TypeElement type = (TypeElement) element;
            String name = type.getSimpleName().toString();

            if (name.equals(CodeGenerator.AssignableAll)) {
                for (TypeMirror interfaceType : type.getInterfaces()) {
                    // estimate property name
                    String interfaceName = TypeUtil.simpleName(interfaceType);

                    if (interfaceName.startsWith(CodeGenerator.Assignable)) {
                        String proerptyName = TypeUtil.decapitalize(interfaceName.substring(CodeGenerator.Assignable.length()));

                        for (ExecutableElement method : parentMethods) {
                            if (method.getSimpleName().contentEquals(proerptyName)) {
                                requiredProperties.add(new PropertyDefinition(method));
                            }
                        }
                    }
                }
            } else if (name.equals(CodeGenerator.ArbitraryInterface)) {
                List<ExecutableElement> setters = TypeUtil.setters(type);

                root: for (ExecutableElement getter : parentMethods) {
                    for (ExecutableElement setter : setters) {
                        // check name
                        if (!getter.getSimpleName().equals(setter.getSimpleName())) {
                            continue;
                        }

                        // check type
                        if (!TypeUtil.same(getter.getReturnType(), setter.getParameters().get(0))) {
                            continue;
                        }
                        arbitraryProperties.add(new PropertyDefinition(getter));
                        continue root;
                    }
                }
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
        TypeElement parent = TypeUtil.parent(e);

        if (parent == null) {
            return Optional.empty();
        }

        return parent.getEnclosedElements()
                .stream()
                .filter(i -> i.getKind() == ElementKind.INTERFACE)
                .map(i -> (TypeElement) i)
                .filter(i -> i.getQualifiedName().toString().endsWith(CodeGenerator.ArbitraryInterface))
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
        builder.append("    required: ").append(requiredProperties).append(End);
        builder.append("    arbitrary: ").append(arbitraryProperties).append(End);

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
