package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link MultipleModel}.
 */
public  class Multiple extends MultipleModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(Multiple.class, "name");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle standUpdater = icy.manipulator.Manipulator.updater(Multiple.class, "stand");

     /** The exposed property. */
     public final String name;

     /** The exposed property. */
     public final String stand;

     /**
      * HIDE CONSTRUCTOR
      */
     protected Multiple() {
          this.name = null;
          this.stand = null;
     }

     /**
      * HIDE CONSTRUCTOR
      */
     protected Multiple(String name, String stand) {
          this.name = name;
          this.stand = stand;
     }

     /**
     * Retrieve name property.
     */
     @Override
     public final String name() {
         return this.name;
     }

     /**
     * Retrieve stand property.
     */
     @Override
     public final String stand() {
         return this.stand;
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
    private static final class Melty extends Multiple implements NAME, STAND {

        /**
         * Modify name property.
        */
        public final STAND name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return this;
        }

        /**
         * Modify stand property.
        */
        public final Multiple stand(String value) {
            try {
                standUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return this;
        }
     }

    /**
     * Property assignment API.
    */
    public static interface NAME {
        STAND name(String value);
    }

    /**
     * Property assignment API.
    */
    public static interface STAND {
        Multiple stand(String value);
    }
}
