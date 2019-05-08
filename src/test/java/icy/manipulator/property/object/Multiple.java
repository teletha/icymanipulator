package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MultipleModel}.
 */
@Generated("Icy Manipulator")
public abstract class Multiple extends MultipleModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Multiple.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle standUpdater = updater("stand");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Multiple(String name) {
        this.name = name;
        this.stand = null;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * The internal access API for name property setter.
     */
    protected abstract <T extends ÅssignableStand> T name(String value);

    /**
     * Provide classic getter API.
     */
    final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     */
    final void setName(String value) {
        this.name(value);
    }

    /**
     * Retrieve stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /**
     * The internal access API for stand property setter.
     */
    protected abstract <T extends Multiple> T stand(String value);

    /**
     * Provide classic getter API.
     */
    final String getStand() {
        return this.stand;
    }

    /**
     * Provide classic setter API.
     */
    final void setStand(String value) {
        this.stand(value);
    }

    /** The singleton model builder. */
    public static final ÅssignableName with = new ÅssignableName() {

        /** Create Uninitialized {@link Multiple}. */
        @Override
        public <T extends ÅssignableStand> T name(String value) {
            return (T) new Åssignable(value);
        }
    };

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Multiple implements ÅssignableName, ÅssignableStand {

        /**
         * Initialize by first property.
         */
        private Åssignable(String name) {
            super(name);
        }

        /**
         * Modify name property.
         */
        @Override
        public final <T extends ÅssignableStand> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify stand property.
         */
        @Override
        public final <T extends Multiple> T stand(String value) {
            try {
                standUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName {

        /** Setter */
        <T extends ÅssignableStand> T name(String value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableStand {

        /** Setter */
        <T extends Multiple> T stand(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
    }
}
