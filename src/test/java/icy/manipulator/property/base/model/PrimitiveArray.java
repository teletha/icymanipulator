package icy.manipulator.property.base.model;

import icy.manipulator.property.base.model.PrimitiveArray;
import icy.manipulator.property.base.model.PrimitiveArrayModel;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link PrimitiveArrayModel}.
 */
@Generated("Icy Manipulator")
public class PrimitiveArray extends PrimitiveArrayModel {

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
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = PrimitiveArray.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle intXUpdater = updater("intX");

    /** The final property updater. */
    private static final MethodHandle longXUpdater = updater("longX");

    /** The final property updater. */
    private static final MethodHandle floatXUpdater = updater("floatX");

    /** The final property updater. */
    private static final MethodHandle doubleXUpdater = updater("doubleX");

    /** The final property updater. */
    private static final MethodHandle byteXUpdater = updater("byteX");

    /** The final property updater. */
    private static final MethodHandle shortXUpdater = updater("shortX");

    /** The final property updater. */
    private static final MethodHandle charXUpdater = updater("charX");

    /** The final property updater. */
    private static final MethodHandle booleanXUpdater = updater("booleanX");

    /** The exposed property. */
    public final int[] intX;

    /** The exposed property. */
    public final long[] longX;

    /** The exposed property. */
    public final float[] floatX;

    /** The exposed property. */
    public final double[] doubleX;

    /** The exposed property. */
    public final byte[] byteX;

    /** The exposed property. */
    public final short[] shortX;

    /** The exposed property. */
    public final char[] charX;

    /** The exposed property. */
    public final boolean[] booleanX;

    /**
     * HIDE CONSTRUCTOR
     */
    protected PrimitiveArray() {
        this.intX = null;
        this.longX = null;
        this.floatX = null;
        this.doubleX = null;
        this.byteX = null;
        this.shortX = null;
        this.charX = null;
        this.booleanX = null;
    }

