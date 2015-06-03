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

import icy.manipulator.Accessor;
import icy.manipulator.Operatable;

public abstract class Couple implements Operatable<Couple> {

    /** The model operator. */
    public static final Operator<Couple> Operator = new Operator(null);

    /** The current model. */
    CoupleModel model;

    /**
     * HIDDEN CONSTRUCTOR
     */
    private Couple() {
    }

    /**
     * Retrieve husband property.
     */
    public Person husband() {
        return model.husband;
    }

    /**
     * Apply husband property.
     */
    public Couple husband(Person value) {
        if (model.husband == value) {
            return this;
        }
        return with(this).husband(value).ice();
    }

    /**
     * Retrieve wife property.
     */
    public Person wife() {
        return model.wife;
    }

    /**
     * Apply wife property.
     */
    public Couple wife(Person value) {
        if (model.wife == value) {
            return this;
        }
        return with(this).wife(value).ice();
    }

    /**
     * Create model builder without base model.
     */
    public static final Couple with() {
        return with(null);
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
         * HIDEEN CONSTRUCTOR
         */
        private Icy(Couple base) {
            model = new CoupleModel();

            if (base != null) {
                model.husband = base.husband();
                model.wife = base.wife();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple melt() {
            return new Melty(this);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Couple {

        /**
         * HIDEEN CONSTRUCTOR
         */
        private Melty(Couple base) {
            model = new CoupleModel();

            if (base != null) {
                model.husband = base.husband();
                model.wife = base.wife();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple husband(Person husband) {
            model.husband = husband;

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple wife(Person wife) {
            model.wife = wife;

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Couple ice() {
            return new Icy(this);
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
