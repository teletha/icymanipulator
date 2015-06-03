package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Operatable;

/**
 * {@link Operatable} model for {@link PersonDefinition}.
 *
 * @version 2015-06-03T15:48:09.237
 */
public abstract class Person implements Operatable<Person> {

    /** The model operator for reuse. */
    public static final Operator<Person> Operator = new Operator(null);

    /** The property holder. */
    protected String name;

    /** The property holder. */
    protected int age;

    /** The property holder. */
    protected Gender gender;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Person() {
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
    public Person name(String value) {
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
    public Person age(int value) {
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
    public Person gender(Gender value) {
        this.gender = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final Person with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final Person with(Person base) {
        return new Melty(base);
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends Person {

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
        public Person melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person name(String value) {
            if (this.name == value) {
                return this;
            }
            return new Icy(value, this.age, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person age(int value) {
            if (this.age == value) {
                return this;
            }
            return new Icy(this.name, value, this.gender);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person gender(Gender value) {
            if (this.gender == value) {
                return this;
            }
            return new Icy(this.name, this.age, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Person {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(Person base) {
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
        public Person ice() {
            return new Icy(name, age, gender);
        }
    }

    /**
     * Operation Model.
     */
    public static final class Operator<M> extends icy.manipulator.Operator<M, Person> {

        /** The lens for name property. */
        private static final Accessor<Person, String> NAME = Accessor.of(Person::name, Person::name);

        /** The lens for age property. */
        private static final Accessor<Person, Integer> AGE = Accessor.of(Person::age, Person::age);

        /** The lens for gender property. */
        private static final Accessor<Person, Gender> GENDER = Accessor.of(Person::gender, Person::gender);

        /**
         * Construct operator.
         */
        public Operator(Accessor<M, Person> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<M, String> name() {
            return parent.then(NAME);
        }

        /**
         * Property operator.
         */
        public Accessor<M, Integer> age() {
            return parent.then(AGE);
        }

        /**
         * Property operator.
         */
        public Accessor<M, Gender> gender() {
            return parent.then(GENDER);
        }

    }
}
