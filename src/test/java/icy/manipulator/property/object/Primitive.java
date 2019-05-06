package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PrimitiveModel}.
 */
public  class Primitive extends PrimitiveModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle intXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "intX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle longXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "longX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle floatXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "floatX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle doubleXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "doubleX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle byteXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "byteX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle shortXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "shortX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle charXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "charX");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle booleanXUpdater = icy.manipulator.Manipulator.updater(Primitive.class, "booleanX");

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
      * HIDE CONSTRUCTOR
      */
     protected Primitive(int intX, long longX, float floatX, double doubleX, byte byteX, short shortX, char charX, boolean booleanX) {
          this.intX = intX;
          this.longX = longX;
          this.floatX = floatX;
          this.doubleX = doubleX;
          this.byteX = byteX;
          this.shortX = shortX;
          this.charX = charX;
          this.booleanX = booleanX;
     }

     /**
     * Retrieve intX property.
     */
     @Override
     public final int intX() {
         return this.intX;
     }

     /**
     * Retrieve longX property.
     */
     @Override
     public final long longX() {
         return this.longX;
     }

     /**
     * Retrieve floatX property.
     */
     @Override
     public final float floatX() {
         return this.floatX;
     }

     /**
     * Retrieve doubleX property.
     */
     @Override
     public final double doubleX() {
         return this.doubleX;
     }

     /**
     * Retrieve byteX property.
     */
     @Override
     public final byte byteX() {
         return this.byteX;
     }

     /**
     * Retrieve shortX property.
     */
     @Override
     public final short shortX() {
         return this.shortX;
     }

     /**
     * Retrieve charX property.
     */
     @Override
     public final char charX() {
         return this.charX;
     }

     /**
     * Retrieve booleanX property.
     */
     @Override
     public final boolean booleanX() {
         return this.booleanX;
     }

     /**
      * Create model builder without base model.
      */
     public static final <T extends INTX> T create() {
         return (T) new Melty();
     }

    /**
     * Mutable Model.
    */
    private static final class Melty extends Primitive implements INTX, LONGX, FLOATX, DOUBLEX, BYTEX, SHORTX, CHARX, BOOLEANX {

        /**
         * Modify intX property.
        */
        @Override
        public final <T extends LONGX> T intX(int value) {
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
        public final <T extends FLOATX> T longX(long value) {
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
        public final <T extends DOUBLEX> T floatX(float value) {
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
        public final <T extends BYTEX> T doubleX(double value) {
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
        public final <T extends SHORTX> T byteX(byte value) {
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
        public final <T extends CHARX> T shortX(short value) {
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
        public final <T extends BOOLEANX> T charX(char value) {
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
    public static interface INTX {
        <T extends LONGX> T intX(int value);
    }

    /**
     * Property assignment API.
    */
    public static interface LONGX {
        <T extends FLOATX> T longX(long value);
    }

    /**
     * Property assignment API.
    */
    public static interface FLOATX {
        <T extends DOUBLEX> T floatX(float value);
    }

    /**
     * Property assignment API.
    */
    public static interface DOUBLEX {
        <T extends BYTEX> T doubleX(double value);
    }

    /**
     * Property assignment API.
    */
    public static interface BYTEX {
        <T extends SHORTX> T byteX(byte value);
    }

    /**
     * Property assignment API.
    */
    public static interface SHORTX {
        <T extends CHARX> T shortX(short value);
    }

    /**
     * Property assignment API.
    */
    public static interface CHARX {
        <T extends BOOLEANX> T charX(char value);
    }

    /**
     * Property assignment API.
    */
    public static interface BOOLEANX {
        <T extends Primitive> T booleanX(boolean value);
    }
}
