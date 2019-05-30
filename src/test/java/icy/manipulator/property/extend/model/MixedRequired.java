package icy.manipulator.property.extend.model;

import icy.manipulator.property.extend.model.MixedRequired;
import icy.manipulator.property.extend.model.MixedRequiredModel;
import icy.manipulator.property.model.Mixed;
import java.lang.String;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixedRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class MixedRequired extends MixedRequiredModel {

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
            Field field = MixedRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle zipUpdater = updater("zip");

    /** The exposed property. */
    public final String zip;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixedRequired() {
        this.zip = null;
    }

    /**
     * Return the zip property.
     *
     * @return A value of zip property.
     */
    @Override
    public final String zip() {
        return this.zip;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of zip property.
     */
    @SuppressWarnings("unused")
    private final String getZip() {
        return this.zip;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of zip property to assign.
     */
    private final void setZip(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The zip property requires non-null value.");
        }
        try {
            zipUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link MixedRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends MixedRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link MixedRequired} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final ÅssignableAge<ÅssignableZip<Self>> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableZip<Next> {

        /**
         * Assign zip property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next zip(String value) {
            ((MixedRequired) this).setZip(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedRequired> extends Mixed.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableZip, Mixed.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixedRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Zip = "zip";
    }
}
