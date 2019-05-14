package icy.manipulator.property.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MultipleModel}.
 */
@Generated("Icy Manipulator")
public abstract class Multiple extends MultipleModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Multiple.class.getDeclaredField(name);
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

    /** The final property updater. */
    private static final MethodHandle ageUpdater = updater("age");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /** The exposed property. */
    public final int age;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Multiple() {
        this.name = null;
        this.stand = null;
        this.age = 0;
    }

    /** Return the name property. */
    @Override
    public final String name() {
        return this.name;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setName(String value) {
        ((ÅssignableName) this).name(value);
    }

    /** Return the stand property. */
    @Override
    public final String stand() {
        return this.stand;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final String getStand() {
        return this.stand;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setStand(String value) {
        ((ÅssignableStand) this).stand(value);
    }

    /** Return the age property. */
    @Override
    public final int age() {
        return this.age;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final int getAge() {
        return this.age;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setAge(int value) {
        ((ÅssignableAge) this).age(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Multiple}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Multiple & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new Multiple with the specifiedname property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableStand<ÅssignableAge<Self>>> T name(String string) {
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
         * @param value A value to assign.
         * @return The next assignable model.
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
    public static interface ÅssignableStand<Next> {

        /**
         * Assign stand property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next stand(String value) {
            try {
                standUpdater.invoke(this, value);
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
         * Assign age property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
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
    public static interface ÅssignableÅrbitrary<Next extends Multiple> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableStand, ÅssignableAge {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Multiple implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
        static final String Age = "age";
    }
}
