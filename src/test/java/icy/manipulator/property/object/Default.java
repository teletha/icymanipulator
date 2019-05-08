package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link DefaultModel}.
 */
@Generated("Icy Manipulator")
public abstract class Default extends DefaultModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Default.class.getDeclaredField(name);
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

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Default() {
        this.name = super.name();
        this.stand = super.stand();
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
    private final void setName(String value) {
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
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getStand() {
        return this.stand;
    }

    /**
     * Provide classic setter API.
     */
    private final void setStand(String value) {
        try {
            standUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The singleton builder. */
    public static final Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link Default}.
     */
    public static final class Ìnstantiator<Self extends Default & ÅssignableÅrbitrary<Self>> {

        /**
         * Create uninitialized {@link Default}.
         */
        public final Self create() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Default> {

        /**
         * Property assignment API.
         */
        default Next name(String value) {
            ((Default) this).setName(value);
            return (Next) this;
        }

        /**
         * Property assignment API.
         */
        default Next stand(String value) {
            ((Default) this).setStand(value);
            return (Next) this;
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Default implements ÅssignableÅrbitrary<Åssignable> {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
    }
}
