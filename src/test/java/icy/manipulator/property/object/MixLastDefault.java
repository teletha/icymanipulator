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
    protected MixLastDefault(String name) {
        this.name = name;
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
     * The internal access API for name property setter.
     */
    protected abstract <T extends MixLastDefault & ÅssignableÅrbitrary> T name(String value);

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
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * The internal access API for age property setter.
     */
    protected abstract <T extends MixLastDefault & ÅssignableÅrbitrary> T age(int value);

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
        this.age(value);
    }

    /**
     * Builder namespace for {@link MixLastDefault}.
     */
    public static final class with {

        /** Create Uninitialized {@link MixLastDefault}. */
        public static final <Self extends MixLastDefault> Self name(String value) {
            return (Self) new Åssignable(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixLastDefault implements ÅssignableName<MixLastDefault>, ÅssignableÅrbitrary {

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
        public final MixLastDefault name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return this;
        }

        /**
         * Modify age property.
         */
        @Override
        public final MixLastDefault age(int value) {
            try {
                ageUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
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
    public static interface ÅssignableÅrbitrary {

        /**
         * Property assignment API.
         */
        <T extends MixLastDefault & ÅssignableÅrbitrary> T age(int value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Age = "age";
    }
}
