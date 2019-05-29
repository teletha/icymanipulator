package icy.manipulator.property.extend.model;

import icy.manipulator.property.model.Mixed;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixedArbitraryModel}.
 */
@Generated("Icy Manipulator")
public abstract class MixedArbitrary extends MixedArbitraryModel {

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
            Field field = MixedArbitrary.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle optionZipUpdater = updater("optionZip");

    /** The exposed property. */
    public final String optionZip;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixedArbitrary() {
        this.optionZip = super.optionZip();
    }

    /**
     * Return the optionZip property.
     *
     * @return A value of optionZip property.
     */
    @Override
    public final String optionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionZip property.
     */
    @SuppressWarnings("unused")
    private final String getOptionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionZip property to assign.
     */
    private final void setOptionZip(String value) {
        if (value == null) {
            value = ((MixedArbitrary) this).åccessToDefaultOptionZip();
        }
        try {
            optionZipUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Provide accesser to super default value.
     *
     * @return A default value.
     */
    private final String åccessToDefaultOptionZip() {
        return super.optionZip();
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link MixedArbitrary}  builder methods.
     */
    public static final class Ìnstantiator<Self extends MixedArbitrary & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link MixedArbitrary} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableAge<Self>> T name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedArbitrary> extends Mixed.ÅssignableÅrbitrary<Next> {

        /**
         * Assign optionZip property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionZip(String value) {
            ((MixedArbitrary) this).setOptionZip(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends Mixed.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixedArbitrary implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String OptionZip = "optionZip";
    }
}
