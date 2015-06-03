package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Operatable;

/**
 * {@link Operatable} model for {@link CoupleDefinition}.
 *
 * @version 2015-06-03T16:17:06.416
 */
public abstract class Couple extends CoupleDefinition implements Operatable<Couple> {

    /** The model operator for reuse. */
    public static final Operator<Couple> Operator = new Operator(null);

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
     * Operation Model.
     */
    public static final class Operator<M> extends icy.manipulator.Operator<M, Couple> {

        /** The lens for husband property. */
        private static final Accessor<Couple, Person> HUSBAND = Accessor.of(Couple::husband, Couple::husband);

        /** The lens for wife property. */
        private static final Accessor<Couple, Person> WIFE = Accessor.of(Couple::wife, Couple::wife);

        /**
         * Construct operator.
         */
        public Operator(Accessor<M, Couple> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Person.Operator<Couple> husband() {
            return new Person.Operator(parent.then(HUSBAND));
        }

        /**
         * Property operator.
         */
        public Person.Operator<Couple> wife() {
            return new Person.Operator(parent.then(WIFE));
        }

    }
}
