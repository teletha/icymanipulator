package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixLastDefaultModel}.
 */
@Generated("Icy Manipulator")
public class MixLastDefault extends MixLastDefaultModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = MixLastDefault.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle ageUpdater = updater("age");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final int age;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixLastDefault() {
        this.name = null;
        this.age = super.age();
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * Create uninitialized {@link MixLastDefault}.
     */
    public static final <T extends NAME> T create() {
        return (T) new Melty();
    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends MixLastDefault implements NAME, OPTIONS {

        /**
         * Modify name property.
         */
        @Override
        public final <T extends MixLastDefault & OPTIONS> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify age property.
         */
        @Override
        public final <T extends MixLastDefault & OPTIONS> T age(int value) {
            try {
                ageUpdater.invoke(this, value);
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
        <T extends MixLastDefault & OPTIONS> T name(String value);
    }

    /**
     * Property assignment API.
     */
    public static interface OPTIONS {

        /**
         * Property assignment API.
         */
        <T extends MixLastDefault & OPTIONS> T age(int value);
    }
}
