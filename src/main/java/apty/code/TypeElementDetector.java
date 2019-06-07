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

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import apty.Apty;
import apty.ClassLike;
import apty.MethodLike;

/**
 * 
 */
public class TypeElementDetector implements ClassLike {

    /** The target type. */
    private final TypeElement type;

    /**
     * Type detector.
     * 
     * @param type
     */
    public TypeElementDetector(TypeElement type) {
        this.type = type;
    }

    /**
     * Check whether this type is annotation or not.
     * 
     * @return
     */
    @Override
    public boolean isAnnotation() {
        return type.getKind() == ElementKind.ANNOTATION_TYPE;
    }

    /**
     * Check whether this type is array or not.
     * 
     * @return
     */
    @Override
    public boolean isArray() {
        return type.asType().getKind() == TypeKind.ARRAY;
    }

    /**
     * Check whether this type is enum or not.
     * 
     * @return
     */
    @Override
    public boolean isEnum() {
        return type.getKind() == ElementKind.ENUM;
    }

    /**
     * Check whether this type is interface or not.
     * 
     * @return
     */
    @Override
    public boolean isInterface() {
        return type.getKind() == ElementKind.INTERFACE;
    }

    /**
     * Check whether this type is primitive or not.
     * 
     * @return
     */
    @Override
    public boolean isPrimitive() {
        return type.asType().getKind().isPrimitive();
    }

    /**
     * Check whether this type is subtype of the specified type.
     * 
     * @param parent A parent type to check.
     * @return
     */
    @Override
    public boolean isAssignableFrom(TypeMirror parent) {
        return Apty.isSubType(type.asType(), parent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getParent() {
        TypeMirror superclass = type.getSuperclass();

        return superclass.getKind() == TypeKind.NONE ? null : Type.of(superclass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Type> getInterfaces() {
        return type.getInterfaces().stream().map(Type::of);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Type> getDeclaredClasses() {
        return type.getEnclosedElements().stream().filter(this::isClass).map(e -> Type.of((TypeElement) e));
    }

    /**
     * Detect type.
     * 
     * @param e
     * @return
     */
    private boolean isClass(Element e) {
        switch (e.getKind()) {
        case ANNOTATION_TYPE:
        case CLASS:
        case INTERFACE:
        case ENUM:
            return true;

        default:
            return false;
        }
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
        if (type == null) {
            return Stream.empty();
        }

        return type.getEnclosedElements()
                .stream()
                .filter(e -> e.getKind() == ElementKind.ENUM_CONSTANT)
                .map(e -> e.getSimpleName().toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<MethodLike> getMethods() {
        return type.getEnclosedElements()
                .stream()
                .filter(e -> e.getKind() == ElementKind.METHOD && e.getModifiers().contains(Modifier.PUBLIC))
                .map(e -> new MethodLike((ExecutableElement) e));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<MethodLike> getDeclaredMethods() {
        return type.getEnclosedElements()
                .stream()
                .filter(e -> e.getKind() == ElementKind.METHOD)
                .map(e -> new MethodLike((ExecutableElement) e));
    }
}