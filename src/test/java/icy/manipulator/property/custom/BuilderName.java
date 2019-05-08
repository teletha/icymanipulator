package icy.manipulator.property.custom;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link BuilderNameModel}.
 */
@Generated("Icy Manipulator")
public abstract class BuilderName extends BuilderNameModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = BuilderName.class.getDeclaredField(name);
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
    protected BuilderName() {
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
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     */
    private final void setName(String value) {
        try {
            nameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The singleton builder. */
    public static final Ìnstantiator<?> build = new Ìnstantiator();

    /**
     * Builder namespace for {@link BuilderName}.
     */
    public static final class Ìnstantiator<Self extends BuilderName> {

        /** Create Uninitialized {@link BuilderName}. */
        public final Self name(String value) {
            return (Self) new Åssignable().name(value);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /**
         * The setter.
         */
        default Next name(String value) {
            ((BuilderName) this).setName(value);
            return (Next) this;
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends BuilderName implements ÅssignableName {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
    }
}