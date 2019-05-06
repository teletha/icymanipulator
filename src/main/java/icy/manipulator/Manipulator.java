/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

/**
 * Model {@link Accessor} as operator.
 */
public abstract class Manipulator<M, V> implements Accessor<M, V> {

    /** The parent accessor. */
    protected Accessor<M, V> parent;

    /**
     * Create base accessor.
     * 
     * @param parent A parent accessor.
     */
    protected Manipulator(Accessor<M, V> parent) {
        this.parent = parent == null ? Accessor.Φ : parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final V get(M model) {
        return parent.get(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final M set(M model, V property) {
        return parent.set(model, property);
    }

    /**
     * Create special property updater.
     * 
     * @param type A target type.
     * @param name A target property name.
     * @return A special property updater.
     */
    public static final MethodHandle updater(Class type, String name) {
        try {
            Field field = type.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
}
