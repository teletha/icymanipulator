package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link GenericVariableModel<Value1, Value2>}.
 *
 * @version 2015-06-06T23:15:34.092
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
    public Box<Value2> value2() {
        return this.value2;
    }

    /**
     * Modify value2 property.
     */
    public GenericVariable<Value1, Value2> value2(Box<Value2> value) {
        this.value2 = value;

        return this;
    }

    /**
     * Retrieve nestedValue2 property.
     */
    public Box<Box<Value2>> nestedValue2() {
        return this.nestedValue2;
    }

    /**
     * Modify nestedValue2 property.
     */
    public GenericVariable<Value1, Value2> nestedValue2(Box<Box<Value2>> value) {
        this.nestedValue2 = value;

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
        private Icy(Value1 value1, Box<Value2> value2, Box<Box<Value2>> nestedValue2) {
            this.value1 = value1;
            this.value2 = value2 == null ? null : value2.ice();
            this.nestedValue2 = nestedValue2 == null ? null : nestedValue2.ice();
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
            return new Icy(value, this.value2, this.nestedValue2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> value2(Box<Value2> value) {
            if (this.value2 == value) {
                return this;
            }
            return new Icy(this.value1, value, this.nestedValue2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> nestedValue2(Box<Box<Value2>> value) {
            if (this.nestedValue2 == value) {
                return this;
            }
            return new Icy(this.value1, this.value2, value);
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
                this.nestedValue2 = base.nestedValue2;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericVariable<Value1, Value2> ice() {
            return new Icy(value1, value2, nestedValue2);
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
                .<GenericVariable, Box> of(GenericVariable::value2, GenericVariable::value2);

        /** The accessor for nestedValue2 property. */
        private static final Accessor NESTEDVALUE2 = Accessor
                .<GenericVariable, Box> of(GenericVariable::nestedValue2, GenericVariable::nestedValue2);

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
        public Box.Manipulator<GenericVariable<Value1, Value2>, Box<Value2>> value2() {
            return new Box.Manipulator(parent.then(VALUE2));
        }

        /**
         * Property operator.
         */
        public Box.Manipulator<GenericVariable<Value1, Value2>, Box<Box<Value2>>> nestedValue2() {
            return new Box.Manipulator(parent.then(NESTEDVALUE2));
        }

    }
}
