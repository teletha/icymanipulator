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

import apty.code.Type;

public interface ClassLike {

    /**
     * Check whether this type is annotation or not.
     * 
     * @return
     */
    boolean isAnnotation();

    /**
     * Check whether this type is array or not.
     * 
     * @return
     */
    boolean isArray();

    /**
     * Check whether this type is enum or not.
     * 
     * @return
     */
    boolean isEnum();

    /**
     * Check whether this type is interface or not.
     * 
     * @return
     */
    boolean isInterface();

    /**
     * Check whether this type is primitive or not.
     * 
     * @return
     */
    boolean isPrimitive();

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    boolean isAssignableFrom(Class parent);

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    default boolean isAssignableFrom(TypeElement parent) {
        return isAssignableFrom(parent.asType());
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    boolean isAssignableFrom(TypeMirror parent);

    Type getParent();

    /**
     * Returns the elements of this enum class or empty if this Class object does not represent an
     * enum type.
     * 
     * @return A stream containing the values comprising the enum class represented by this type in
     *         the order they're declared, or empty if this type does not represent an enum type.
     */
    Stream<String> getEnumConstants();

    Stream<MethodLike> getMethods();

    Stream<MethodLike> getDeclaredMethods();
}
