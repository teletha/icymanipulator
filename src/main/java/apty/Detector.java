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

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class Detector {

    /** The target type. */
    private final TypeMirror type;

    /** The utility. */
    private final Types types;

    /** The utility. */
    private final Elements elements;

    /**
     * Type detector.
     * 
     * @param type
     */
    Detector(TypeMirror type, Types types, Elements elements) {
        this.type = type;
        this.types = types;
        this.elements = elements;
    }

    /**
     * Check whether this type is annotation or not.
     * 
     * @return
     */
    public boolean isAnnotation() {
        return types.asElement(type).getKind() == ElementKind.ANNOTATION_TYPE;
    }

    /**
     * Check whether this type is array or not.
     * 
     * @return
     */
    public boolean isArray() {
        return type.getKind() == TypeKind.ARRAY;
    }

    /**
     * Check whether this type is enum or not.
     * 
     * @return
     */
    public boolean isEnum() {
        return types.asElement(type).getKind() == ElementKind.ENUM;
    }

    /**
     * Check whether this type is interface or not.
     * 
     * @return
     */
    public boolean isInterface() {
        return types.asElement(type).getKind() == ElementKind.INTERFACE;
    }

    /**
     * Check whether this type is primitive or not.
     * 
     * @return
     */
    public boolean isPrimitive() {
        return type.getKind().isPrimitive();
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    public boolean isAssignableFrom(Class parent) {
        return isAssignableFrom(elements.getTypeElement(parent.getCanonicalName()));
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    public boolean isAssignableFrom(TypeElement parent) {
        return isAssignableFrom(parent.asType());
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    public boolean isAssignableFrom(TypeMirror parent) {
        return types.isSubtype(types.erasure(type), types.erasure(parent));
    }
}
