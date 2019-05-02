package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PersonModel}.
 */
public abstract class FinalPerson extends FinalPersonModel implements Manipulatable<FinalPerson> {

    /** The final property updater. */
    private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(FinalPersonModel.class, "name");

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected FinalPerson() {
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
    public FinalPerson name(String value) {
        try {
            nameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }

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
    public FinalPerson age(int value) {
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
    public FinalPerson gender(Gender value) {
        this.gender = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final FinalPerson with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final FinalPerson with(FinalPerson base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<FinalPerson> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends FinalPerson {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(String name, int age, Gender gender) {
            super.name(name);
            this.age = age;
            this.gender = gender;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FinalPerson melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FinalPerson name(String value) {
            if (this.name == value) {
                return this;
            }
            return new Icy(value, this.age, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FinalPerson age(int value) {
            if (this.age == value) {
                return this;
            }
            return new Icy(this.name, value, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FinalPerson gender(Gender value) {
            if (this.gender == value) {
                return this;
            }
            return new Icy(this.name, this.age, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends FinalPerson {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(FinalPerson base) {
            if (base != null) {
                super.name(base.name);
                this.age = base.age;
                this.gender = base.gender;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FinalPerson ice() {
            return new Icy(name, age, gender);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel, FinalPerson> {

        /** The accessor for name property. */
        private static final Accessor NAME = Accessor.<FinalPerson, String> of(FinalPerson::name, FinalPerson::name);

        /** The accessor for age property. */
        private static final Accessor AGE = Accessor.<FinalPerson, Integer> of(FinalPerson::age, FinalPerson::age);

        /** The accessor for gender property. */
        private static final Accessor GENDER = Accessor.<FinalPerson, Gender> of(FinalPerson::gender, FinalPerson::gender);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, FinalPerson> parent) {
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
