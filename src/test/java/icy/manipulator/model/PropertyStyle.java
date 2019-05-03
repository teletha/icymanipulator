package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PersonModel}.
 */
public abstract class PropertyStyle extends PersonModel implements Manipulatable<PropertyStyle> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected PropertyStyle() {
    }

    /**
     * Retrieve name property.
     */
    public String name() {
        return this.name;
    }

    /**
     * Modify name property.
     */
    public PropertyStyle name(String value) {
        this.name = value;

        return this;
    }

    /**
     * Retrieve age property.
     */
    public int age() {
        return this.age;
    }

    /**
     * Modify age property.
     */
    public PropertyStyle age(int value) {
        this.age = value;

        return this;
    }

    /**
     * Retrieve gender property.
     */
    public Gender gender() {
        return this.gender;
    }

    /**
     * Modify gender property.
     */
    public PropertyStyle gender(Gender value) {
        this.gender = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final PropertyStyle with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final PropertyStyle with(PropertyStyle base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<PropertyStyle> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends PropertyStyle {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PropertyStyle melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PropertyStyle name(String value) {
            if (this.name == value) {
                return this;
            }
            return new Icy(value, this.age, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PropertyStyle age(int value) {
            if (this.age == value) {
                return this;
            }
            return new Icy(this.name, value, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PropertyStyle gender(Gender value) {
            if (this.gender == value) {
                return this;
            }
            return new Icy(this.name, this.age, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends PropertyStyle {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(PropertyStyle base) {
            if (base != null) {
                this.name = base.name;
                this.age = base.age;
                this.gender = base.gender;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PropertyStyle ice() {
            return new Icy(name, age, gender);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel, PropertyStyle> {

        /** The accessor for name property. */
        private static final Accessor NAME = Accessor.<PropertyStyle, String> of(PropertyStyle::name, PropertyStyle::name);

        /** The accessor for age property. */
        private static final Accessor AGE = Accessor.<PropertyStyle, Integer> of(PropertyStyle::age, PropertyStyle::age);

        /** The accessor for gender property. */
        private static final Accessor GENDER = Accessor.<PropertyStyle, Gender> of(PropertyStyle::gender, PropertyStyle::gender);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, PropertyStyle> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, String> name() {
            return parent.then(NAME);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Integer> age() {
            return parent.then(AGE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Gender> gender() {
            return parent.then(GENDER);
        }

    }
}
