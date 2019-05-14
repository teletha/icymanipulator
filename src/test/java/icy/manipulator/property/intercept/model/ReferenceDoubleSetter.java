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
    private static final MethodHandle deriveBySize$1357412609= invoker("deriveBySize", int.class, DoubleConsumer.class);

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

    /** Return the square property. */
    @Override
    public final double square() {
        return this.square;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final double getSquare() {
        return this.square;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setSquare(double value) {
        ((ÅssignableÅrbitrary) this).square(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ReferenceDoubleSetter}  builder methods.
     */
    public static final class Ìnstantiator<Self extends ReferenceDoubleSetter & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new ReferenceDoubleSetter with the specifiedsize property.
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
                sizeUpdater.invoke(this, deriveBySize$1357412609.invoke(this, value, (DoubleConsumer) ((Åssignable) this)::square));
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
         * Assign square property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
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
