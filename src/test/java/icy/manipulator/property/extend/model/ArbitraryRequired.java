package icy.manipulator.property.extend.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ArbitraryRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class ArbitraryRequired extends ArbitraryRequiredModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = ArbitraryRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle idUpdater = updater("id");

    /** The exposed property. */
    public final long id;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ArbitraryRequired() {
        this.id = 0L;
    }

    /** Return the id property. */
    @Override
    public final long id() {
        return this.id;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final long getId() {
        return this.id;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setId(long value) {
        ((ÅssignableId) this).id(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ArbitraryRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends ArbitraryRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new ArbitraryRequired with the specifiedid property.
         * 
         * @return The next assignable model.
         */
        public final Self id(long LONG) {
            Åssignable o = new Åssignable();
            o.id(LONG);
            return (Self) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableId<Next> {

        /**
         * Assign id property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next id(long value) {
            try {
                idUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends ArbitraryRequired> extends icy.manipulator.property.model.Arbitrary.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableId, icy.manipulator.property.model.Arbitrary.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends ArbitraryRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Id = "id";
    }
}
