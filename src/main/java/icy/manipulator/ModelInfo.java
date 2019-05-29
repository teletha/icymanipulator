/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import apty.Apty;
import apty.Fail;
import apty.code.Type;
import icy.manipulator.Icy.Intercept;
import icy.manipulator.Icy.Overload;
import icy.manipulator.util.Lists;
import icy.manipulator.util.Strings;

public class ModelInfo {

    /** The source code location. */
    public final TypeElement e;

    /** The parent model. */
    public final Optional<ModelInfo> parent;

    /** The model name. */
    public final String name;

    /** The model type. */
    public final Type type;

    /** The implementaion type. */
    public final Type implType;

    /** The required properties. */
    private final List<PropertyInfo> requiredProperties = new LinkedList();

    /** The arbitrary properties. */
    private final List<PropertyInfo> arbitraryProperties = new LinkedList();

    /** The overload method for each property */
    private final Items<MethodInfo> overloadForProperty = new Items();

    /** The intercept method for each property */
    private final Items<MethodInfo> interceptForProperty = new Items();

    /**
     * 
     */
    public ModelInfo(Element element) {
        if (element.getKind() != ElementKind.CLASS) {
            throw new Fail(element, ModelInfo.class.getSimpleName() + " requires class.");
        }
        this.e = (TypeElement) element;
        this.parent = analyzeParent(e);

        Icy icy = element.getAnnotation(Icy.class);

        if (icy == null) {
            // by generated implementation
            TypeElement model = Apty.parent(e);
            this.name = model.getSimpleName().toString();
            this.type = Type.of(model);
            this.implType = Type.of(e);
        } else {
            // by defined model
            this.name = e.getSimpleName().toString();
            this.type = Type.of(e);
            this.implType = Type.of(e.getQualifiedName().toString().replaceAll(icy.modelNamePattern() + "$", "$1"));

            // validate in 3 times, don't validate all once
            Apty.methods(e).forEach(this::validateProperty);
            Apty.methods(e).forEach(this::validateOverload);
            Apty.methods(e).forEach(this::validateIntercept);
        }
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

        if (returnType.kind == TypeKind.VOID) {
            throw new Fail(method, "Property declaring method must return something.");
        }

        PropertyInfo property = new PropertyInfo(method);

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
            MethodInfo method = new MethodInfo(m);
            String targetProperty = overload.value().isEmpty() ? method.name : overload.value();

            PropertyInfo property = findPropertyByName(targetProperty);

            if (!method.returnType.equals(property.type)) {
                throw new Fail(m, "Overload method [" + method + "] must return the same type of the target property [" + property + "].");
            }
            overloadForProperty.add(property, method);
        }
    }

    /**
     * Validate intercept methods.
     */
    private void validateIntercept(ExecutableElement m) {
        Intercept intercept = m.getAnnotation(Icy.Intercept.class);

        if (intercept != null) {
            MethodInfo method = new MethodInfo(m);
            String targetProperty = intercept.value().isEmpty() ? method.name : intercept.value();

            PropertyInfo property = findPropertyByName(targetProperty);

            if (!method.returnType.equals(property.type)) {
                throw new Fail(m, "Intercept method [" + method + "] must return the same type of the target property [" + property + "].");
            }

            if (method.paramTypes.isEmpty() || !method.paramTypes.get(0).is(property.type)) {
                throw new Fail(m, "Intercept method [" + method + "] requires the same parameter type of the target property [" + property + "].");
            }

            for (int i = 1; i < method.paramTypes.size(); i++) {
                Type type = method.paramTypes.get(i);

                if (!type.is(Consumer.class) && !type.is(IntConsumer.class) && !type.is(LongConsumer.class) && !type
                        .is(DoubleConsumer.class)) {
                    throw new Fail(m, "Intercept method [" + method + "] can reference Consumer, IntConsumer, LongConsumer or DoubleConsumer (in java.util.function package) as property setter. " + Strings
                            .ordinal(i + 1) + " argument [" + type + "] is invalid.");
                }

                // check property
                String propertyName = method.paramNames.get(i);

                findPropertyByName(propertyName, m, "Although intercept method [" + method + "] references a setter of the property [" + propertyName + "] at " + Strings
                        .ordinal(i + 1) + " argument, the property is not defined in " + name + " model. Define new [" + propertyName + "] property or specify a collect property name.");
            }
            interceptForProperty.add(property, new MethodInfo(m));
        }
    }

    /**
     * Add required property.
     */
    public void addRequiredProperty(PropertyInfo property) {
        requiredProperties.add(property);
    }

    /**
     * Add arbitrary property.
     */
    public void addArbitraryProperty(PropertyInfo property) {
        arbitraryProperties.add(property);
    }

    /**
     * List up all proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyInfo> ownProperties() {
        return Lists.merge(requiredProperties, arbitraryProperties);
    }

    /**
     * List up all mutable proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyInfo> ownMutableProperties() {
        return ownProperties().stream().filter(p -> p.mutable).collect(Collectors.toUnmodifiableList());
    }

    /**
     * List up all required proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyInfo> ownRequiredProperties() {
        return Collections.unmodifiableList(requiredProperties);
    }

    /**
     * List up all required proeprties on this own model.
     * 
     * @return
     */
    public List<PropertyInfo> ownArbitraryProperties() {
        return Collections.unmodifiableList(arbitraryProperties);
    }

    /**
     * List up all required proeprties on ancestors and own.
     * 
     * @return
     */
    public List<PropertyInfo> requiredProperties() {
        if (parent.isEmpty()) {
            return ownRequiredProperties();
        } else {
            List<PropertyInfo> properties = new ArrayList();
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
    public Optional<PropertyInfo> firstRequiredProperty() {
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
     * Check whether this model has any intercept property method on self or ancestors.
     * 
     * @return
     */
    public boolean hasIntercept() {
        return interceptForProperty.holder.isEmpty() == false;
    }

    /**
     * Compute API route variable for required properties.
     * 
     * @param destination
     * @return
     */
    public String requiredRouteType(int depature, String destination) {
        StringBuilder builder = new StringBuilder();
        List<PropertyInfo> properties = requiredProperties();

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
    public PropertyInfo findPropertyByName(String name) {
        return findPropertyByName(name, () -> new Fail(e, "Although you specify the property [" + name + "], it is not found. Specify the correct property name."));
    }

    /**
     * Find property by name.
     * 
     * @param name A property name.
     * @return
     */
    public PropertyInfo findPropertyByName(String name, Element location, String message) {
        return findPropertyByName(name, () -> new Fail(location, message));
    }

    /**
     * Find property by name.
     * 
     * @param name A property name.
     * @return
     */
    public PropertyInfo findPropertyByName(String name, Supplier<Fail> notFound) {
        return ownProperties().stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .or(() -> parent.map(m -> m.findPropertyByName(name)))
                .orElseThrow(notFound);
    }

    /**
     * List up all overload methods for the specified property.
     * 
     * @param property A target property.
     * @return A list of overload methods.
     */
    public List<MethodInfo> findOverloadsFor(PropertyInfo property) {
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
     * List up all intercept methods for the specified property.
     * 
     * @param property A target property.
     * @return A list of intercept methods.
     */
    public List<MethodInfo> findInterceptsFor(PropertyInfo property) {
        return interceptForProperty.find(property);
    }

    /**
     * Find the nearest ancestor model which has any arbitrary property.
     * 
     * @return
     */
    public Optional<ModelInfo> findNearestArbitraryModel() {
        return parent.flatMap(p -> {
            if (p.arbitraryProperties.isEmpty()) {
                return p.findNearestArbitraryModel();
            } else {
                return Optional.of(p);
            }
        });
    }

    /**
     * Analuze {@link ModelInfo} by its {@link Element}.
     * 
     * @return Chainable API.
     */
    private ModelInfo analyze() {
        List<ExecutableElement> parentMethods = Apty.getters(Apty.parent(e));

        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() != ElementKind.INTERFACE) {
                continue;
            }

            TypeElement type = (TypeElement) element;
            String name = type.getSimpleName().toString();

            if (name.equals(IcyManipulator.AssignableAll)) {
                root: for (TypeMirror interfaceType : type.getInterfaces()) {
                    // estimate property name
                    String interfaceName = Apty.simpleName(interfaceType);

                    if (interfaceName.startsWith(IcyManipulator.Assignable)) {
                        String proerptyName = Strings.decapitalize(interfaceName.substring(IcyManipulator.Assignable.length()));

                        for (ExecutableElement getter : parentMethods) {
                            // check name
                            if (!getter.getSimpleName().contentEquals(proerptyName)) {
                                continue;
                            }

                            PropertyInfo property = new PropertyInfo(getter);
                            requiredProperties.add(property);

                            for (ExecutableElement method : Apty.methods(interfaceType)) {
                                List<? extends VariableElement> parameters = method.getParameters();

                                if (parameters.size() != 1 || Apty.diff(getter.getReturnType(), parameters.get(0))) {
                                    overloadForProperty.add(property, new MethodInfo(method));
                                }
                            }
                            continue root;
                        }
                    }
                }
            } else if (name.equals(IcyManipulator.ArbitraryInterface)) {
                List<ExecutableElement> setters = Apty.setters(type);

                root: for (ExecutableElement getter : parentMethods) {
                    for (ExecutableElement setter : setters) {
                        // check name
                        if (!getter.getSimpleName().equals(setter.getSimpleName())) {
                            continue;
                        }

                        // check type
                        if (!Apty.same(getter.getReturnType(), setter.getParameters().get(0))) {
                            continue;
                        }
                        arbitraryProperties.add(new PropertyInfo(getter));
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
    private Optional<ModelInfo> analyzeParent(TypeElement e) {
        // search parent class
        TypeElement parent = Apty.parent(e);

        if (parent == null) {
            return Optional.empty();
        }

        return parent.getEnclosedElements()
                .stream()
                .filter(i -> i.getKind() == ElementKind.INTERFACE)
                .map(i -> (TypeElement) i)
                .filter(i -> i.getQualifiedName().toString().endsWith(IcyManipulator.ArbitraryInterface))
                .findFirst()
                .map(i -> new ModelInfo(parent).analyze())
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
     * Special KVS for {@link PropertyInfo}.
     */
    private static class Items<T> {

        /** The actual item holder. */
        private HashMap<PropertyInfo, List<T>> holder = new HashMap();

        /**
         * Add item.
         * 
         * @param property A key property.
         * @param item An item to add.
         */
        private void add(PropertyInfo property, T item) {
            holder.computeIfAbsent(property, p -> new LinkedList<T>()).add(item);
        }

        /**
         * Find items.
         * 
         * @param property A kye property.
         * @return A list of stored items.
         */
        private List<T> find(PropertyInfo property) {
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
