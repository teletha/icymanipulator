package icy.manipulator.property.overload.model;

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
            throw new Error(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle time$1789750340= invoker("time", int.class, int.class, int.class);

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
            throw new Error(e);
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

    /** Return the time property. */
    @Override
    public final LocalTime time() {
        return this.time;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final LocalTime getTime() {
        return this.time;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setTime(LocalTime value) {
        ((ÅssignableTime) this).time(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link RequiredRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends RequiredRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new RequiredRequired with the specifiedsize property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<ÅssignableTime<Self>>> T size(BigDecimal bigDecimal) {
            Åssignable o = new Åssignable();
            o.size(bigDecimal);
            return (T) o;
        }

        /**
         * Create new RequiredRequired with the specifiedsize property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<ÅssignableTime<Self>>> T size(int number) {
            Åssignable o = new Åssignable();
            o.size(number);
            return (T) o;
        }

        /**
         * Create new RequiredRequired with the specifiedsize property.
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
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next time(LocalTime value) {
            try {
                timeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**  */
        default Next time(int hour, int minute, int second) {
            try {
                return time((LocalTime) time$1789750340.invoke(this, hour, minute, second));
            } catch (Throwable e) {
                throw new Error(e);
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
    protected static interface ÅssignableAll extends ÅssignableTime, icy.manipulator.property.overload.model.Overload.ÅssignableAll {
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
