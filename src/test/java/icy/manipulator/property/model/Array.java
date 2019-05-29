package icy.manipulator.property.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ArrayModel}.
 */
@Generated("Icy Manipulator")
public abstract class Array extends ArrayModel {

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
            Field field = Array.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle namesUpdater = updater("names");

    /** The final property updater. */
    private static final MethodHandle datesUpdater = updater("dates");

    /** The exposed property. */
    public final String[] names;

    /** The exposed property. */
    public final LocalDate[] dates;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Array() {
        this.names = null;
        this.dates = null;
    }

    /**
     * Return the names property.
     *
     * @return A value of names property.
     */
    @Override
    public final String[] names() {
        return this.names;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of names property.
     */
    @SuppressWarnings("unused")
    private final String[] getNames() {
        return this.names;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of names property to assign.
     */
    private final void setNames(String[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The names property requires non-null value.");
        }
        try {
            namesUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the dates property.
     *
     * @return A value of dates property.
     */
    @Override
    public final LocalDate[] dates() {
        return this.dates;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of dates property.
     */
    @SuppressWarnings("unused")
    private final LocalDate[] getDates() {
        return this.dates;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of dates property to assign.
     */
    private final void setDates(LocalDate[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The dates property requires non-null value.");
        }
        try {
            datesUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Array}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Array & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Array} with the specified names property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDates<Self>> T names(String names) {
            Åssignable o = new Åssignable();
            o.names(names);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNames<Next> {

        /**
         * Assign names property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next names(String... value) {
            ((Array) this).setNames(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDates<Next> {

        /**
         * Assign dates property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next dates(LocalDate... value) {
            ((Array) this).setDates(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Array> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableNames, ÅssignableDates {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Array implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Names = "names";
        static final String Dates = "dates";
    }
}
