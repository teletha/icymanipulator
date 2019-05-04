package icy.manipulator.property.object;

import icy.manipulator.Manipulatable;
import java.util.function.UnaryOperator;

/**
 * {@link Manipulatable} model for {@link ObjectPropertyModel}.
 */
public  class ObjectProperty extends ObjectPropertyModel {

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle nameUpdater = icy.manipulator.Manipulator.updater(ObjectProperty.class, "name");

     /** The final property updater. */
     private static final java.lang.invoke.MethodHandle ageUpdater = icy.manipulator.Manipulator.updater(ObjectProperty.class, "age");

     /** The exposed property. */
     public final String name;

     /** The exposed property. */
     public final int age;

     /**
      * HIDE CONSTRUCTOR
      */
     protected ObjectProperty() {
          this.name = null;
          this.age = 0;
     }

     /**
      * HIDE CONSTRUCTOR
      */
     protected ObjectProperty(String name, int age) {
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
     * Modify name property.
     */
     public final ObjectProperty name(String value) {
         try {
             nameUpdater.invoke(this, value);
         } catch (Throwable e) {
             throw new Error(e);
         }

         return this;
     }

     /**
     * Retrieve age property.
     */
     @Override
     public final int age() {
         return this.age;
     }

     /**
     * Modify age property.
     */
     public final ObjectProperty age(int value) {
         try {
             ageUpdater.invoke(this, value);
         } catch (Throwable e) {
             throw new Error(e);
         }

         return this;
     }

     /**
      * Create model builder without base model.
      */
     public static final ObjectProperty with() {
         return new ObjectProperty();
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final ObjectProperty with(ObjectProperty base) {
         return new ObjectProperty();
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final ObjectProperty with(UnaryOperator<ObjectProperty> base) {
         return base.apply(new ObjectProperty());
     }

}
