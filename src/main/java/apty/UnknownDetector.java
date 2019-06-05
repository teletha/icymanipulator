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

import java.util.stream.Stream;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class UnknownDetector extends Detector {

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
    public boolean isAssignableFrom(Class parent) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAssignableFrom(TypeElement parent) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAssignableFrom(TypeMirror parent) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<String> getEnumConstants() {
        return Stream.empty();
    }
}
