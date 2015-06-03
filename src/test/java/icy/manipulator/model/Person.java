/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import icy.manipulator.Lens;
import icy.manipulator.ModelOperator;
import icy.manipulator.Operatable;

public abstract class Person implements Operatable<Person> {

    /** The current model. */
    PersonModel model;

    /**
     * HIDDEN CONSTRUCTOR
     */
    private Person() {
    }

    /**
     * Retrieve name property.
     */
    public String name() {
        return model.name;
    }

    /**
     * Apply name property.
     */
    public Person name(String value) {
        if (model.name == value) {
            return this;
        }
        return with(this).name(value).ice();
    }

    /**
     * Retrieve age property.
     */
    public int age() {
        return model.age;
    }

    /**
     * Apply age property.
     */
    public Person age(int value) {
        if (model.age == value) {
            return this;
        }
        return with(this).age(value).ice();
    }

    /**
     * Retrieve gender property.
     */
    public Gender gender() {
        return model.gender;
    }

    /**
     * Apply gender property.
     */
    public Person gender(Gender value) {
        if (model.gender == value) {
            return this;
        }
        return with(this).gender(value).ice();
    }

    /**
     * Create model builder without base model.
     */
    public static final Person with() {
        return with(null);
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
         * HIDEEN CONSTRUCTOR
         */
        private Icy(Person base) {
            model = new PersonModel();

            if (base != null) {
                model.name = base.name();
                model.age = base.age();
                model.gender = base.gender();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person melt() {
            return new Melty(this);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Person {

        /**
         * HIDEEN CONSTRUCTOR
         */
        private Melty(Person base) {
            model = new PersonModel();

            if (base != null) {
                model.name = base.name();
                model.age = base.age();
                model.gender = base.gender();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person name(String name) {
            model.name = name;

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person age(int age) {
            model.age = age;

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person gender(Gender gender) {
            model.gender = gender;

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Person ice() {
            return new Icy(this);
        }
    }

    /**
     * Operation Model.
     */
    public static final class Operator<M> extends ModelOperator<M, Person> {

        /** The lens for name property. */
        private static final Lens<Person, String> NAME = Lens.of(Person::name, Person::name);

        /** The lens for age property. */
        private static final Lens<Person, Integer> AGE = Lens.of(Person::age, Person::age);

        /** The lens for gender property. */
        private static final Lens<Person, Gender> GENDER = Lens.of(Person::gender, Person::gender);

        /**
         * Construct operator.
         */
        public Operator(Lens<M, Person> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Lens<M, String> name() {
            return parent.then(NAME);
        }

        /**
         * Property operator.
         */
        public Lens<M, Integer> age() {
            return parent.then(AGE);
        }

        /**
         * Property operator.
         */
        public Lens<M, Gender> gender() {
            return parent.then(GENDER);
        }

    }
}
