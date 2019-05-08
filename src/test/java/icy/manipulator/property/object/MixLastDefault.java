package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixLastDefaultModel}.
 */
@Generated("Icy Manipulator")
public abstract class MixLastDefault extends MixLastDefaultModel {

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
     * 
     */
    abstract MixLastDefault name(String value);

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
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * 
     */
    abstract MixLastDefault age(int value);

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
     * Builder namespace for {@link MixLastDefault}.
     */
    public static final class with {

        /** Create Uninitialized {@link MixLastDefault}. */
        public static final <Self extends MixLastDefault> Self name(String value) {
            return (Self) new Åssignable().name(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixLastDefault implements ÅssignableName, ÅssignableÅrbitrary<Åssignable> {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable name(String value) {
            setName(value);
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
    public static interface ÅssignableÅrbitrary<Next extends MixLastDefault> {

        /**
         * Property assignment API.
         */
        Next age(int value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Age = "age";
    }
}
