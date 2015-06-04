package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link GenericVariableDefinition}.
 *
 * @version 2015-06-03T16:50:56.754
 */
public abstract class GenericVariable<V> extends GenericVariableDefinition<V>implements Manipulatable<GenericVariable> {

    /** The model operator for reuse. */
    private static final Manipulator Manipulator = new Manipulator(null);

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
        return new Melty<V>(base);
    }

    public static final <Param1> Manipulator<GenericVariable<Param1>, Param1> in() {
        return Manipulator;
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
        public GenericVariable melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable value(V value) {
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
     * Operation Model.
     */
    public static final class Manipulator<M, Param1> extends icy.manipulator.Manipulator<M, GenericVariable<Param1>> {

        /** The lens for value property. */
        private static final Accessor<GenericVariable, Object> VALUE = Accessor
                .of(GenericVariable::value, GenericVariable::value);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<M, GenericVariable<Param1>> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<M, Param1> value() {
            return parent.then(VALUE());
        }

        private Accessor<GenericVariable<Param1>, Param1> VALUE() {
            return Accessor.of(GenericVariable::value, GenericVariable::value);
        }
    }
}
