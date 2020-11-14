package icy.manipulator.property.optional.model;

import icy.manipulator.property.optional.model.Optional;
import icy.manipulator.property.optional.model.OptionalModel;
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
 * Generated model for {@link OptionalModel}.
 */
@Generated("Icy Manipulator")
public abstract class Optional implements OptionalModel {

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
            Field field = Optional.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle defaultsUpdater = updater("defaults");

    /** The exposed property. */
    public final java.util.Optional<String> name;

    /** The exposed property. */
    public final java.util.Optional<String> defaults;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Optional() {
        this.name = java.util.Optional.empty();
        this.defaults = OptionalModel.super.defaults();
    }

    /**
     * Return the name property.
     *
     * @return A value of name property.
     */
    @Override
    public final java.util.Optional<String> name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of name property.
     */
    @SuppressWarnings("unused")
    private final java.util.Optional<String> getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of name property to assign.
     */
    private final void setName(java.util.Optional<String> value) {
        if (value == null) {
            value = java.util.Optional.empty();
        }
        try {
            nameUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the defaults property.
     *
     * @return A value of defaults property.
     */
    @Override
    public final java.util.Optional<String> defaults() {
        return this.defaults;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of defaults property.
     */
    @SuppressWarnings("unused")
    private final java.util.Optional<String> getDefaults() {
        return this.defaults;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of defaults property to assign.
     */
    private final void setDefaults(java.util.Optional<String> value) {
        if (value == null) {
            value = OptionalModel.super.defaults();
        }
        try {
            defaultsUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Optional [");
        builder.append("name=").append(name).append(", ");
        builder.append("defaults=").append(defaults).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, defaults);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Optional == false) {
            return false;
        }

        Optional other = (Optional) o;
        if (!Objects.equals(name, other.name)) return false;
        if (!Objects.equals(defaults, other.defaults)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Optional}  builder methods.
     */
    public static class Ìnstantiator<Self extends Optional & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link Optional}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }

        /**
         * Create initialized {@link Optional} with name property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self name(java.util.Optional<String> value) {
            return create().name(value);
        }

        /**
         * Create initialized {@link Optional} with name property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self name(String value) {
            return name(java.util.Optional.of(value));
        }

        /**
         * Create initialized {@link Optional} with defaults property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self defaults(java.util.Optional<String> value) {
            return create().defaults(value);
        }

        /**
         * Create initialized {@link Optional} with defaults property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self defaults(String value) {
            return defaults(java.util.Optional.of(value));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Optional> {

        /**
         * Assign name property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next name(java.util.Optional<String> value) {
            ((Optional) this).setName(value);
            return (Next) this;
        }

        /**
         * Assign name property.
         * 
         * @return The next assignable model.
         */
        default Next name(String value) {
            return name(java.util.Optional.of(value));
        }

        /**
         * Assign defaults property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next defaults(java.util.Optional<String> value) {
            ((Optional) this).setDefaults(value);
            return (Next) this;
        }

        /**
         * Assign defaults property.
         * 
         * @return The next assignable model.
         */
        default Next defaults(String value) {
            return defaults(java.util.Optional.of(value));
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
    private static final class Åssignable extends Optional implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Defaults = "defaults";
    }
}
