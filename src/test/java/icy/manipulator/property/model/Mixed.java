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
     * Deceive complier that the specified checked exception is unchecked exception.
     *
     * @param <T> A dummy type for {@link RuntimeException}.
     * @param throwable Any error.
     * @return A runtime error.
     * @throws T Dummy error to deceive compiler.
     */
    private static final <T extends Throwable> T quiet(Throwable throwable) throws T {
        throw (T) throwable;
    }

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
            throw quiet(e);
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
     * Return the name property.
     *
     * @return A value of name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of name property.
     */
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of name property to assign.
     */
    @SuppressWarnings("unused")
    private void setName(String value) {
        ((ÅssignableName) this).name(value);
    }

    /**
     * Return the age property.
     *
     * @return A value of age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of age property.
     */
    @SuppressWarnings("unused")
    private final int getAge() {
        return this.age;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of age property to assign.
     */
    @SuppressWarnings("unused")
    private void setAge(int value) {
        ((ÅssignableAge) this).age(value);
    }

    /**
     * Return the optionAddress property.
     *
     * @return A value of optionAddress property.
     */
    @Override
    public final String optionAddress() {
        return this.optionAddress;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionAddress property.
     */
    @SuppressWarnings("unused")
    private final String getOptionAddress() {
        return this.optionAddress;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionAddress property to assign.
     */
    @SuppressWarnings("unused")
    private void setOptionAddress(String value) {
        ((ÅssignableÅrbitrary) this).optionAddress(value);
    }

    /**
     * Provide accesser to super default value.
     *
     * @return A default value.
     */
    private final String åccessToDefaultOptionAddress() {
        return super.optionAddress();
    }

    /**
     * Return the optionCommnet property.
     *
     * @return A value of optionCommnet property.
     */
    @Override
    public final String optionCommnet() {
        return this.optionCommnet;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionCommnet property.
     */
    @SuppressWarnings("unused")
    private final String getOptionCommnet() {
        return this.optionCommnet;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionCommnet property to assign.
     */
    @SuppressWarnings("unused")
    private void setOptionCommnet(String value) {
        ((ÅssignableÅrbitrary) this).optionCommnet(value);
    }

    /**
     * Provide accesser to super default value.
     *
     * @return A default value.
     */
    private final String åccessToDefaultOptionCommnet() {
        return super.optionCommnet();
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Mixed}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Mixed & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Mixed} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableAge<Self>> T name(String string) {
            Åssignable o = new Åssignable();
            o.name(string);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /**
         * Assign name property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next name(String value) {
            if (value == null) {
                throw new IllegalArgumentException("The name property requires non-null value.");
            }
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAge<Next> {

        /**
         * Assign age property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next age(int value) {
            try {
                ageUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Mixed> {

        /**
         * Assign optionAddress property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionAddress(String value) {
            if (value == null) {
                value = ((Mixed) this).åccessToDefaultOptionAddress();
            }
            try {
                optionAddressUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
            return (Next) this;
        }

        /**
         * Assign optionCommnet property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionCommnet(String value) {
            if (value == null) {
                value = ((Mixed) this).åccessToDefaultOptionCommnet();
            }
            try {
                optionCommnetUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
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
