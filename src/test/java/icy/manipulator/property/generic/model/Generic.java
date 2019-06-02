package icy.manipulator.property.generic.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

import javax.annotation.processing.Generated;

/**
 * Generated model for {@link GenericModel<P, Q>}.
 */
@Generated("Icy Manipulator")
public abstract class Generic<P, Q extends Number> implements GenericModel<P, Q> {

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
            Field field = Generic.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The final property updater. */
    private static final MethodHandle numberUpdater = updater("number");

    /** The exposed property. */
    public final P value;

    /** The exposed property. */
    public final Q number;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Generic() {
        this.value = null;
        this.number = null;
    }

    /**
     * Return the value property.
     *
     * @return A value of value property.
     */
    @Override
    public final P value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final P getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(P value) {
        if (value == null) {
            throw new IllegalArgumentException("The value property requires non-null value.");
        }
        try {
            valueUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the number property.
     *
     * @return A value of number property.
     */
    @Override
    public final Q number() {
        return this.number;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of number property.
     */
    @SuppressWarnings("unused")
    private final Q getNumber() {
        return this.number;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of number property to assign.
     */
    private final void setNumber(Q value) {
        if (value == null) {
            throw new IllegalArgumentException("The number property requires non-null value.");
        }
        try {
            numberUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Generic<P, Q> [");
        builder.append("value=").append(value).append(", ");
        builder.append("number=").append(number).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all
     * the property values were placed into an array, and that array were hashed by calling
     * Arrays.hashCode(Object[]).
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, number);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently,
     * if both properties are null, true is returned and if exactly one property is null, false is
     * returned. Otherwise, equality is determined by using the equals method of the base model.
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Generic == false) {
            return false;
        }

        Generic<P, Q> other = (Generic<P, Q>) o;
        if (!Objects.equals(value, other.value)) return false;
        if (!Objects.equals(number, other.number)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final <P, Q extends Number> Ìnstantiator<?, P, Q> with() {
        return new Ìnstantiator();
    }

    /**
     * Namespace for {@link Generic<P, Q>} builder methods.
     */
    public static final class Ìnstantiator<Self extends Generic<P, Q> & ÅssignableÅrbitrary<Self>, P, Q extends Number> {

        /**
         * Create new {@link Generic<P, Q>} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public final ÅssignableNumber<Self, Q> value(P value) {
            Åssignable o = new Åssignable();
            o.value(value);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValue<Next, P> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(P value) {
            ((Generic) this).setValue(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNumber<Next, Q extends Number> {

        /**
         * Assign number property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next number(Q value) {
            ((Generic) this).setNumber(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Generic> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableValue, ÅssignableNumber {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable<P, Q extends Number> extends Generic<P, Q> implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Value = "value";

        static final String Number = "number";
    }
}