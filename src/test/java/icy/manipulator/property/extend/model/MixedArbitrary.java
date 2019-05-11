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
            throw new Error(e);
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
     * Retrieve optionZip property.
     */
    @Override
    public final String optionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getOptionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setOptionZip(String value) {
        ((ÅssignableÅrbitrary) this).optionZip(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link MixedArbitrary}.
     */
    public static final class Ìnstantiator<Self extends MixedArbitrary & ÅssignableÅrbitrary<Self>> {

        /** Create Uninitialized {@link MixedArbitrary}. */
        public final <T extends ÅssignableAge<Self>> T name(String value) {
            return (T) new Åssignable().name(value);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedArbitrary> extends icy.manipulator.property.model.Mixed.ÅssignableÅrbitrary<Next> {

        /**
         * Property assignment API.
         */
        default Next optionZip(String value) {
            try {
                optionZipUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
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
