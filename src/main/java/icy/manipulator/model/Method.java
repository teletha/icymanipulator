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

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.ExecutableType;

import icy.manipulator.Type;

public class Method {

    /** The actual element. */
    public final ExecutableElement element;

    /** The method name. */
    public final String name;

    /** The identifier. */
    public final String id;

    /** The return type. */
    public final Type returnType;

    /** The parameter types. */
    public final List<Type> paramTypes;

    /** The parameter names. */
    public final List<String> paramNames;

    /**
     * @param element
     */
    public Method(ExecutableElement element) {
        this.element = element;
        this.name = element.getSimpleName().toString();
        this.id = element.toString().replaceAll("[\\s,\\(\\)\\.]", "");
        this.returnType = Type.of(element.getReturnType());
        this.paramTypes = ((ExecutableType) element.asType()).getParameterTypes()
                .stream()
                .map(Type::of)
                .collect(Collectors.toUnmodifiableList());
        this.paramNames = element.getParameters().stream().map(e -> e.getSimpleName().toString()).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Detect parameter size.
     * 
     * @return
     */
    public boolean hasParameter() {
        return !paramTypes.isEmpty();
    }

    /**
     * Retrieve the specified annotation.
     * 
     * @param <A>
     * @param type
     * @return
     */
    public <A extends Annotation> A getAnnotation(Class<A> type) {
        return element.getAnnotation(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(", ", name + "(", ")");
        for (Type type : paramTypes) {
            builder.add(type.className);
        }
        return builder.toString();
    }
}
