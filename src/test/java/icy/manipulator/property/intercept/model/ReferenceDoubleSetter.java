package icy.manipulator.property.intercept.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.DoubleConsumer;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ReferenceDoubleSetterModel}.
 */
@Generated("Icy Manipulator")
public abstract class ReferenceDoubleSetter extends ReferenceDoubleSetterModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = ReferenceDoubleSetterModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle deriveBySizeintDoubleConsumer= invoker("deriveBySize", int.class, DoubleConsumer.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = ReferenceDoubleSetter.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The final property updater. */
    private static final MethodHandle squareUpdater = updater("square");

    /** The exposed property. */
    public final int size;

    /** The exposed property. */
    public final double square;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ReferenceDoubleSetter() {
        this.size = 0;
        this.square = super.square();
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
     * Retrieve square property.
     */
    @Override
    public final double square() {
        return this.square;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final double getSquare() {
        return this.square;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setSquare(double value) {
        ((ÅssignableÅrbitrary) this).square(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link ReferenceDoubleSetter}.
     */
    public static final class Ìnstantiator<Self extends ReferenceDoubleSetter & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link ReferenceDoubleSetter}.
         */
        public final Self size(int $int) {
            Åssignable o = new Åssignable();
            o.size($int);
            return (Self) o;
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
                sizeUpdater.invoke(this, deriveBySizeintDoubleConsumer.invoke(this, value, (DoubleConsumer) ((Åssignable) this)::square));
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends ReferenceDoubleSetter> {
        /**
         * The base setter.
         */
        default Next square(double value) {
            try {
                squareUpdater.invoke(this, value);
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
    private static final class Åssignable extends ReferenceDoubleSetter implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Square = "square";
    }
}
