package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Operatable;

/**
 * {@link Operatable} model for {@link GenericVariableDefinition}.
 *
 * @version 2015-06-03T16:50:56.754
 */
public abstract class GenericVariable<V> extends GenericVariableDefinition<V>implements Operatable<GenericVariable> {

    /** The model operator for reuse. */
    public static final Operator<GenericVariable> Operator = new Operator(null);

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

    public static final <V> Operator<GenericVariable<V>> operator() {
        return (Operator<GenericVariable<V>>) (Object) Operator;
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
    public static final class Operator<M> extends icy.manipulator.Operator<M, GenericVariable> {

        /** The lens for value property. */
        private static final Accessor<GenericVariable, Object> VALUE = Accessor
                .of(GenericVariable::value, GenericVariable::value);

        /**
         * Construct operator.
         */
        public Operator(Accessor<M, GenericVariable> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public <V> Accessor<M, V> value() {
            return parent.then((Accessor<GenericVariable, V>) VALUE);
        }

    }
}
