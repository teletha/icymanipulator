package icy.manipulator.property.intercept.model;

import icy.manipulator.property.intercept.model.ReferenceLongSetter;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.LongConsumer;

/**
 * Generated model for {@link ReferenceLongSetterModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class ReferenceLongSetter extends ReferenceLongSetterModel {

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
            Method method = icy.manipulator.property.intercept.model.ReferenceLongSetterModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle deriveBySize$369667721= invoker("deriveBySize", int.class, LongConsumer.class);

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

    /** The property holder.*/
    // A primitive property is hidden coz native-image builder can't cheat assigning to final field.
    // If you want expose as public-final field, you must use the wrapper type instead of primitive type.
    protected int size;

    /** The property holder.*/
    // A primitive property is hidden coz native-image builder can't cheat assigning to final field.
    // If you want expose as public-final field, you must use the wrapper type instead of primitive type.
    protected long square;

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
            this.size = (int) deriveBySize$369667721.invoke(this, value, (LongConsumer) this::setSquare);
        } catch (UnsupportedOperationException e) {
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
            this.square = (long) value;
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
        StringBuilder builder = new StringBuilder("ReferenceLongSetter [");
        builder.append("size=").append(size).append(", ");
        builder.append("square=").append(square).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, square);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ReferenceLongSetter == false) {
            return false;
        }

        ReferenceLongSetter other = (ReferenceLongSetter) o;
        if (size != other.size) return false;
        if (square != other.square) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ReferenceLongSetter}  builder methods.
     */
    public static class Ìnstantiator<Self extends ReferenceLongSetter & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link ReferenceLongSetter} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public Self size(int size) {
            Åssignable o = new Åssignable();
            o.size(size);
            return (Self)o;
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
