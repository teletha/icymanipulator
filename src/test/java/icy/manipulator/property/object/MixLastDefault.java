package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link MixLastDefaultModel}.
 */
public  class MixLastDefault extends MixLastDefaultModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(MixLastDefault.class, "name");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle ageUpdater = icy.manipulator.Manipulator.updater(MixLastDefault.class, "age");

     /** The exposed property. */
     public final String name;

     /** The exposed property. */
     public final int age;

     /**
      * HIDE CONSTRUCTOR
      */
     protected MixLastDefault() {
          this.name = null;
          this.age = super.age();
     }

     /**
      * HIDE CONSTRUCTOR
      */
     protected MixLastDefault(String name, int age) {
          this.name = name;
          this.age = age;
     }

     /**
     * Retrieve name property.
     */
     @Override
     public final String name() {
         return this.name;
     }

     /**
     * Retrieve age property.
     */
     @Override
     public final int age() {
         return this.age;
     }

     /**
      * Create model builder without base model.
      */
     public static final NAME create() {
         return new Melty();
     }

    /**
     * Mutable Model.
    */
    private static final class Melty extends MixLastDefault implements NAME, OPTIONS {

        /**
         * Modify name property.
        */
        @Override
        public final <T extends MixLastDefault & OPTIONS> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return (T) this;
        }

        /**
         * Modify age property.
        */
        @Override
        public final <T extends MixLastDefault & OPTIONS> T age(int value) {
            try {
                ageUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return (T) this;
        }
     }

    /**
     * Property assignment API.
    */
    public static interface NAME {
        <T extends MixLastDefault & OPTIONS> T name(String value);
    }

    /**
     * Property assignment API.
    */
    public static interface OPTIONS {

    /**
     * Property assignment API.
    */
    <T extends MixLastDefault & OPTIONS> T age(int value);
    }
}
