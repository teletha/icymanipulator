package icy.manipulator.property.overload.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OverloadRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class OverloadRequired extends OverloadRequiredModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle updater(String name, Class... parameterTypes)  {
        try {
            Method method = OverloadRequiredModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload method invoker. */
    private static final MethodHandle timeintintint= updater("time", int.class, int.class, int.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = OverloadRequired.class.getDeclaredField(name);
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
    protected OverloadRequired() {
        this.time = null;
    }

    /**
     * Retrieve time property.
     */
    @Override
    public final LocalTime time() {
        return this.time;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final LocalTime getTime() {
        return this.time;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setTime(LocalTime value) {
        ((ÅssignableTime) this).time(value);
    }

    /** The singleton builder. */
    public static final  ÌnstantiatorTyped<?> with = new ÌnstantiatorTyped();

    public static final class ÌnstantiatorTyped<Self extends OverloadRequired & ÅssignableÅrbitrary<Self>> extends Ìnstantiator<Self> {
    }

    /**
     * Builder namespace for {@link OverloadRequired}.
     */
    protected static class Ìnstantiator<Self> extends Overload.Ìnstantiator<ÅssignableTime<Self>> {

        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableTime<Next> {

        /**
         * The overload setter.
         */
        default Next time(int hour, int minute, int second) {
            try {
                return time((LocalTime) timeintintint.invoke(this, hour, minute, second));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * The setter.
         */
        default Next time(LocalTime value) {
            try {
                timeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends OverloadRequired> extends icy.manipulator.property.overload.model.Overload.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableTime, Overload.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends OverloadRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Time = "time";
    }
}
