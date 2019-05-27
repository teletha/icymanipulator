package icy.manipulator.property.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.processing.Generated;

/**
 * Generated model for {@link WildcardModel}.
 */
@Generated("Icy Manipulator")
public abstract class Wildcard extends WildcardModel {

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
    private static final MethodHandle updater(String name) {
        try {
            Field field = Wildcard.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle typeUpdater = updater("type");

    /** The exposed property. */
    public final Class<List> type;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Wildcard() {
        this.type = null;
    }

    /**
     * Return the type property.
     *
     * @return A value of type property.
     */
    @Override
    public final Class<List> type() {
        return this.type;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of type property.
     */
    @SuppressWarnings("unused")
    private final Class<List> getType() {
        return this.type;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of type property to assign.
     */
    private final void setType(Class<List> value) {
        if (value == null) {
            throw new IllegalArgumentException("The type property requires non-null value.");
        }
        try {
            typeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Wildcard} builder methods.
     */
    public static final class Ìnstantiator<Self extends Wildcard & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Wildcard} with the specified type property.
         * 
         * @return The next assignable model.
         */
        public final Self type(Class<List> CLASS) {
            Åssignable o = new Åssignable();
            o.type(CLASS);
            return (Self) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableType<Next> {

        /**
         * Assign type property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next type(Class<List> value) {
            ((Wildcard) this).setType(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Wildcard> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableType {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Wildcard implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Type = "type";
    }
}
