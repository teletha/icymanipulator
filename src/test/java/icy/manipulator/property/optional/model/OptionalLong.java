package icy.manipulator.property.optional.model;

import icy.manipulator.property.optional.model.OptionalLong;
import icy.manipulator.property.optional.model.OptionalLongModel;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OptionalLongModel}.
 */
@Generated("Icy Manipulator")
public abstract class OptionalLong implements OptionalLongModel {

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
            Field field = OptionalLong.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The exposed property. */
    public final java.util.OptionalLong value;

    /**
     * HIDE CONSTRUCTOR
     */
    protected OptionalLong() {
        this.value = null;
    }

    /**
     * Return the value property.
     *
     * @return A value of value property.
     */
    @Override
    public final java.util.OptionalLong value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final java.util.OptionalLong getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(java.util.OptionalLong value) {
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
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("OptionalLong [");
        builder.append("value=").append(value).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof OptionalLong == false) {
            return false;
        }

        OptionalLong other = (OptionalLong) o;
        if (!Objects.equals(value, other.value)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link OptionalLong}  builder methods.
     */
    public static final class Ìnstantiator<Self extends OptionalLong & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link OptionalLong} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public final Self value(java.util.OptionalLong value) {
            Åssignable o = new Åssignable();
            o.value(value);
            return (Self)o;
        }

        /**
         * Create new {@link OptionalLong} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public final Self value(long value) {
            Åssignable o = new Åssignable();
            o.value(value);
            return (Self)o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValue<Next> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(java.util.OptionalLong value) {
            ((OptionalLong) this).setValue(value);
            return (Next) this;
        }

        /**
         * Assign value property.
         * 
         * @return The next assignable model.
         */
        default Next value(long value) {
            return value(java.util.OptionalLong.of(value));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends OptionalLong> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableValue {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends OptionalLong implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Value = "value";
    }
}
