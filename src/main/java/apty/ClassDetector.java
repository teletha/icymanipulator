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

import java.util.Arrays;
import java.util.stream.Stream;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class ClassDetector extends Detector {

    /** The target type. */
    private final Class type;

    /**
     * Type detector.
     * 
     * @param type
     */
    public ClassDetector(Class type) {
        this.type = type;
    }

    /**
     * Check whether this type is annotation or not.
     * 
     * @return
     */
    @Override
    public boolean isAnnotation() {
        return type.isAnnotation();
    }

    /**
     * Check whether this type is array or not.
     * 
     * @return
     */
    @Override
    public boolean isArray() {
        return type.isArray();
    }

    /**
     * Check whether this type is enum or not.
     * 
     * @return
     */
    @Override
    public boolean isEnum() {
        return type.isEnum();
    }

    /**
     * Check whether this type is interface or not.
     * 
     * @return
     */
    @Override
    public boolean isInterface() {
        return type.isInterface();
    }

    /**
     * Check whether this type is primitive or not.
     * 
     * @return
     */
    @Override
    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(Class parent) {
        return type.isAssignableFrom(parent);
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(TypeElement parent) {
        return isAssignableFrom(parent.asType());
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(TypeMirror parent) {
        return false;
    }

    /**
     * Returns the elements of this enum class or empty if this Class object does not represent an
     * enum type.
     * 
     * @return A stream containing the values comprising the enum class represented by this type in
     *         the order they're declared, or empty if this type does not represent an enum type.
     */
    @Override
    public Stream<String> getEnumConstants() {
        if (isEnum()) {
            return Arrays.stream(type.getEnumConstants()).map(e -> {
                try {
                    return (String) e.getClass().getMethod("name").invoke(e);
                } catch (Exception error) {
                    throw new Error(error);
                }
            });
        } else {
            return Stream.empty();
        }
    }
}
