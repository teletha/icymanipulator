package icy.manipulator.property.error.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
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
    @SuppressWarnings("unused")
    private final void setRejectNull(String value) {
        ((ÅssignableRejectNull) this).rejectNull(value);
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
    @SuppressWarnings("unused")
    private final void setAcceptNull(String value) {
        ((ÅssignableAcceptNull) this).acceptNull(value);
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
    @SuppressWarnings("unused")
    private final void setDefaultValue(String value) {
        ((ÅssignableÅrbitrary) this).defaultValue(value);
    }

    /**
     * Provide accesser to super default value.
     *
     * @return A default value.
     */
    private final String åccessToDefaultDefaultValue() {
        return super.defaultValue();
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
        public final <T extends ÅssignableAcceptNull<Self>> T rejectNull(String string) {
            Åssignable o = new Åssignable();
            o.rejectNull(string);
            return (T) o;
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
            if (value == null) {
                throw new IllegalArgumentException("The rejectNull property requires non-null value.");
            }
            try {
                rejectNullUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
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
            try {
                acceptNullUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
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
            if (value == null) {
                value = ((NullValue) this).åccessToDefaultDefaultValue();
            }
            try {
                defaultValueUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw quiet(e);
            }
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
