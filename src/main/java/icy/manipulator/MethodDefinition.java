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
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.ExecutableType;

import apty.Apty;
import apty.Type;
import icy.manipulator.util.Strings;

public class MethodDefinition {

    /** The method name. */
    public final String name;

    /** The return type. */
    public final Type returnType;

    /** The parameter types. */
    public final List<Type> paramTypes;

    /** The parameter names. */
    public final List<String> paramNames;

    /** The documentation. */
    public final String doc;

    /**
     * @param element
     */
    public MethodDefinition(ExecutableElement element) {
        this.name = element.getSimpleName().toString();
        this.returnType = Type.of(element.getReturnType());
        this.paramTypes = ((ExecutableType) element.asType()).getParameterTypes()
                .stream()
                .map(Type::of)
                .collect(Collectors.toUnmodifiableList());
        this.paramNames = element.getParameters().stream().map(e -> e.getSimpleName().toString()).collect(Collectors.toUnmodifiableList());
        this.doc = Apty.doc(element);
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     */
    public MethodDefinition(String name, Class returnType) {
        this(name, returnType, List.of(), List.of());
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    public MethodDefinition(String name, Class returnType, Class type1, String name1) {
        this(name, returnType, List.of(type1), List.of(name1));
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    public MethodDefinition(String name, Class returnType, Class type1, String name1, Class type2, String name2) {
        this(name, returnType, List.of(type1, type2), List.of(name1, name2));
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     * @param type1
     * @param name1
     */
    public MethodDefinition(String name, Class returnType, Class type1, String name1, Class type2, String name2, Class type3, String name3) {
        this(name, returnType, List.of(type1, type2, type3), List.of(name1, name2, name3));
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    public MethodDefinition(String name, Class returnType, List<Class> types, List<String> names) {
        this(name, Type.of(returnType), types.stream().map(Type::of).collect(Collectors.toUnmodifiableList()), names, "");
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     */
    public MethodDefinition(String name, Type returnType) {
        this(name, returnType, List.of(), List.of(), "");
    }

    /**
     * Create {@link MethodDefinition}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    public MethodDefinition(String name, Type returnType, List<Type> types, List<String> names, String doc) {
        this.name = name;
        this.returnType = returnType;
        this.paramTypes = types;
        this.paramNames = names;
        this.doc = doc;
    }

    /**
     * Compute the method identifier.
     * 
     * @return
     */
    public String id() {
        return name + "$" + Math.abs(paramTypes.hashCode());
    }

    /**
     * Build additional parameter names at head.
     * 
     * @param additions A list of additional names.
     * @return
     */
    public List<String> namesWithHead(String... additions) {
        List<String> names = new ArrayList(additions.length + paramNames.size());
        for (String name : additions) {
            names.add(name);
        }
        names.addAll(paramNames);

        return names;
    }

    /**
     * Build additional parameter names at head.
     * 
     * @param additions A list of additional names.
     * @return
     */
    public List<String> namesWithTail(String... additions) {
        List<String> names = new ArrayList(additions.length + paramNames.size());
        for (String name : additions) {
            names.add(name);
        }
        names.addAll(paramNames);

        return names;
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
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @return
     */
    public MethodDefinition withFirst(Class type) {
        return withFirst(Type.of(type));
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodDefinition withFirst(Class type, String name) {
        return withFirst(Type.of(type), name);
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @return
     */
    public MethodDefinition withFirst(Type type) {
        return withFirst(type, Strings.sanitize(Strings.decapitalize(type.className)));
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodDefinition withFirst(Type type, String name) {
        return new MethodDefinition(this.name, this.returnType, mergeFirst(paramTypes, type), mergeFirst(paramNames, name), doc);
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @return
     */
    public MethodDefinition withLast(Class type) {
        return withLast(Type.of(type));
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodDefinition withLast(Class type, String name) {
        return withLast(Type.of(type), name);
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @return
     */
    public MethodDefinition withLast(Type type) {
        return withLast(type, Strings.sanitize(Strings.decapitalize(type.className)));
    }

    /**
     * Create {@link MethodDefinition} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodDefinition withLast(Type type, String name) {
        return new MethodDefinition(this.name, this.returnType, mergeLast(paramTypes, type), mergeLast(paramNames, name), doc);
    }

    /**
     * Add item at first.
     * 
     * @param base
     * @param item
     * @param <T>
     * @return
     */
    private <T> List<T> mergeFirst(List<T> base, T item) {
        List<T> list = new ArrayList(base.size() + 1);
        list.add(item);
        list.addAll(base);
        return Collections.unmodifiableList(list);
    }

    /**
     * Add item at last.
     * 
     * @param <T>
     * @param base
     * @param item
     * @return
     */
    private <T> List<T> mergeLast(List<T> base, T item) {
        List<T> list = new ArrayList(base.size() + 1);
        list.addAll(base);
        list.add(item);
        return Collections.unmodifiableList(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, returnType, paramTypes, paramNames);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MethodDefinition == false) {
            return false;
        }

        MethodDefinition other = (MethodDefinition) obj;

        if (!name.equals(other.name)) {
            return false;
        }

        if (!returnType.equals(other.returnType)) {
            return false;
        }

        if (!paramTypes.equals(other.paramTypes)) {
            return false;
        }

        if (!paramNames.equals(other.paramNames)) {
            return false;
        }
        return true;
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
