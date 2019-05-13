package icy.manipulator.property.intercept.model;

import icy.manipulator.property.intercept.model.MultiIntercepts.ÅssignableÅrbitrary;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MultiInterceptsModel}.
 */
@Generated("Icy Manipulator")
public abstract class MultiIntercepts extends MultiInterceptsModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = MultiInterceptsModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle checkLowerint= invoker("checkLower", int.class);

    /** The overload or intercept method invoker. */
    private static final MethodHandle stringlizeintÅssignableÅrbitrary= invoker("stringlize", int.class, ÅssignableÅrbitrary.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = MultiIntercepts.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The exposed property. */
    public final int size;

    /** The exposed property. */
    public final String value;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MultiIntercepts() {
        this.size = 0;
        this.value = super.value();
    }

    /**
     * Retrieve size property.
     */
    @Override
    public final int size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setSize(int value) {
        ((ÅssignableSize) this).size(value);
    }

    /**
     * Retrieve value property.
     */
    @Override
    public final String value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setValue(String value) {
        ((ÅssignableÅrbitrary) this).value(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link MultiIntercepts}.
     */
    public static final class Ìnstantiator<Self extends MultiIntercepts & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link MultiIntercepts}.
         */
        public final <T extends Self> T size(int $int) {
            Åssignable o = new Åssignable();
            o.size($int);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {
        /**
         * The base setter.
         */
        default Next size(int value) {
            try {
                sizeUpdater.invoke(this, stringlizeintÅssignableÅrbitrary.invoke(this, checkLowerint.invoke(this, value), this));
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MultiIntercepts> {
        /**
         * The base setter.
         */
        default Next value(String value) {
            try {
                valueUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MultiIntercepts implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Value = "value";
    }
}
