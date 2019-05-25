/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.customize.model;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import icy.manipulator.Icy;

@Icy
public abstract class CustomizableModel {

    /**
     * Return name.
     * 
     * @return A name.
     */
    @Icy.Property(custom = Customizer.class)
    public abstract String name();

    /**
     * 
     */
    public static class Customizer<T> implements Function<Supplier<T>, Consumer<T>> {

        private Supplier<T> getter;

        private T latest;

        /**
         * {@inheritDoc}
         */
        @Override
        public Consumer<T> apply(Supplier<T> getter) {
            this.getter = getter;
            return value -> latest = value;
        }

        /**
         * Get value by getter.
         * 
         * @return
         */
        public T $ByGetter() {
            return getter.get();
        }
    }
}
