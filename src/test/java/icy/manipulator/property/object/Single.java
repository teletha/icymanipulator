package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link SingleModel}.
 */
@Generated("Icy Manipulator")
public class Single extends SingleModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Single.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The exposed property. */
    public final String name;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Single() {
        this.name = null;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Create uninitialized {@link Single}.
     */
    public static final <T extends NAME> T create() {
        return (T) new Melty();
    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends Single implements NAME {

        /**
         * Modify name property.
         */
        @Override
        public final <T extends Single> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
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
        <T extends Single> T name(String value);
    }
}
