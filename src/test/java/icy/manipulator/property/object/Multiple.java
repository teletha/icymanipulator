package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MultipleModel}.
 */
@Generated("Icy Manipulator")
public class Multiple extends MultipleModel {

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
     * Retrieve stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /** The singleton model builder. */
    public static final ÅssignableName with = new ÅssignableName() {

        @Override
        public <T extends ÅssignableStand> T name(String value) {
            return (T) new Åssignable(value);
        }
    };

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Multiple implements ÅssignableName, ÅssignableStand {
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
        <T extends ÅssignableStand> T name(String value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableStand {
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
