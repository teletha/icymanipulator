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

/**
 * Model {@link Accessor} as operator.
 * 
 * @version 2015/06/03 14:06:02
 */
public abstract class Operator<M, V> implements Accessor<M, V> {

    /** The parent accessor. */
    protected Accessor<M, V> parent;

    /**
     * Create base accessor.
     * 
     * @param parent A parent accessor.
     */
    protected Operator(Accessor<M, V> parent) {
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
}
