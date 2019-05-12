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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

import icy.manipulator.CodeGenerator;
import icy.manipulator.Fail;
import icy.manipulator.Icy;
import icy.manipulator.Icy.Overload;
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
    public final Type implType;

    /** The required properties. */
    private final List<PropertyDefinition> requiredProperties = new LinkedList();

    /** The arbitrary properties. */
    private final List<PropertyDefinition> arbitraryProperties = new LinkedList();

    /** The overload method for each property */
    private final Items<MethodDefinition> overloadForProperty = new Items();

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
            this.implType = Type.of(e);
        } else {
            // by defined model
            this.name = e.getSimpleName().toString();
            this.type = Type.of(e);
            this.implType = Type.of(e.getQualifiedName().toString().replaceAll(icy.modelNamePattern() + "$", "$1"));
            TypeUtil.methods(e).forEach(m -> {
                validateProperty(m);
                validateOverload(m);
            });
        }

        this.parent = analyzeParent(e);
    }

    /**
     * Validate property methods.
     */
    private void validateProperty(ExecutableElement method) {
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
     * Validate overload methods.
     */
    private void validateOverload(ExecutableElement m) {
        Overload overload = m.getAnnotation(Icy.Overload.class);

        if (overload != null) {
            MethodDefinition method = new MethodDefinition(m);
            String targetProperty = overload.value().isEmpty() ? method.name : overload.value();

            PropertyDefinition property = findPropertyByName(targetProperty);

            if (!method.returnType.equals(property.type)) {
                throw new Fail(m, "Although the property [" + targetProperty + "] type is " + method.returnType + ", overload method [" + method + "] returns " + method.returnType + ".");
            }
            overloadForProperty.add(property, method);
        }
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
     * List up all required proeprties on ancestors and own.
     * 
     * @return
     */
    public List<PropertyDefinition> requiredProperties() {
        if (parent.isEmpty()) {
            return ownRequiredProperties();
        } else {
            List<PropertyDefinition> properties = new ArrayList();
            properties.addAll(parent.get().requiredProperties());
            properties.addAll(requiredProperties);
            return properties;
        }
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
     * Check whether this model has any overload property method on self or ancestors.
     * 
     * @return
     */
    public boolean hasOverload() {
        if (overloadForProperty.holder.isEmpty() == false) {
            return true;
        }
        return parent.map(p -> p.hasOverload()).orElse(false);
    }

    /**
     * Compute API route variable for required properties.
     * 
     * @param destination
     * @return
     */
    public String requiredRouteType(int depature, String destination) {
        StringBuilder builder = new StringBuilder();
        List<PropertyDefinition> properties = requiredProperties();

        for (int i = depature; i < properties.size(); i++) {
            builder.append(properties.get(i).assignableInterfaceName()).append("<");
        }
        builder.append(destination);
        for (int i = depature; i < properties.size(); i++) {
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
        return ownProperties().stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .or(() -> parent.map(m -> m.findPropertyByName(name)))
                .orElseThrow(() -> new Fail(e, "Although you specify the property [" + name + "], it is not found. Specify the correct property name."));
    }

    /**
     * List up all overload method for the specified property.
     * 
     * @param property A target property.
     * @return A list of overload methods.
     */
    public List<MethodDefinition> findOverloadsFor(PropertyDefinition property) {
        if (overloadForProperty.holder.containsKey(property)) {
            return overloadForProperty.find(property);
        } else {
            if (parent.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return parent.get().findOverloadsFor(property);
            }
        }
    }

    /**
     * Find the nearest ancestor model which has any arbitrary property.
     * 
     * @return
     */
    public Optional<ModelDefinition> findNearestArbitraryModel() {
        return parent.flatMap(p -> {
            if (p.arbitraryProperties.isEmpty()) {
                return p.findNearestArbitraryModel();
            } else {
                return Optional.of(p);
            }
        });
    }

    /**
     * Analuze {@link ModelDefinition} by its {@link Element}.
     * 
     * @return Chainable API.
     */
    private ModelDefinition analyze() {
        List<ExecutableElement> parentMethods = TypeUtil.getters(TypeUtil.parent(e));

        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() != ElementKind.INTERFACE) {
                continue;
            }

            TypeElement type = (TypeElement) element;
            String name = type.getSimpleName().toString();

            if (name.equals(CodeGenerator.AssignableAll)) {
                root: for (TypeMirror interfaceType : type.getInterfaces()) {
                    // estimate property name
                    String interfaceName = TypeUtil.simpleName(interfaceType);

                    if (interfaceName.startsWith(CodeGenerator.Assignable)) {
                        String proerptyName = TypeUtil.decapitalize(interfaceName.substring(CodeGenerator.Assignable.length()));

                        for (ExecutableElement getter : parentMethods) {
                            // check name
                            if (!getter.getSimpleName().contentEquals(proerptyName)) {
                                continue;
                            }

                            PropertyDefinition property = new PropertyDefinition(getter);
                            requiredProperties.add(property);

                            for (ExecutableElement method : TypeUtil.methods(interfaceType)) {
                                List<? extends VariableElement> parameters = method.getParameters();

                                if (parameters.size() != 1 || TypeUtil.diff(getter.getReturnType(), parameters.get(0))) {
                                    overloadForProperty.add(property, new MethodDefinition(method));
                                }
                            }
                            continue root;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String End = "\r\n";
        StringBuilder builder = new StringBuilder();

        parent.ifPresent(m -> {
            builder.append(m.toString());
        });

        builder.append(name).append(" ").append(e.getAnnotationMirrors()).append(End);
        builder.append("    required: ").append(requiredProperties).append(End);
        builder.append("    arbitrary: ").append(arbitraryProperties).append(End);
        builder.append("    overload: ").append(overloadForProperty).append(End);

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

    /**
     * Special KVS for {@link PropertyDefinition}.
     */
    private static class Items<T> {

        /** The actual item holder. */
        private HashMap<PropertyDefinition, List<T>> holder = new HashMap();

        /**
         * Add item.
         * 
         * @param property A key property.
         * @param item An item to add.
         */
        private void add(PropertyDefinition property, T item) {
            holder.computeIfAbsent(property, p -> new LinkedList<T>()).add(item);
        }

        /**
         * Find items.
         * 
         * @param property A kye property.
         * @return A list of stored items.
         */
        private List<T> find(PropertyDefinition property) {
            return holder.computeIfAbsent(property, p -> new LinkedList());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return holder.toString();
        }
    }
}
