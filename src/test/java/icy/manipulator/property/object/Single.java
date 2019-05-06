package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link SingleModel}.
 */
public  class Single extends SingleModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(Single.class, "name");

     /** The exposed property. */
     public final String name;

     /**
      * HIDE CONSTRUCTOR
      */
     protected Single() {
          this.name = null;
     }

     /**
      * HIDE CONSTRUCTOR
      */
     protected Single(String name) {
          this.name = name;
     }

     /**
     * Retrieve name property.
     */
     @Override
     public final String name() {
         return this.name;
     }

     /**
      * Create model builder without base model.
      */
     public static final <T extends NAME> T create() {
         return (T) new Melty();
     }

    /**
     * Mutable Model.
    */
    private static final class Melty extends Single implements NAME {

        /**
         * Modify name property.
        */
        @Override
        public final <T extends Single> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
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
        <T extends Single> T name(String value);
    }
}
