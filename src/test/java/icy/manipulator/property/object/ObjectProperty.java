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
     ObjectProperty name(String value) {
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
     ObjectProperty age(int value) {
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
     public static final MeltyObjectProperty with() {
         return new MeltyObjectProperty(null);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final MeltyObjectProperty with(ObjectProperty base) {
         return new MeltyObjectProperty(base);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final ObjectProperty with(UnaryOperator<MeltyObjectProperty> base) {
         return base.apply(new MeltyObjectProperty(null));
     }

     /**
      * Mutable {@link ObjectProperty} Model.
      */
     public static final class MeltyObjectProperty extends ObjectProperty {

         /**
          * HIDE CONSTRUCTOR
          */
         private MeltyObjectProperty(ObjectProperty base) {
             if (base != null) {
                 super.name(base.name);
                 super.age(base.age);
             }
         }

         /**
          * Create immutable model.
          */
         public final ObjectProperty ice() {
             return new ObjectProperty(name, age);
         }

         /**
         * Expose name setter.
         */
         public final MeltyObjectProperty name(String value) {
             super.name(value);
             return this;
         }

         /**
         * Expose age setter.
         */
         public final MeltyObjectProperty age(int value) {
             super.age(value);
             return this;
         }

     }
}
