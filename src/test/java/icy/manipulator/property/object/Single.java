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
    protected Single(String name) {
        this.name = name;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /** The singleton model builder. */
    public static final ÅssignableName with = new ÅssignableName() {

        @Override
        public <T extends Single> T name(String value) {
            return (T) new Åssignable(value);
        }
    };

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Single implements ÅssignableName {
        private Åssignable(String name) {
            super(name);
        }

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
     * Property assignment API.
     */
    public static interface ÅssignableName {
        <T extends Single> T name(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
    }
}
