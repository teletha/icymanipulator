/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import apty.code.Type;

public interface ClassLike {

    /**
     * Compute the fully qualified type name.
     * 
     * @return
     */
    default String name() {
        throw new UnsupportedOperationException("Implement it!");
    }

    /**
     * Check type equality.
     * 
     * @param type A type which is equals to this type.
     * @return A reulst.
     */
    default boolean is(Class type) {
        return is(Type.of(type));
    }

    /**
     * Check type equality.
     * 
     * @param type A type which is equals to this type.
     * @return A reulst.
     */
    default boolean is(Element type) {
        return is(type.asType());
    }

    /**
     * Check type equality.
     * 
     * @param type A type which is equals to this type.
     * @return A reulst.
     */
    default boolean is(TypeMirror type) {
        return is(Type.of(type));
    }

    /**
     * Check type equality.
     * 
     * @param type A type which is equals to this type.
     * @return A reulst.
     */
    default boolean is(Type type) {
        return name().equals(type.name());
    }

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
    default boolean isAssignableFrom(Class parent) {
        return getAllTypes().anyMatch(e -> e.is(parent));
    }

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
    default boolean isAssignableFrom(TypeMirror parent) {
        return getAllTypes().anyMatch(e -> e.is(parent));
    }

    Type getParent();

    /**
     * Returns the interfaces directly implemented by the class or interface represented by this
     * object.
     * 
     * @return
     */
    Stream<Type> getInterfaces();

    /**
     * List up all types that this type implements or extends. (including itself)
     * 
     * @return
     */
    default Stream<Type> getAllTypes() {
        LinkedHashSet<Type> types = new LinkedHashSet();
        collect((Type) this, types);
        return types.stream();
    }

    /**
     * Collect types recursively.
     * 
     * @param type
     * @param types
     */
    private void collect(Type type, Set<Type> types) {
        if (type == null) {
            return;
        }

        types.add(type);
        collect(type.getParent(), types);
        type.getInterfaces().forEach(interfaceType -> collect(interfaceType, types));
    }

    /**
     * Returns the {@code Type} representing the component type of an array. If this type does not
     * represent an array type this method returns empty.
     *
     * @return The {@code Type} representing the component type of this type if this class is an
     *         array.
     */
    Optional<Type> getComponentType();

    /**
     * Return the root type.
     * 
     * @return
     */
    default Type getRootComponentType() {
        Type current = (Type) this;
        Optional<Type> component = getComponentType();

        while (!component.isEmpty()) {
            current = component.get();
            component = current.getComponentType();
        }
        return current;
    }

    /**
     * Returns an {@link Stream} of {@code Type} objects reflecting all the classes and interfaces
     * declared as members of the class represented by this {@code ClassLike} object. This includes
     * public, protected, default (package) access, and private classes and interfaces declared by
     * the class, but excludes inherited classes and interfaces. This method returns an array of
     * length 0 if the class declares no classes or interfaces as members, or if this {@code Class}
     * object represents a primitive type, an array class, or void.
     *
     * @return A {@link Stream} of {@code Type} objects representing all the declared members of
     *         this class.
     * @return
     */
    Stream<Type> getDeclaredClasses();

    /**
     * Returns the elements of this enum class or empty if this Class object does not represent an
     * enum type.
     * 
     * @return A stream containing the values comprising the enum class represented by this type in
     *         the order they're declared, or empty if this type does not represent an enum type.
     */
    Stream<String> getEnumConstants();

    Stream<MethodLike> getDeclaredMethods();
}