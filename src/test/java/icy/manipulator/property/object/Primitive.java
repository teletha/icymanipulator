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
    protected Primitive(int intX) {
        this.intX = intX;
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
     * The internal access API for intX property setter.
     */
    protected abstract <T extends ÅssignableLongX> T intX(int value);

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
        this.intX(value);
    }

    /**
     * Retrieve longX property.
     */
    @Override
    public final long longX() {
        return this.longX;
    }

    /**
     * The internal access API for longX property setter.
     */
    protected abstract <T extends ÅssignableFloatX> T longX(long value);

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
        this.longX(value);
    }

    /**
     * Retrieve floatX property.
     */
    @Override
    public final float floatX() {
        return this.floatX;
    }

    /**
     * The internal access API for floatX property setter.
     */
    protected abstract <T extends ÅssignableDoubleX> T floatX(float value);

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
        this.floatX(value);
    }

    /**
     * Retrieve doubleX property.
     */
    @Override
    public final double doubleX() {
        return this.doubleX;
    }

    /**
     * The internal access API for doubleX property setter.
     */
    protected abstract <T extends ÅssignableByteX> T doubleX(double value);

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
        this.doubleX(value);
    }

    /**
     * Retrieve byteX property.
     */
    @Override
    public final byte byteX() {
        return this.byteX;
    }

    /**
     * The internal access API for byteX property setter.
     */
    protected abstract <T extends ÅssignableShortX> T byteX(byte value);

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
        this.byteX(value);
    }

    /**
     * Retrieve shortX property.
     */
    @Override
    public final short shortX() {
        return this.shortX;
    }

    /**
     * The internal access API for shortX property setter.
     */
    protected abstract <T extends ÅssignableCharX> T shortX(short value);

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
        this.shortX(value);
    }

    /**
     * Retrieve charX property.
     */
    @Override
    public final char charX() {
        return this.charX;
    }

    /**
     * The internal access API for charX property setter.
     */
    protected abstract <T extends ÅssignableBooleanX> T charX(char value);

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
        this.charX(value);
    }

    /**
     * Retrieve booleanX property.
     */
    @Override
    public final boolean booleanX() {
        return this.booleanX;
    }

    /**
     * The internal access API for booleanX property setter.
     */
    protected abstract <T extends Primitive> T booleanX(boolean value);

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
        this.booleanX(value);
    }

    /** The singleton model builder. */
    public static final ÅssignableIntX with = new ÅssignableIntX() {

        /** Create Uninitialized {@link Primitive}. */
        @Override
        public <T extends ÅssignableLongX> T intX(int value) {
            return (T) new Åssignable(value);
        }
    };

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Primitive implements ÅssignableIntX, ÅssignableLongX, ÅssignableFloatX, ÅssignableDoubleX, ÅssignableByteX, ÅssignableShortX, ÅssignableCharX, ÅssignableBooleanX {

        /**
         * Initialize by first property.
         */
        private Åssignable(int intX) {
            super(intX);
        }

        /**
         * Modify intX property.
         */
        @Override
        public final <T extends ÅssignableLongX> T intX(int value) {
            try {
                intXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify longX property.
         */
        @Override
        public final <T extends ÅssignableFloatX> T longX(long value) {
            try {
                longXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify floatX property.
         */
        @Override
        public final <T extends ÅssignableDoubleX> T floatX(float value) {
            try {
                floatXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify doubleX property.
         */
        @Override
        public final <T extends ÅssignableByteX> T doubleX(double value) {
            try {
                doubleXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify byteX property.
         */
        @Override
        public final <T extends ÅssignableShortX> T byteX(byte value) {
            try {
                byteXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify shortX property.
         */
        @Override
        public final <T extends ÅssignableCharX> T shortX(short value) {
            try {
                shortXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify charX property.
         */
        @Override
        public final <T extends ÅssignableBooleanX> T charX(char value) {
            try {
                charXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify booleanX property.
         */
        @Override
        public final <T extends Primitive> T booleanX(boolean value) {
            try {
                booleanXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableIntX {

        /** Setter */
        <T extends ÅssignableLongX> T intX(int value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableLongX {

        /** Setter */
        <T extends ÅssignableFloatX> T longX(long value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableFloatX {

        /** Setter */
        <T extends ÅssignableDoubleX> T floatX(float value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDoubleX {

        /** Setter */
        <T extends ÅssignableByteX> T doubleX(double value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableByteX {

        /** Setter */
        <T extends ÅssignableShortX> T byteX(byte value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableShortX {

        /** Setter */
        <T extends ÅssignableCharX> T shortX(short value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableCharX {

        /** Setter */
        <T extends ÅssignableBooleanX> T charX(char value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableBooleanX {

        /** Setter */
        <T extends Primitive> T booleanX(boolean value);
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
