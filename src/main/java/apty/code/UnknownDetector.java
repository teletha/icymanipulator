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

import java.util.stream.Stream;

import apty.ClassLike;
import apty.MethodLike;

/**
 * 
 */
public class UnknownDetector implements ClassLike {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnnotation() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isArray() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnum() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInterface() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPrimitive() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getParent() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Type> getInterfaces() {
        return Stream.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Type> getDeclaredClasses() {
        return Stream.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<String> getEnumConstants() {
        return Stream.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<MethodLike> getMethods() {
        return Stream.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<MethodLike> getDeclaredMethods() {
        return Stream.empty();
    }
}