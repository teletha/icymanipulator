/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty.code;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import icy.manipulator.util.Lists;

public class TypeParams implements Codable {

    private final List<Type> types;

    /**
     * @param types
     */
    public TypeParams(Type... types) {
        this(List.of(types));
    }

    /**
     * @param types
     */
    public TypeParams(List<Type> types) {
        this.types = types;
    }

    /**
     * Size of type variables.
     * 
     * @return
     */
    public int size() {
        return types.size();
    }

    /**
     * List up all types.
     * 
     * @return
     */
    public Stream<Type> stream() {
        return types.stream();
    }

    /**
     * Create new {@link TypeParams} which all variables are raw.
     * 
     * @return A new {@link TypeParams}.
     */
    public TypeParams declared() {
        return new TypeParams(types.stream().map(Type::declared).collect(Collectors.toUnmodifiableList()));
    }

    /**
     * Get type variable at head.
     * 
     * @return
     */
    public Type head() {
        return types.get(0);
    }

    /**
     * Create merged variable types at tail.
     * 
     * @return
     */
    public TypeParams tail(TypeParams types) {
        return new TypeParams(Lists.merge(this.types, types.types));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        StringJoiner builder = new StringJoiner(", ", "<", ">").setEmptyValue("");
        types.forEach(v -> builder.add(v.write(coder)));
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TypeParams == false) {
            return false;
        }

        TypeParams other = (TypeParams) obj;

        return types.toString().equals(other.types.toString());
    }

    /**
     * Create new variable {@link TypeParams}.
     * 
     * @param variable
     * @return
     */
    public static TypeParams var(String variable) {
        return new TypeParams(Type.var(variable));
    }
}
