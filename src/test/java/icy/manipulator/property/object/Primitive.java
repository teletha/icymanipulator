package icy.manipulator.property.object;

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
            throw new Error(e);
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
     * Retrieve intX property.
     */
    @Override
    public final int intX() {
        return this.intX;
    }

    /**
     * 
     */
    abstract Primitive intX(int value);

    /**
     * Provide classic getter API.
     */
    final int getIntX() {
        return this.intX;
    }

    /**
     * Provide classic setter API.
     */
    final void setIntX(int value) {
        try {
            intXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve longX property.
     */
    @Override
    public final long longX() {
        return this.longX;
    }

    /**
     * 
     */
    abstract Primitive longX(long value);

    /**
     * Provide classic getter API.
     */
    final long getLongX() {
        return this.longX;
    }

    /**
     * Provide classic setter API.
     */
    final void setLongX(long value) {
        try {
            longXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve floatX property.
     */
    @Override
    public final float floatX() {
        return this.floatX;
    }

    /**
     * 
     */
    abstract Primitive floatX(float value);

    /**
     * Provide classic getter API.
     */
    final float getFloatX() {
        return this.floatX;
    }

    /**
     * Provide classic setter API.
     */
    final void setFloatX(float value) {
        try {
            floatXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve doubleX property.
     */
    @Override
    public final double doubleX() {
        return this.doubleX;
    }

    /**
     * 
     */
    abstract Primitive doubleX(double value);

    /**
     * Provide classic getter API.
     */
    final double getDoubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic setter API.
     */
    final void setDoubleX(double value) {
        try {
            doubleXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve byteX property.
     */
    @Override
    public final byte byteX() {
        return this.byteX;
    }

    /**
     * 
     */
    abstract Primitive byteX(byte value);

    /**
     * Provide classic getter API.
     */
    final byte getByteX() {
        return this.byteX;
    }

    /**
     * Provide classic setter API.
     */
    final void setByteX(byte value) {
        try {
            byteXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve shortX property.
     */
    @Override
    public final short shortX() {
        return this.shortX;
    }

    /**
     * 
     */
    abstract Primitive shortX(short value);

    /**
     * Provide classic getter API.
     */
    final short getShortX() {
        return this.shortX;
    }

    /**
     * Provide classic setter API.
     */
    final void setShortX(short value) {
        try {
            shortXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve charX property.
     */
    @Override
    public final char charX() {
        return this.charX;
    }

    /**
     * 
     */
    abstract Primitive charX(char value);

    /**
     * Provide classic getter API.
     */
    final char getCharX() {
        return this.charX;
    }

    /**
     * Provide classic setter API.
     */
    final void setCharX(char value) {
        try {
            charXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve booleanX property.
     */
    @Override
    public final boolean booleanX() {
        return this.booleanX;
    }

    /**
     * 
     */
    abstract Primitive booleanX(boolean value);

    /**
     * Provide classic getter API.
     */
    final boolean getBooleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic setter API.
     */
    final void setBooleanX(boolean value) {
        try {
            booleanXUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Builder namespace for {@link Primitive}.
     */
    public static final class with {

        /** Create Uninitialized {@link Primitive}. */
        public static final <Self extends ÅssignableLongX<ÅssignableFloatX<ÅssignableDoubleX<ÅssignableByteX<ÅssignableShortX<ÅssignableCharX<ÅssignableBooleanX<Primitive>>>>>>>> Self intX(int value) {
            return (Self) new Åssignable().intX(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Primitive implements ÅssignableIntX, ÅssignableLongX, ÅssignableFloatX, ÅssignableDoubleX, ÅssignableByteX, ÅssignableShortX, ÅssignableCharX, ÅssignableBooleanX {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable intX(int value) {
            setIntX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable longX(long value) {
            setLongX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable floatX(float value) {
            setFloatX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable doubleX(double value) {
            setDoubleX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable byteX(byte value) {
            setByteX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable shortX(short value) {
            setShortX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable charX(char value) {
            setCharX(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable booleanX(boolean value) {
            setBooleanX(value);
            return this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableIntX<Next> {

        /** Setter */
        Next intX(int value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableLongX<Next> {

        /** Setter */
        Next longX(long value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableFloatX<Next> {

        /** Setter */
        Next floatX(float value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDoubleX<Next> {

        /** Setter */
        Next doubleX(double value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableByteX<Next> {

        /** Setter */
        Next byteX(byte value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableShortX<Next> {

        /** Setter */
        Next shortX(short value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableCharX<Next> {

        /** Setter */
        Next charX(char value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableBooleanX<Next> {

        /** Setter */
        Next booleanX(boolean value);
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
