package icy.manipulator.property.base.model;

import icy.manipulator.property.base.model.Array;
import icy.manipulator.property.base.model.ArrayModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ArrayModel}.
 */
@Generated("Icy Manipulator")
public class Array implements ArrayModel {

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
    private static final MethodHandle arrayUpdater = updater("array");

    /** The final property updater. */
    private static final MethodHandle nestUpdater = updater("nest");

    /** The exposed property. */
    public final String[] array;

    /** The exposed property. */
    public final String[][] nest;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Array() {
        this.array = null;
        this.nest = ArrayModel.super.nest();
    }

    /**
     * Return the array property.
     *
     * @return A value of array property.
     */
    @Override
    public final String[] array() {
        return this.array;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of array property.
     */
    @SuppressWarnings("unused")
    private final String[] getArray() {
        return this.array;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of array property to assign.
     */
    private final void setArray(String[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The array property requires non-null value.");
        }
        try {
            arrayUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the nest property.
     *
     * @return A value of nest property.
     */
    @Override
    public final String[][] nest() {
        return this.nest;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of nest property.
     */
    @SuppressWarnings("unused")
    private final String[][] getNest() {
        return this.nest;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of nest property to assign.
     */
    private final void setNest(String[][] value) {
        if (value == null) {
            value = ArrayModel.super.nest();
        }
        try {
            nestUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
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
        StringBuilder builder = new StringBuilder("Array [");
        builder.append("array=").append(Arrays.deepToString(array)).append(", ");
        builder.append("nest=").append(Arrays.deepToString(nest)).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(array), Arrays.deepHashCode(nest));
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
        if (!Objects.deepEquals(array, other.array)) return false;
        if (!Objects.deepEquals(nest, other.nest)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Array}  builder methods.
     */
    public static class Ìnstantiator<Self extends Array & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Array} with the specified array property.
         * 
         * @return The next assignable model.
         */
        public Self array(String... array) {
            Åssignable o = new Åssignable();
            o.array(array);
            return (Self)o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableArray<Next> {

        /**
         * Assign array property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next array(String... value) {
            ((Array) this).setArray(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Array> {

        /**
         * Assign nest property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next nest(String[]... value) {
            ((Array) this).setNest(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableArray {
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
        static final String Array = "array";
        static final String Nest = "nest";
    }
}
