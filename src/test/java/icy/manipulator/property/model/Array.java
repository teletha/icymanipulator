package icy.manipulator.property.model;

import icy.manipulator.property.model.Array;
import icy.manipulator.property.model.ArrayModel;
import java.lang.Override;
import java.lang.String;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.StringJoiner;
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

    /** The exposed property. */
    public final String[] names;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Array() {
        this.names = null;
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
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(", ", "Array [", "]");
        builder.add("names=" + names);
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Array == false) {
            return false;
        }

        Array other = (Array) o;
        if (!Objects.equals(names, other.names)) {
            return false;
        }
        return true;
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
        public final Self names(String... names) {
            Åssignable o = new Åssignable();
            o.names(names);
            return (Self)o;
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
    public static interface ÅssignableÅrbitrary<Next extends Array> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableNames {
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
    }
}
