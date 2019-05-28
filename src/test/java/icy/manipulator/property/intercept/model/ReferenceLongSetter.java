package icy.manipulator.property.intercept.model;

import icy.manipulator.property.intercept.model.ReferenceLongSetter;
import icy.manipulator.property.intercept.model.ReferenceLongSetterModel;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.LongConsumer;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ReferenceLongSetterModel}.
 */
@Generated("Icy Manipulator")
public abstract class ReferenceLongSetter extends ReferenceLongSetterModel {

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
            Method method = ReferenceLongSetterModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle deriveBySize$449842932= invoker("deriveBySize", int.class, LongConsumer.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = ReferenceLongSetter.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The final property updater. */
    private static final MethodHandle squareUpdater = updater("square");

    /** The exposed property. */
    public final int size;

    /** The exposed property. */
    public final long square;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ReferenceLongSetter() {
        this.size = 0;
        this.square = super.square();
    }

    /**
     * Return the size property.
     *
     * @return A value of size property.
     */
    @Override
    public final int size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of size property.
     */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of size property to assign.
     */
    private final void setSize(int value) {
        try {
            sizeUpdater.invoke(this, deriveBySize$449842932.invoke(this, value, (LongConsumer) ((Åssignable) this)::square));
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the square property.
     *
     * @return A value of square property.
     */
    @Override
    public final long square() {
        return this.square;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of square property.
     */
    @SuppressWarnings("unused")
    private final long getSquare() {
        return this.square;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of square property to assign.
     */
    private final void setSquare(long value) {
        try {
            squareUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Provide accesser to super default value.
     *
     * @return A default value.
     */
    private final long åccessToDefaultSquare() {
        return super.square();
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ReferenceLongSetter}  builder methods.
     */
    public static final class Ìnstantiator<Self extends ReferenceLongSetter & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link ReferenceLongSetter} with the specified size property.
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
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next size(int value) {
            ((ReferenceLongSetter) this).setSize(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends ReferenceLongSetter> {

        /**
         * Assign square property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next square(long value) {
            ((ReferenceLongSetter) this).setSquare(value);
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
    private static final class Åssignable extends ReferenceLongSetter implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Square = "square";
    }
}
