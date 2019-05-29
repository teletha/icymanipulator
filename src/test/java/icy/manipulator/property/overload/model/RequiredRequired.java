package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.Overload;
import icy.manipulator.property.overload.model.RequiredRequired;
import icy.manipulator.property.overload.model.RequiredRequiredModel;
import java.lang.String;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link RequiredRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class RequiredRequired extends RequiredRequiredModel {

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
            Method method = RequiredRequiredModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle time$31563479= invoker("time", int.class, int.class, int.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = RequiredRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle timeUpdater = updater("time");

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
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link RequiredRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends RequiredRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<ÅssignableTime<Self>>> T size(BigDecimal size) {
            Åssignable o = new Åssignable();
            o.size(size);
            return (T) o;
        }

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<ÅssignableTime<Self>>> T size(int number) {
            Åssignable o = new Åssignable();
            o.size(number);
            return (T) o;
        }

        /**
         * Create new {@link RequiredRequired} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<ÅssignableTime<Self>>> T sizeByText(String number) {
            Åssignable o = new Åssignable();
            o.sizeByText(number);
            return (T) o;
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
                return time((LocalTime) time$31563479.invoke(this, hour, minute, second));
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
