package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link DefaultModel}.
 */
public  class Default extends DefaultModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(Default.class, "name");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle standUpdater = icy.manipulator.Manipulator.updater(Default.class, "stand");

     /** The exposed property. */
     public final String name;

     /** The exposed property. */
     public final String stand;

     /**
      * HIDE CONSTRUCTOR
      */
     protected Default() {
          this.name = super.name();
          this.stand = super.stand();
     }

     /**
      * HIDE CONSTRUCTOR
      */
     protected Default(String name, String stand) {
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
     public static final <T extends Default & OPTIONS> T create() {
         return (T) new Melty();
     }

    /**
     * Mutable Model.
    */
    private static final class Melty extends Default implements OPTIONS {

        /**
         * Modify name property.
        */
        @Override
        public final <T extends Default & OPTIONS> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return (T) this;
        }

        /**
         * Modify stand property.
        */
        @Override
        public final <T extends Default & OPTIONS> T stand(String value) {
            try {
                standUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }

            return (T) this;
        }
     }

    /**
     * Property assignment API.
    */
    public static interface OPTIONS {

    /**
     * Property assignment API.
    */
    <T extends Default & OPTIONS> T name(String value);

    /**
     * Property assignment API.
    */
    <T extends Default & OPTIONS> T stand(String value);
    }
}
