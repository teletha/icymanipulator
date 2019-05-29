package icy.manipulator.property.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link PrimitiveModel}.
 */
@Generated("Icy Manipulator")
public abstract class Primitive extends PrimitiveModel {

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
            Field field = Primitive.class.getDeclaredField(name);
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
    public final int intX;

    /** The exposed property. */
    public final long longX;

    /** The exposed property. */
    public final float floatX;

    /** The exposed property. */
    public final double doubleX;

    /** The exposed property. */
    public final byte byteX;

    /** The exposed property. */
    public final short shortX;

    /** The exposed property. */
    public final char charX;

    /** The exposed property. */
    public final boolean booleanX;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Primitive() {
        this.intX = 0;
        this.longX = 0L;
        this.floatX = 0;
        this.doubleX = 0D;
        this.byteX = 0;
        this.shortX = 0;
        this.charX = ' ';
        this.booleanX = false;
    }

    /**
     * Return the intX property.
     *
     * @return A value of intX property.
     */
    @Override
    public final int intX() {
        return this.intX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of intX property.
     */
    @SuppressWarnings("unused")
    private final int getIntX() {
        return this.intX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of intX property to assign.
     */
    private final void setIntX(int value) {
        try {
            intXUpdater.invoke(this, value);
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
    public final long longX() {
        return this.longX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of longX property.
     */
    @SuppressWarnings("unused")
    private final long getLongX() {
        return this.longX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of longX property to assign.
     */
    private final void setLongX(long value) {
        try {
            longXUpdater.invoke(this, value);
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
    public final float floatX() {
        return this.floatX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of floatX property.
     */
    @SuppressWarnings("unused")
    private final float getFloatX() {
        return this.floatX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of floatX property to assign.
     */
    private final void setFloatX(float value) {
        try {
            floatXUpdater.invoke(this, value);
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
    public final double doubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of doubleX property.
     */
    @SuppressWarnings("unused")
    private final double getDoubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of doubleX property to assign.
     */
    private final void setDoubleX(double value) {
        try {
            doubleXUpdater.invoke(this, value);
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
    public final byte byteX() {
        return this.byteX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of byteX property.
     */
    @SuppressWarnings("unused")
    private final byte getByteX() {
        return this.byteX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of byteX property to assign.
     */
    private final void setByteX(byte value) {
        try {
            byteXUpdater.invoke(this, value);
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
    public final short shortX() {
        return this.shortX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of shortX property.
     */
    @SuppressWarnings("unused")
    private final short getShortX() {
        return this.shortX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of shortX property to assign.
     */
    private final void setShortX(short value) {
        try {
            shortXUpdater.invoke(this, value);
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
    public final char charX() {
        return this.charX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of charX property.
     */
    @SuppressWarnings("unused")
    private final char getCharX() {
        return this.charX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of charX property to assign.
     */
    private final void setCharX(char value) {
        try {
            charXUpdater.invoke(this, value);
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
    public final boolean booleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of booleanX property.
     */
    @SuppressWarnings("unused")
    private final boolean getBooleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of booleanX property to assign.
     */
    private final void setBooleanX(boolean value) {
        try {
            booleanXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Primitive}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Primitive & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Primitive} with the specified intX property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableLongX<ÅssignableFloatX<ÅssignableDoubleX<ÅssignableByteX<ÅssignableShortX<ÅssignableCharX<ÅssignableBooleanX<Self>>>>>>>> T intX(int intX) {
            Åssignable o = new Åssignable();
            o.intX(intX);
            return (T) o;
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
        default Next intX(int value) {
            ((Primitive) this).setIntX(value);
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
        default Next longX(long value) {
            ((Primitive) this).setLongX(value);
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
        default Next floatX(float value) {
            ((Primitive) this).setFloatX(value);
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
        default Next doubleX(double value) {
            ((Primitive) this).setDoubleX(value);
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
        default Next byteX(byte value) {
            ((Primitive) this).setByteX(value);
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
        default Next shortX(short value) {
            ((Primitive) this).setShortX(value);
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
        default Next charX(char value) {
            ((Primitive) this).setCharX(value);
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
        default Next booleanX(boolean value) {
            ((Primitive) this).setBooleanX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Primitive> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableIntX, ÅssignableLongX, ÅssignableFloatX, ÅssignableDoubleX, ÅssignableByteX, ÅssignableShortX, ÅssignableCharX, ÅssignableBooleanX {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Primitive implements ÅssignableAll, ÅssignableÅrbitrary {
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
