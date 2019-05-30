package icy.manipulator.property.error.model;

import icy.manipulator.property.error.model.NullValue;
import icy.manipulator.property.error.model.NullValueModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link NullValueModel}.
 */
@Generated("Icy Manipulator")
public abstract class NullValue extends NullValueModel {

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
            Field field = NullValue.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle rejectNullUpdater = updater("rejectNull");

    /** The final property updater. */
    private static final MethodHandle acceptNullUpdater = updater("acceptNull");

    /** The final property updater. */
    private static final MethodHandle defaultValueUpdater = updater("defaultValue");

    /** The exposed property. */
    public final String rejectNull;

    /** The exposed property. */
    public final String acceptNull;

    /** The exposed property. */
    public final String defaultValue;

    /**
     * HIDE CONSTRUCTOR
     */
    protected NullValue() {
        this.rejectNull = null;
        this.acceptNull = null;
        this.defaultValue = super.defaultValue();
    }

    /**
     * Return the rejectNull property.
     *
     * @return A value of rejectNull property.
     */
    @Override
    public final String rejectNull() {
        return this.rejectNull;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of rejectNull property.
     */
    @SuppressWarnings("unused")
    private final String getRejectNull() {
        return this.rejectNull;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of rejectNull property to assign.
     */
    private final void setRejectNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The rejectNull property requires non-null value.");
        }
        try {
            rejectNullUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the acceptNull property.
     *
     * @return A value of acceptNull property.
     */
    @Override
    public final String acceptNull() {
        return this.acceptNull;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of acceptNull property.
     */
    @SuppressWarnings("unused")
    private final String getAcceptNull() {
        return this.acceptNull;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of acceptNull property to assign.
     */
    private final void setAcceptNull(String value) {
        try {
            acceptNullUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the defaultValue property.
     *
     * @return A value of defaultValue property.
     */
    @Override
    public final String defaultValue() {
        return this.defaultValue;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of defaultValue property.
     */
    @SuppressWarnings("unused")
    private final String getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of defaultValue property to assign.
     */
    private final void setDefaultValue(String value) {
        if (value == null) {
            value = super.defaultValue();
        }
        try {
            defaultValueUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("NullValue [");
        builder.append("rejectNull=").append(rejectNull).append(", ");
        builder.append("acceptNull=").append(acceptNull).append(", ");
        builder.append("defaultValue=").append(defaultValue).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rejectNull, acceptNull, defaultValue);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof NullValue == false) {
            return false;
        }

        NullValue other = (NullValue) o;
        if (!Objects.equals(rejectNull, other.rejectNull)) return false;
        if (!Objects.equals(acceptNull, other.acceptNull)) return false;
        if (!Objects.equals(defaultValue, other.defaultValue)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link NullValue}  builder methods.
     */
    public static final class Ìnstantiator<Self extends NullValue & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link NullValue} with the specified rejectNull property.
         * 
         * @return The next assignable model.
         */
        public final ÅssignableAcceptNull<Self> rejectNull(String rejectNull) {
            Åssignable o = new Åssignable();
            o.rejectNull(rejectNull);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableRejectNull<Next> {

        /**
         * Assign rejectNull property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next rejectNull(String value) {
            ((NullValue) this).setRejectNull(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAcceptNull<Next> {

        /**
         * Assign acceptNull property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next acceptNull(String value) {
            ((NullValue) this).setAcceptNull(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends NullValue> {

        /**
         * Assign defaultValue property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next defaultValue(String value) {
            ((NullValue) this).setDefaultValue(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableRejectNull, ÅssignableAcceptNull {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends NullValue implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String RejectNull = "rejectNull";
        static final String AcceptNull = "acceptNull";
        static final String DefaultValue = "defaultValue";
    }
}
