package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link SingleModel}.
 */
@Generated("Icy Manipulator")
public abstract class Single extends SingleModel {

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
     * Provide classic getter API.
     */
    final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     */
    final void setName(String value) {
        try {
            nameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The singleton builder. */
    public static final ßuilder<?> with = new ßuilder();

    /**
     * Builder namespace for {@link Single}.
     */
    public static final class ßuilder<Self extends Single> {

        /** Create Uninitialized {@link Single}. */
        public final Self name(String value) {
            return (Self) new Åssignable().name(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Single implements ÅssignableName {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable name(String value) {
            setName(value);
            return this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /** Setter */
        Next name(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
    }
}
