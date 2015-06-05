package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link CoupleDefinition}.
 *
 * @version 2015-06-05T15:58:02.502
 */
public abstract class Couple extends CoupleDefinition implements Manipulatable<Couple> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected Couple() {
    }

    /**
     * Retrieve husband property.
     */
    public Person husband() {
        return this.husband;
    }

    /**
     * Modify husband property.
     */
    public Couple husband(Person value) {
        this.husband = value;

        return this;
    }

    /**
     * Retrieve wife property.
     */
    public Person wife() {
        return this.wife;
    }

    /**
     * Modify wife property.
     */
    public Couple wife(Person value) {
        this.wife = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final Couple with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final Couple with(Couple base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<Couple> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends Couple {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(Person husband, Person wife) {
            this.husband = husband.ice();
            this.wife = wife.ice();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple husband(Person value) {
            if (this.husband == value) {
                return this;
            }
            return new Icy(value, this.wife);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple wife(Person value) {
            if (this.wife == value) {
                return this;
            }
            return new Icy(this.husband, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Couple {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(Couple base) {
            if (base != null) {
                this.husband = base.husband;
                this.wife = base.wife;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple ice() {
            return new Icy(husband, wife);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel, Couple> {

        /** The accessor for husband property. */
        private static final Accessor HUSBAND = Accessor.<Couple, Person> of(Couple::husband, Couple::husband);

        /** The accessor for wife property. */
        private static final Accessor WIFE = Accessor.<Couple, Person> of(Couple::wife, Couple::wife);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, Couple> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Person.Manipulator<Couple> husband() {
            return new Person.Manipulator(parent.then(HUSBAND));
        }

        /**
         * Property operator.
         */
        public Person.Manipulator<Couple> wife() {
            return new Person.Manipulator(parent.then(WIFE));
        }

    }
}
