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
    private static final MethodHandle zipUpdater = updater("zip");

    /** The exposed property. */
    public final String zip;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixedArbitrary() {
        this.zip = super.zip();
    }

    /**
     * Retrieve zip property.
     */
    @Override
    public final String zip() {
        return this.zip;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getZip() {
        return this.zip;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setZip(String value) {
        ((ÅssignableÅrbitrary) this).zip(value);
    }

    /** The singleton builder. */
    public static final  ÌnstantiatorTyped<?> with = new ÌnstantiatorTyped();

    public static final class ÌnstantiatorTyped<Self extends MixedArbitrary & ÅssignableÅrbitrary<Self>> extends Ìnstantiator<Self> {
    }

    /**
     * Builder namespace for {@link MixedArbitrary}.
     */
    public static class Ìnstantiator<Self> {

        /**
         * Create uninitialized {@link MixedArbitrary}.
         */
        public final Self create() {
            return base();
        }
        protected Self base() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedArbitrary> extends icy.manipulator.property.model.Mixed.ÅssignableÅrbitrary<Next> {

        /**
         * Property assignment API.
         */
        default Next zip(String value) {
            try {
                zipUpdater.invoke(this, value);
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
        static final String Zip = "zip";
    }
}
