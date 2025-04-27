package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.RequiredRequired;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Generated model for {@link RequiredRequiredModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class RequiredRequired extends RequiredRequiredModel {

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
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = icy.manipulator.property.overload.model.RequiredRequiredModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle time$1860699197= invoker("time", int.class, int.class, int.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final Field updater(String name)  {
        try {
            Field field = RequiredRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Create fast property updater.
     *
     * @param field A target field.
     * @return A fast property updater.
     */
    private static final MethodHandle handler(Field field)  {
        try {
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final Field timeField = updater("time");

    /** The fast final property updater. */
    private static final MethodHandle timeUpdater = handler(timeField);

    /** The exposed property. */
    public final LocalTime time;

    /**
     * HIDE CONSTRUCTOR
     */
    protected RequiredRequired() {
        this.time = null;
    }

    /**
     * Return the time property.
     *
     * @return A value of time property.
     */
    @Override
    public final LocalTime time() {
        return this.time;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of time property.
     */
    @SuppressWarnings("unused")
    private final LocalTime getTime() {
        return this.time;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of time property to assign.
     */
    private final void setTime(LocalTime value) {
        if (value == null) {
            throw new IllegalArgumentException("The time property requires non-null value.");
        }
        try {
            timeUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("RequiredRequired [");
        builder.append("size=").append(size).append(", ");
        builder.append("date=").append(date).append(", ");
        builder.append("time=").append(time).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, date, time);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof RequiredRequired == false) {
            return false;
        }

        RequiredRequired other = (RequiredRequired) o;
        if (!Objects.equals(size, other.size)) return false;
        if (!Objects.equals(date, other.date)) return false;
        if (!Objects.equals(time, other.time)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link RequiredRequired}  builder methods.
     */
    public static class Ìnstantiator<Self extends RequiredRequired & ÅssignableÅrbitrary<Self>> extends icy.manipulator.property.overload.model.Overload.Ìnstantiator {

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableDate<ÅssignableTime<Self>> size(BigDecimal size) {
            Åssignable o = new Åssignable();
            o.size(size);
            return o;
        }

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableDate<ÅssignableTime<Self>> size(int number) {
            Åssignable o = new Åssignable();
            o.size(number);
            return o;
        }

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableDate<ÅssignableTime<Self>> sizeByText(String number) {
            Åssignable o = new Åssignable();
            o.sizeByText(number);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableTime<Next> {

        /**
         * Assign time property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next time(LocalTime value) {
            ((RequiredRequired) this).setTime(value);
            return (Next) this;
        }

        /**
         * Assign time property.
         * 
         * @return The next assignable model.
         */
        default Next time(int hour, int minute, int second) {
            try {
                return time((LocalTime) time$1860699197.invoke(this, hour, minute, second));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends RequiredRequired> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableTime, Overload.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends RequiredRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Time = "time";
    }
}
