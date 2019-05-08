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
     * 
     */
    abstract Default name(String value);

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
     * Retrieve stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /**
     * 
     */
    abstract Default stand(String value);

    /**
     * Provide classic getter API.
     */
    final String getStand() {
        return this.stand;
    }

    /**
     * Provide classic setter API.
     */
    final void setStand(String value) {
        try {
            standUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Builder namespace for {@link Default}.
     */
    public static final class with {

        /**
         * Create uninitialized {@link Default}.
         */
        public static final <Self extends Default & ÅssignableÅrbitrary<Self>> Self create() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Default implements ÅssignableÅrbitrary<Åssignable> {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable name(String value) {
            setName(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable stand(String value) {
            setStand(value);
            return this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Default> {

        /**
         * Property assignment API.
         */
        Next name(String value);

        /**
         * Property assignment API.
         */
        Next stand(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
    }
}
