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
    public static abstract class Customizer<T> implements Consumer<T>, Supplier<T> {

        private T latest;

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(T value) {
            latest = value;
        }

        /**
         * Get value by getter.
         * 
         * @return
         */
        public T $ByGetter() {
            return get();
        }

        /**
         * Get value by setter.
         * 
         * @return
         */
        public T $BySetter() {
            return latest;
        }

        /**
         * Get value as {@link Supplier}.
         * 
         * @return
         */
        public Supplier<T> $ByGetterAsSupplier() {
            return this;
        }
    }

    /**
     * Return name.
     * 
     * @return A name.
     */
    @Icy.Property(custom = SubCustomizer.class)
    public abstract String value();

    /**
     * 
     */
    public static abstract class SubCustomizer extends Customizer<String> {

        /**
         * Get value on sub.
         * 
         * @return
         */
        public String $FromSub() {
            return get();
        }
    }
}
