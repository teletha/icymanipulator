package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link GenericVariableDefinition<Value1, Value2>}.
 *
 * @version 2015-06-05T16:36:55.59
 */
public abstract class GenericVariable<Value1, Value2> extends GenericVariableModel<Value1, Value2>
        implements Manipulatable<GenericVariable<Value1, Value2>> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected GenericVariable() {
    }

    /**
     * Retrieve value1 property.
     */
    public Value1 value1() {
        return this.value1;
    }

    /**
     * Modify value1 property.
     */
    public GenericVariable<Value1, Value2> value1(Value1 value) {
        this.value1 = value;

        return this;
    }

    /**
     * Retrieve value2 property.
     */
    public Value2 value2() {
        return this.value2;
    }

    /**
     * Modify value2 property.
     */
    public GenericVariable<Value1, Value2> value2(Value2 value) {
        this.value2 = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final <Value1, Value2> GenericVariable<Value1, Value2> with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final <Value1, Value2> GenericVariable<Value1, Value2> with(GenericVariable<Value1, Value2> base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final <Value1, Value2> Manipulator<GenericVariable<Value1, Value2>, Value1, Value2> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy<Value1, Value2> extends GenericVariable<Value1, Value2> {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(Value1 value1, Value2 value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> value1(Value1 value) {
            if (this.value1 == value) {
                return this;
            }
            return new Icy(value, this.value2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> value2(Value2 value) {
            if (this.value2 == value) {
                return this;
            }
            return new Icy(this.value1, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty<Value1, Value2> extends GenericVariable<Value1, Value2> {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(GenericVariable<Value1, Value2> base) {
            if (base != null) {
                this.value1 = base.value1;
                this.value2 = base.value2;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> ice() {
            return new Icy(value1, value2);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel, Value1, Value2>
            extends icy.manipulator.Manipulator<RootModel, GenericVariable<Value1, Value2>> {

        /** The accessor for value1 property. */
        private static final Accessor VALUE1 = Accessor
                .<GenericVariable, Object> of(GenericVariable::value1, GenericVariable::value1);

        /** The accessor for value2 property. */
        private static final Accessor VALUE2 = Accessor
                .<GenericVariable, Object> of(GenericVariable::value2, GenericVariable::value2);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, GenericVariable<Value1, Value2>> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Value1> value1() {
            return parent.then(VALUE1);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Value2> value2() {
            return parent.then(VALUE2);
        }

    }
}
