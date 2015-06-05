package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link UserDefinedDefaultValueDefinition}.
 *
 * @version 2015-06-05T16:06:03.603
 */
public abstract class UserDefinedDefaultValue extends UserDefinedDefaultValueDefinition
        implements Manipulatable<UserDefinedDefaultValue> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected UserDefinedDefaultValue() {
    }

    /**
     * Retrieve value property.
     */
    public String value() {
        return this.value;
    }

    /**
     * Modify value property.
     */
    public UserDefinedDefaultValue value(String value) {
        this.value = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final UserDefinedDefaultValue with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final UserDefinedDefaultValue with(UserDefinedDefaultValue base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<UserDefinedDefaultValue> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends UserDefinedDefaultValue {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(String value) {
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue value(String value) {
            if (this.value == value) {
                return this;
            }
            return new Icy(value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends UserDefinedDefaultValue {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(UserDefinedDefaultValue base) {
            if (base != null) {
                this.value = base.value;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue ice() {
            return new Icy(value);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel>
            extends icy.manipulator.Manipulator<RootModel, UserDefinedDefaultValue> {

        /** The accessor for value property. */
        private static final Accessor VALUE = Accessor
                .<UserDefinedDefaultValue, String> of(UserDefinedDefaultValue::value, UserDefinedDefaultValue::value);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, UserDefinedDefaultValue> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, String> value() {
            return parent.then(VALUE);
        }

    }
}
