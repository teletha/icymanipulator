/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.ExecutableType;

import apty.code.Codable;
import apty.code.Coder;
import apty.code.Type;

public class MethodLike implements Codable {

    /** The {@link Object#toString()} method pattern. */
    public static final Predicate<MethodLike> ToString = m -> {
        return m.paramTypes.size() == 0 && m.returnType.is(String.class) && m.name.equals("toString");
    };

    /** The {@link Object#hashCode()} method pattern. */
    public static final Predicate<MethodLike> HashCode = m -> {
        return m.paramTypes.size() == 0 && m.returnType.is(int.class) && m.name.equals("hashCode");
    };

    /** The {@link Object#equals(Object)} method pattern. */
    public static final Predicate<MethodLike> Equals = m -> {
        return m.paramTypes.size() == 1 && m.paramTypes.get(0).is(Object.class) && m.returnType.is(boolean.class) && m.name
                .equals("equals");
    };

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

    /** The user defined overload method. */
    public final boolean userDefiend;

    /** The code body. (OPTIONAL) */
    public final Codable code;

    /**
     * @param element
     */
    public MethodLike(ExecutableElement element) {
        this.name = element.getSimpleName().toString();
        this.returnType = Type.of(element.getReturnType());
        this.paramTypes = ((ExecutableType) element.asType()).getParameterTypes()
                .stream()
                .map(Type::of)
                .collect(Collectors.toUnmodifiableList());
        this.paramNames = element.getParameters().stream().map(e -> e.getSimpleName().toString()).collect(Collectors.toUnmodifiableList());
        this.doc = Apty.doc(element);
        this.userDefiend = true;
        this.code = null;
    }

    /**
     * @param element
     */
    public MethodLike(Method element) {
        this.name = element.getName();
        this.returnType = Type.of(element.getReturnType());
        this.paramTypes = Stream.of(element.getParameterTypes()).map(Type::of).collect(Collectors.toUnmodifiableList());
        this.paramNames = Stream.of(element.getParameters()).map(Parameter::getName).collect(Collectors.toUnmodifiableList());
        this.doc = "";
        this.userDefiend = false;
        this.code = null;
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     */
    public MethodLike(String name, Type returnType) {
        this(name, returnType, List.of(), List.of(), "");
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    public MethodLike(String name, Type returnType, List<Type> types, List<String> names, String doc) {
        this(name, returnType, types, names, doc, null);
    }

    /**
     * Create {@link MethodLike}.
     * 
     * @param name
     * @param returnType
     * @param types
     * @param names
     */
    public MethodLike(String name, Type returnType, List<Type> types, List<String> names, String doc, Codable body) {
        this.name = name;
        this.returnType = returnType;
        this.paramTypes = types;
        this.paramNames = names;
        this.doc = doc;
        this.userDefiend = false;
        this.code = body;
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
     * Create {@link MethodLike} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodLike withFirst(Class type, String name) {
        return withFirst(Type.of(type), name);
    }

    /**
     * Create {@link MethodLike} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodLike withFirst(Type type, String name) {
        return new MethodLike(this.name, this.returnType, mergeFirst(paramTypes, type), mergeFirst(paramNames, name), doc);
    }

    /**
     * Create {@link MethodLike} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodLike withLast(Class type, String name) {
        return withLast(Type.of(type), name);
    }

    /**
     * Create {@link MethodLike} with additional parameter.
     * 
     * @param type
     * @param name
     * @return
     */
    public MethodLike withLast(Type type, String name) {
        return new MethodLike(this.name, this.returnType, mergeLast(paramTypes, type), mergeLast(paramNames, name), doc);
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
        if (obj instanceof MethodLike == false) {
            return false;
        }

        MethodLike other = (MethodLike) obj;

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
            builder.add(type.name());
        }
        return returnType + " " + builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        StringJoiner params = new StringJoiner(", ", "(", ")");
        for (int i = 0; i < paramTypes.size(); i++) {
            if (i == paramTypes.size() - 1) {
                params.add(coder.use(paramTypes.get(i).varargnize()) + " " + paramNames.get(i));
            } else {
                params.add(coder.use(paramTypes.get(i)) + " " + paramNames.get(i));
            }
        }
        return name.concat(params.toString());
    }
}
