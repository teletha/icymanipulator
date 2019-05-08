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

    /** The final property updater. */
    private static final MethodHandle ageUpdater = updater("age");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /** The exposed property. */
    public final int age;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Multiple() {
        this.name = null;
        this.stand = null;
        this.age = 0;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * 
     */
    abstract Multiple name(String value);

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

    /**
     * Retrieve stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /**
     * 
     */
    abstract Multiple stand(String value);

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
        try {
            standUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * 
     */
    abstract Multiple age(int value);

    /**
     * Provide classic getter API.
     */
    final int getAge() {
        return this.age;
    }

    /**
     * Provide classic setter API.
     */
    final void setAge(int value) {
        try {
            ageUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Builder namespace for {@link Multiple}.
     */
    public static final class with {

        /** Create Uninitialized {@link Multiple}. */
        public static final <Self extends ÅssignableStand<ÅssignableAge<Multiple>>> Self name(String value) {
            return (Self) new Åssignable().name(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Multiple implements ÅssignableName, ÅssignableStand, ÅssignableAge {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable name(String value) {
            setName(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable stand(String value) {
            setStand(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable age(int value) {
            setAge(value);
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
     * Property assignment API.
     */
    public static interface ÅssignableStand<Next> {

        /** Setter */
        Next stand(String value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAge<Next> {

        /** Setter */
        Next age(int value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
        static final String Age = "age";
    }
}
