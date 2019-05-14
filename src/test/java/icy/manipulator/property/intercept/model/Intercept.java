package icy.manipulator.property.intercept.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link InterceptModel}.
 */
@Generated("Icy Manipulator")
public abstract class Intercept extends InterceptModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = InterceptModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle normalizeSize$101282980= invoker("normalizeSize", int.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Intercept.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The exposed property. */
    public final int size;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Intercept() {
        this.size = 0;
    }

    /** Return the size property. */
    @Override
    public final int size() {
        return this.size;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setSize(int value) {
        ((ÅssignableSize) this).size(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Intercept}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Intercept & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new Intercept with the specifiedsize property.
         * 
         * @return The next assignable model.
         */
        public final Self size(int INT) {
            Åssignable o = new Åssignable();
            o.size(INT);
            return (Self) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {

        /**
         * Assign size property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next size(int value) {
            try {
                sizeUpdater.invoke(this, normalizeSize$101282980.invoke(this, value));
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Intercept> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Intercept implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
    }
}
