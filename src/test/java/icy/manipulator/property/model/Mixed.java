package icy.manipulator.property.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixedModel}.
 */
@Generated("Icy Manipulator")
public abstract class Mixed extends MixedModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Mixed.class.getDeclaredField(name);
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

    /** The final property updater. */
    private static final MethodHandle optionAddressUpdater = updater("optionAddress");

    /** The final property updater. */
    private static final MethodHandle optionCommnetUpdater = updater("optionCommnet");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final int age;

    /** The exposed property. */
    public final String optionAddress;

    /** The exposed property. */
    public final String optionCommnet;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Mixed() {
        this.name = null;
        this.age = 0;
        this.optionAddress = super.optionAddress();
        this.optionCommnet = super.optionCommnet();
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
    @SuppressWarnings("unused")
    private void setName(String value) {
        ((ÅssignableName) this).name(value);
    }

    /**
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getAge() {
        return this.age;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setAge(int value) {
        ((ÅssignableAge) this).age(value);
    }

    /**
     * Retrieve optionAddress property.
     */
    @Override
    public final String optionAddress() {
        return this.optionAddress;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getOptionAddress() {
        return this.optionAddress;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setOptionAddress(String value) {
        ((ÅssignableÅrbitrary) this).optionAddress(value);
    }

    /**
     * Retrieve optionCommnet property.
     */
    @Override
    public final String optionCommnet() {
        return this.optionCommnet;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getOptionCommnet() {
        return this.optionCommnet;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setOptionCommnet(String value) {
        ((ÅssignableÅrbitrary) this).optionCommnet(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link Mixed}.
     */
    public static final class Ìnstantiator<Self extends Mixed & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link Mixed}.
         */
        public final <T extends ÅssignableAge<Self>> T name(String value) {
            return (T) new Åssignable().name(value);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {
        /**
         * The base setter.
         */
        default Next name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAge<Next> {
        /**
         * The base setter.
         */
        default Next age(int value) {
            try {
                ageUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Mixed> {

        /**
         * Property assignment API.
         */
        default Next optionAddress(String value) {
            try {
                optionAddressUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * Property assignment API.
         */
        default Next optionCommnet(String value) {
            try {
                optionCommnetUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableAge {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Mixed implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Age = "age";
        static final String OptionAddress = "optionAddress";
        static final String OptionCommnet = "optionCommnet";
    }
}
