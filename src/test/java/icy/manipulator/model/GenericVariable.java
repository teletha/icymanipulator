package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link GenericVariableDefinition<V>}.
 *
 * @version 2015-06-05T15:57:49.567
 */
public abstract class GenericVariable<V> extends GenericVariableDefinition<V>
        implements Manipulatable<GenericVariable<V>> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected GenericVariable() {
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
    public GenericVariable<V> value(V value) {
        this.value = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final <V> GenericVariable<V> with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final <V> GenericVariable<V> with(GenericVariable<V> base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final <V> Manipulator<GenericVariable<V>, V> in() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy<V> extends GenericVariable<V> {

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
        public GenericVariable<V> melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<V> value(V value) {
            if (this.value == value) {
                return this;
            }
            return new Icy(value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty<V> extends GenericVariable<V> {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(GenericVariable<V> base) {
            if (base != null) {
                this.value = base.value;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<V> ice() {
            return new Icy(value);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel, V>
            extends icy.manipulator.Manipulator<RootModel, GenericVariable<V>> {

        /** The accessor for value property. */
        private static final Accessor VALUE = Accessor
                .<GenericVariable, Object> of(GenericVariable::value, GenericVariable::value);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, GenericVariable<V>> parent) {
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
