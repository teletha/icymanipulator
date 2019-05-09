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
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getIntX() {
        return this.intX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setIntX(int value) {
        ((ÅssignableIntX) this).intX(value);
    }

    /**
     * Retrieve longX property.
     */
    @Override
    public final long longX() {
        return this.longX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final long getLongX() {
        return this.longX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setLongX(long value) {
        ((ÅssignableLongX) this).longX(value);
    }

    /**
     * Retrieve floatX property.
     */
    @Override
    public final float floatX() {
        return this.floatX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final float getFloatX() {
        return this.floatX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setFloatX(float value) {
        ((ÅssignableFloatX) this).floatX(value);
    }

    /**
     * Retrieve doubleX property.
     */
    @Override
    public final double doubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final double getDoubleX() {
        return this.doubleX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setDoubleX(double value) {
        ((ÅssignableDoubleX) this).doubleX(value);
    }

    /**
     * Retrieve byteX property.
     */
    @Override
    public final byte byteX() {
        return this.byteX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final byte getByteX() {
        return this.byteX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setByteX(byte value) {
        ((ÅssignableByteX) this).byteX(value);
    }

    /**
     * Retrieve shortX property.
     */
    @Override
    public final short shortX() {
        return this.shortX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final short getShortX() {
        return this.shortX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setShortX(short value) {
        ((ÅssignableShortX) this).shortX(value);
    }

    /**
     * Retrieve charX property.
     */
    @Override
    public final char charX() {
        return this.charX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final char getCharX() {
        return this.charX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setCharX(char value) {
        ((ÅssignableCharX) this).charX(value);
    }

    /**
     * Retrieve booleanX property.
     */
    @Override
    public final boolean booleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final boolean getBooleanX() {
        return this.booleanX;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setBooleanX(boolean value) {
        ((ÅssignableBooleanX) this).booleanX(value);
    }

    /** The singleton builder. */
    public static final  ÌnstantiatorTyped<?> with = new ÌnstantiatorTyped();

    public static final class ÌnstantiatorTyped<Self extends Primitive & ÅssignableÅrbitrary<Self>> extends Ìnstantiator<Self> {
    }

    /**
     * Builder namespace for {@link Primitive}.
     */
    protected static class Ìnstantiator<Self> {

        /** Create Uninitialized {@link Primitive}. */
        public final <T extends ÅssignableLongX<ÅssignableFloatX<ÅssignableDoubleX<ÅssignableByteX<ÅssignableShortX<ÅssignableCharX<ÅssignableBooleanX<Self>>>>>>>> T intX(int value) {
            return (T) base().intX(value);
        }
        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableIntX<Next> {

        /**
         * The setter.
         */
        default Next intX(int value) {
            try {
                intXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableLongX<Next> {

        /**
         * The setter.
         */
        default Next longX(long value) {
            try {
                longXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableFloatX<Next> {

        /**
         * The setter.
         */
        default Next floatX(float value) {
            try {
                floatXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDoubleX<Next> {

        /**
         * The setter.
         */
        default Next doubleX(double value) {
            try {
                doubleXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableByteX<Next> {

        /**
         * The setter.
         */
        default Next byteX(byte value) {
            try {
                byteXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableShortX<Next> {

        /**
         * The setter.
         */
        default Next shortX(short value) {
            try {
                shortXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableCharX<Next> {

        /**
         * The setter.
         */
        default Next charX(char value) {
            try {
                charXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableBooleanX<Next> {

        /**
         * The setter.
         */
        default Next booleanX(boolean value) {
            try {
                booleanXUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
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
