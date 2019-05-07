/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.ExecutableType;

class Method {

    /** The actual element. */
    final ExecutableElement element;

    /** The method name. */
    final String name;

    /** The identifier. */
    final String id;

    /** The return type. */
    final Type returnType;

    /** The parameter types. */
    final List<Type> parameterTypes;

    /** The parameter names. */
    final List<String> parameterNames;

    /**
     * @param element
     */
    Method(ExecutableElement element) {
        this.element = element;
        this.name = element.getSimpleName().toString();
        this.id = element.toString().replaceAll("[\\s,\\(\\)\\.]", "");
        this.returnType = Type.of(element.getReturnType());
        this.parameterTypes = ((ExecutableType) element.asType()).getParameterTypes()
                .stream()
                .map(Type::of)
                .collect(Collectors.toUnmodifiableList());
        this.parameterNames = element.getParameters()
                .stream()
                .map(e -> e.getSimpleName().toString())
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Detect parameter size.
     * 
     * @return
     */
    boolean hasParameter() {
        return !parameterTypes.isEmpty();
    }

    /**
     * Retrieve the specified annotation.
     * 
     * @param <A>
     * @param type
     * @return
     */
    <A extends Annotation> A getAnnotation(Class<A> type) {
        return element.getAnnotation(type);
    }
}
