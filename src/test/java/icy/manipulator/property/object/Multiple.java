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
    protected Multiple() {
        this.name = null;
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

    /**
     * Create uninitialized {@link Multiple}.
     */
    public static final <T extends NAME> T create() {
        return (T) new Melty();
    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Multiple implements NAME, STAND {

        /**
         * Modify name property.
         */
        @Override
        public final <T extends STAND> T name(String value) {
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
     * Property configuration API.
     */
    public static interface NAME {
        <T extends STAND> T name(String value);
    }

    /**
     * Property configuration API.
     */
    public static interface STAND {
        <T extends Multiple> T stand(String value);
    }
}
