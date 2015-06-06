package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link BoxModel<V>}.
 *
 * @version 2015-06-06T18:27:00.333
 */
public abstract class Box<V> extends BoxModel<V>implements Manipulatable<Box<V>> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected Box() {
    }

    /**
     * Retrieve value property.
     */
    public V value() {
        return this.value;
    }

    /**
     * Modify value property.
     */
    public Box<V> value(V value) {
        this.value = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final <V> Box<V> with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final <V> Box<V> with(Box<V> base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final <V> Manipulator<Box<V>, V> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy<V> extends Box<V> {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(V value) {
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Box<V> melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Box<V> value(V value) {
            if (this.value == value) {
                return this;
            }
            return new Icy(value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty<V> extends Box<V> {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(Box<V> base) {
            if (base != null) {
                this.value = base.value;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Box<V> ice() {
            return new Icy(value);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel, V> extends icy.manipulator.Manipulator<RootModel, Box<V>> {

        /** The accessor for value property. */
        private static final Accessor VALUE = Accessor.<Box, Object> of(Box::value, Box::value);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, Box<V>> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, V> value() {
            return parent.then(VALUE);
        }

    }
}
