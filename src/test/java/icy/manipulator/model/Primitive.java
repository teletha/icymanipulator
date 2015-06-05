package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PrimitiveModel}.
 *
 * @version 2015-06-05T16:51:01.31
 */
public abstract class Primitive extends PrimitiveModel implements Manipulatable<Primitive> {

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected Primitive() {
    }

    /**
     * Retrieve intValue property.
     */
    public int intValue() {
        return this.intValue;
    }

    /**
     * Modify intValue property.
     */
    public Primitive intValue(int value) {
        this.intValue = value;

        return this;
    }

    /**
     * Retrieve longValue property.
     */
    public long longValue() {
        return this.longValue;
    }

    /**
     * Modify longValue property.
     */
    public Primitive longValue(long value) {
        this.longValue = value;

        return this;
    }

    /**
     * Retrieve floatValue property.
     */
    public float floatValue() {
        return this.floatValue;
    }

    /**
     * Modify floatValue property.
     */
    public Primitive floatValue(float value) {
        this.floatValue = value;

        return this;
    }

    /**
     * Retrieve doubleValue property.
     */
    public double doubleValue() {
        return this.doubleValue;
    }

    /**
     * Modify doubleValue property.
     */
    public Primitive doubleValue(double value) {
        this.doubleValue = value;

        return this;
    }

    /**
     * Retrieve booleanValue property.
     */
    public boolean booleanValue() {
        return this.booleanValue;
    }

    /**
     * Modify booleanValue property.
     */
    public Primitive booleanValue(boolean value) {
        this.booleanValue = value;

        return this;
    }

    /**
     * Retrieve charValue property.
     */
    public char charValue() {
        return this.charValue;
    }

    /**
     * Modify charValue property.
     */
    public Primitive charValue(char value) {
        this.charValue = value;

        return this;
    }

    /**
     * Retrieve byteValue property.
     */
    public byte byteValue() {
        return this.byteValue;
    }

    /**
     * Modify byteValue property.
     */
    public Primitive byteValue(byte value) {
        this.byteValue = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final Primitive with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final Primitive with(Primitive base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<Primitive> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends Primitive {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(int intValue, long longValue, float floatValue, double doubleValue, boolean booleanValue, char charValue, byte byteValue) {
            this.intValue = intValue;
            this.longValue = longValue;
            this.floatValue = floatValue;
            this.doubleValue = doubleValue;
            this.booleanValue = booleanValue;
            this.charValue = charValue;
            this.byteValue = byteValue;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive intValue(int value) {
            if (this.intValue == value) {
                return this;
            }
            return new Icy(value, this.longValue, this.floatValue, this.doubleValue, this.booleanValue, this.charValue, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive longValue(long value) {
            if (this.longValue == value) {
                return this;
            }
            return new Icy(this.intValue, value, this.floatValue, this.doubleValue, this.booleanValue, this.charValue, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive floatValue(float value) {
            if (this.floatValue == value) {
                return this;
            }
            return new Icy(this.intValue, this.longValue, value, this.doubleValue, this.booleanValue, this.charValue, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive doubleValue(double value) {
            if (this.doubleValue == value) {
                return this;
            }
            return new Icy(this.intValue, this.longValue, this.floatValue, value, this.booleanValue, this.charValue, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive booleanValue(boolean value) {
            if (this.booleanValue == value) {
                return this;
            }
            return new Icy(this.intValue, this.longValue, this.floatValue, this.doubleValue, value, this.charValue, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive charValue(char value) {
            if (this.charValue == value) {
                return this;
            }
            return new Icy(this.intValue, this.longValue, this.floatValue, this.doubleValue, this.booleanValue, value, this.byteValue);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive byteValue(byte value) {
            if (this.byteValue == value) {
                return this;
            }
            return new Icy(this.intValue, this.longValue, this.floatValue, this.doubleValue, this.booleanValue, this.charValue, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Primitive {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(Primitive base) {
            if (base != null) {
                this.intValue = base.intValue;
                this.longValue = base.longValue;
                this.floatValue = base.floatValue;
                this.doubleValue = base.doubleValue;
                this.booleanValue = base.booleanValue;
                this.charValue = base.charValue;
                this.byteValue = base.byteValue;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Primitive ice() {
            return new Icy(intValue, longValue, floatValue, doubleValue, booleanValue, charValue, byteValue);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel, Primitive> {

        /** The accessor for intValue property. */
        private static final Accessor INTVALUE = Accessor
                .<Primitive, Integer> of(Primitive::intValue, Primitive::intValue);

        /** The accessor for longValue property. */
        private static final Accessor LONGVALUE = Accessor
                .<Primitive, Long> of(Primitive::longValue, Primitive::longValue);

        /** The accessor for floatValue property. */
        private static final Accessor FLOATVALUE = Accessor
                .<Primitive, Float> of(Primitive::floatValue, Primitive::floatValue);

        /** The accessor for doubleValue property. */
        private static final Accessor DOUBLEVALUE = Accessor
                .<Primitive, Double> of(Primitive::doubleValue, Primitive::doubleValue);

        /** The accessor for booleanValue property. */
        private static final Accessor BOOLEANVALUE = Accessor
                .<Primitive, Boolean> of(Primitive::booleanValue, Primitive::booleanValue);

        /** The accessor for charValue property. */
        private static final Accessor CHARVALUE = Accessor
                .<Primitive, Character> of(Primitive::charValue, Primitive::charValue);

        /** The accessor for byteValue property. */
        private static final Accessor BYTEVALUE = Accessor
                .<Primitive, Byte> of(Primitive::byteValue, Primitive::byteValue);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, Primitive> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Integer> intValue() {
            return parent.then(INTVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Long> longValue() {
            return parent.then(LONGVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Float> floatValue() {
            return parent.then(FLOATVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Double> doubleValue() {
            return parent.then(DOUBLEVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Boolean> booleanValue() {
            return parent.then(BOOLEANVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Character> charValue() {
            return parent.then(CHARVALUE);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Byte> byteValue() {
            return parent.then(BYTEVALUE);
        }

    }
}
