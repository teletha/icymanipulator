package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PersonModel}.
 */
public abstract class IntercepteSetter extends IntercepteSetterModel implements Manipulatable<IntercepteSetter> {

    /** The final property updater. */
    private static final java.lang.invoke.MethodHandle textUpdater = icy.manipulator.Manipulator
            .updater(IntercepteSetterModel.class, "text");

    /** The final property updater. */
    private static final java.lang.invoke.MethodHandle upperUpdater = icy.manipulator.Manipulator
            .updater(IntercepteSetterModel.class, "upper");

    /** The final property updater. */
    private static final java.lang.invoke.MethodHandle sizeUpdater = icy.manipulator.Manipulator
            .updater(IntercepteSetterModel.class, "size");

    /** The model manipulator for reuse. */
    private static final Manipulator MANIPULATOR = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected IntercepteSetter() {
    }

    /**
     * Retrieve text property.
     */
    public String text() {
        return this.text;
    }

    /**
     * Modify text property.
     */
    public IntercepteSetter text(String value) {
        try {
            textUpdater.invoke(this, value);
            super.text(value, this);
        } catch (Throwable e) {
            throw new Error(e);
        }

        return this;
    }

    /**
     * Retrieve upper property.
     */
    public String upper() {
        return this.upper;
    }

    /**
     * Modify upper property.
     */
    public IntercepteSetter upper(String value) {
        try {
            upperUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }

        return this;
    }

    /**
     * Retrieve size property.
     */
    public int size() {
        return this.size;
    }

    /**
     * Modify size property.
     */
    public IntercepteSetter size(int value) {
        try {
            sizeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final IntercepteSetter with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final IntercepteSetter with(IntercepteSetter base) {
        return new Melty(base);
    }

    /**
     * Create model manipulator.
     */
    public static final Manipulator<IntercepteSetter> manipulate() {
        return MANIPULATOR;
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends IntercepteSetter {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(String text, String upper, int size) {
            super.text(text);
            super.upper(upper);
            super.size(size);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IntercepteSetter melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IntercepteSetter text(String value) {
            if (this.text == value) {
                return this;
            }
            return new Icy(value, this.upper, this.size);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IntercepteSetter upper(String value) {
            if (this.upper == value) {
                return this;
            }
            return new Icy(this.text, value, this.size);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IntercepteSetter size(int value) {
            if (this.size == value) {
                return this;
            }
            return new Icy(this.text, this.upper, value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends IntercepteSetter {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(IntercepteSetter base) {
            if (base != null) {
                super.text(base.text);
                super.upper(base.upper);
                super.size(base.size);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IntercepteSetter ice() {
            return new Icy(text, upper, size);
        }
    }

    /**
     * Model Manipulator.
     */
    public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel, IntercepteSetter> {

        /** The accessor for name property. */
        private static final Accessor TEXT = Accessor.<IntercepteSetter, String> of(IntercepteSetter::text, IntercepteSetter::text);

        /** The accessor for age property. */
        private static final Accessor UPPER = Accessor.<IntercepteSetter, String> of(IntercepteSetter::upper, IntercepteSetter::upper);

        /** The accessor for gender property. */
        private static final Accessor SIZE = Accessor.<IntercepteSetter, Integer> of(IntercepteSetter::size, IntercepteSetter::size);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<RootModel, IntercepteSetter> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, String> text() {
            return parent.then(TEXT);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, String> upper() {
            return parent.then(UPPER);
        }

        /**
         * Property operator.
         */
        public Accessor<RootModel, Integer> size() {
            return parent.then(SIZE);
        }

    }
}
