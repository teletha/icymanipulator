package icy.manipulator.property.optional.model;

import com.google.common.base.Optional;
import icy.manipulator.property.optional.model.GuavaOptional;
import icy.manipulator.property.optional.model.GuavaOptionalModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link GuavaOptionalModel}.
 */
@Generated("Icy Manipulator")
public abstract class GuavaOptional implements GuavaOptionalModel {

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
            Field field = GuavaOptional.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The exposed property. */
    public final Optional<String> value;

    /**
     * HIDE CONSTRUCTOR
     */
    protected GuavaOptional() {
        this.value = Optional.absent();
    }

    /**
     * Return the value property.
     *
     * @return A value of value property.
     */
    @Override
    public final Optional<String> value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final Optional<String> getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(Optional<String> value) {
        if (value == null) {
            value = Optional.absent();
        }
        try {
            valueUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("GuavaOptional [");
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
        if (o instanceof GuavaOptional == false) {
            return false;
        }

        GuavaOptional other = (GuavaOptional) o;
        if (!Objects.equals(value, other.value)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link GuavaOptional}  builder methods.
     */
    public static class Ìnstantiator<Self extends GuavaOptional & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link GuavaOptional}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }

        /**
         * Create initialized {@link GuavaOptional} with value property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self value(Optional<String> value) {
            return create().value(value);
        }

        /**
         * Create initialized {@link GuavaOptional} with value property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self value(String value) {
            return value(Optional.of(value));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends GuavaOptional> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(Optional<String> value) {
            ((GuavaOptional) this).setValue(value);
            return (Next) this;
        }

        /**
         * Assign value property.
         * 
         * @return The next assignable model.
         */
        default Next value(String value) {
            return value(Optional.of(value));
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends GuavaOptional implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Value = "value";
    }
}