    /**
     * Return the intX property.
     *
     * @return A value of intX property.
     */
    @Override
    public final int[] intX() {
        return this.intX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of intX property.
     */
    @SuppressWarnings("unused")
    private final int[] getIntX() {
        return this.intX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of intX property to assign.
     */
    private final void setIntX(int[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The intX property requires non-null value.");
        }
        try {
            intXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the longX property.
     *
     * @return A value of longX property.
     */
    @Override
    public final long[] longX() {
        return this.longX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of longX property.
     */
    @SuppressWarnings("unused")
    private final long[] getLongX() {
        return this.longX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of longX property to assign.
     */
    private final void setLongX(long[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The longX property requires non-null value.");
        }
        try {
            longXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the floatX property.
     *
     * @return A value of floatX property.
     */
    @Override
    public final float[] floatX() {
        return this.floatX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of floatX property.
     */
    @SuppressWarnings("unused")
    private final float[] getFloatX() {
        return this.floatX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of floatX property to assign.
     */
    private final void setFloatX(float[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The floatX property requires non-null value.");
        }
        try {
            floatXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the doubleX property.
     *
     * @return A value of doubleX property.
     */
    @Override
    public final double[] doubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of doubleX property.
     */
    @SuppressWarnings("unused")
    private final double[] getDoubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of doubleX property to assign.
     */
    private final void setDoubleX(double[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The doubleX property requires non-null value.");
        }
        try {
            doubleXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the byteX property.
     *
     * @return A value of byteX property.
     */
    @Override
    public final byte[] byteX() {
        return this.byteX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of byteX property.
     */
    @SuppressWarnings("unused")
    private final byte[] getByteX() {
        return this.byteX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of byteX property to assign.
     */
    private final void setByteX(byte[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The byteX property requires non-null value.");
        }
        try {
            byteXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the shortX property.
     *
     * @return A value of shortX property.
     */
    @Override
    public final short[] shortX() {
        return this.shortX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of shortX property.
     */
    @SuppressWarnings("unused")
    private final short[] getShortX() {
        return this.shortX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of shortX property to assign.
     */
    private final void setShortX(short[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The shortX property requires non-null value.");
        }
        try {
            shortXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the charX property.
     *
     * @return A value of charX property.
     */
    @Override
    public final char[] charX() {
        return this.charX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of charX property.
     */
    @SuppressWarnings("unused")
    private final char[] getCharX() {
        return this.charX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of charX property to assign.
     */
    private final void setCharX(char[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The charX property requires non-null value.");
        }
        try {
            charXUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the booleanX property.
     *
     * @return A value of booleanX property.
     */
    @Override
    public final boolean[] booleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of booleanX property.
     */
    @SuppressWarnings("unused")
    private final boolean[] getBooleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of booleanX property to assign.
     */
    private final void setBooleanX(boolean[] value) {
        if (value == null) {
            throw new IllegalArgumentException("The booleanX property requires non-null value.");
        }
        try {
            booleanXUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("PrimitiveArray [");
        builder.append("intX=").append(Arrays.toString(intX)).append(", ");
        builder.append("longX=").append(Arrays.toString(longX)).append(", ");
        builder.append("floatX=").append(Arrays.toString(floatX)).append(", ");
        builder.append("doubleX=").append(Arrays.toString(doubleX)).append(", ");
        builder.append("byteX=").append(Arrays.toString(byteX)).append(", ");
        builder.append("shortX=").append(Arrays.toString(shortX)).append(", ");
        builder.append("charX=").append(Arrays.toString(charX)).append(", ");
        builder.append("booleanX=").append(Arrays.toString(booleanX)).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(intX), Arrays.hashCode(longX), Arrays.hashCode(floatX), Arrays.hashCode(doubleX), Arrays.hashCode(byteX), Arrays.hashCode(shortX), Arrays.hashCode(charX), Arrays.hashCode(booleanX));
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof PrimitiveArray == false) {
            return false;
        }

        PrimitiveArray other = (PrimitiveArray) o;
        if (!Objects.deepEquals(intX, other.intX)) return false;
        if (!Objects.deepEquals(longX, other.longX)) return false;
        if (!Objects.deepEquals(floatX, other.floatX)) return false;
        if (!Objects.deepEquals(doubleX, other.doubleX)) return false;
        if (!Objects.deepEquals(byteX, other.byteX)) return false;
        if (!Objects.deepEquals(shortX, other.shortX)) return false;
        if (!Objects.deepEquals(charX, other.charX)) return false;
        if (!Objects.deepEquals(booleanX, other.booleanX)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link PrimitiveArray}  builder methods.
     */
    public static class Ìnstantiator<Self extends PrimitiveArray & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link PrimitiveArray} with the specified intX property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableLongX<ÅssignableFloatX<ÅssignableDoubleX<ÅssignableByteX<ÅssignableShortX<ÅssignableCharX<ÅssignableBooleanX<Self>>>>>>> intX(int... intX) {
            Åssignable o = new Åssignable();
            o.intX(intX);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableIntX<Next> {

        /**
         * Assign intX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next intX(int... value) {
            ((PrimitiveArray) this).setIntX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableLongX<Next> {

        /**
         * Assign longX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next longX(long... value) {
            ((PrimitiveArray) this).setLongX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableFloatX<Next> {

        /**
         * Assign floatX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next floatX(float... value) {
            ((PrimitiveArray) this).setFloatX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDoubleX<Next> {

        /**
         * Assign doubleX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next doubleX(double... value) {
            ((PrimitiveArray) this).setDoubleX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableByteX<Next> {

        /**
         * Assign byteX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next byteX(byte... value) {
            ((PrimitiveArray) this).setByteX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableShortX<Next> {

        /**
         * Assign shortX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next shortX(short... value) {
            ((PrimitiveArray) this).setShortX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableCharX<Next> {

        /**
         * Assign charX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next charX(char... value) {
            ((PrimitiveArray) this).setCharX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableBooleanX<Next> {

        /**
         * Assign booleanX property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next booleanX(boolean... value) {
            ((PrimitiveArray) this).setBooleanX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends PrimitiveArray> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableIntX, ÅssignableLongX, ÅssignableFloatX, ÅssignableDoubleX, ÅssignableByteX, ÅssignableShortX, ÅssignableCharX, ÅssignableBooleanX {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends PrimitiveArray implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String IntX = "intX";
        static final String LongX = "longX";
        static final String FloatX = "floatX";
        static final String DoubleX = "doubleX";
        static final String ByteX = "byteX";
        static final String ShortX = "shortX";
        static final String CharX = "charX";
        static final String BooleanX = "booleanX";
    }
}
