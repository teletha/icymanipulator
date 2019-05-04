package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link WithInnerClassModel}.
 */
public abstract class WithInnerClass extends WithInnerClassModel implements Manipulatable<WithInnerClass> {

     /** The model manipulator for reuse. */
     private static final Manipulator MANIPULATOR = new Manipulator(null);

     /**
      * HIDE CONSTRUCTOR
      */
     protected WithInnerClass() {
     }

     /**
     * Retrieve property property.
     */
     public Inner property() {
         return this.property;
     }

     /**
     * Modify property property.
     */
     public WithInnerClass property(Inner value) {
         this.property = value;

         return this;
     }

     /**
      * Create model builder without base model.
      */
     public static final WithInnerClass with() {
         return new Melty(null);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final WithInnerClass with(WithInnerClass base) {
         return new Melty(base);
     }

     /**
      * Create model manipulator.
      */
     public static final Manipulator<WithInnerClass>manipulate() {
         return MANIPULATOR;
     }

     /**
      * Immutable Model.
      */
     private static final class Icy extends WithInnerClass {

         /**
          * HIDE CONSTRUCTOR
          */
         private Icy(Inner property) {
                 this.property = property;
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithInnerClass melt() {
             return new Melty(this);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithInnerClass property(Inner value) {
             if (this.property == value) {
                 return this;
             }
             return new Icy(value);
         }

     }
     /**
      * Mutable Model.
      */
     private static final class Melty extends WithInnerClass {

         /**
          * HIDE CONSTRUCTOR
          */
         private Melty(WithInnerClass base) {
             if (base != null) {
                 this.property = base.property;
             }
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithInnerClass ice() {
             return new Icy(property);
         }
     }
     /**
      * Model Manipulator.
      */
     public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel,WithInnerClass> {

         /** The accessor for property property. */
         private static final Accessor PROPERTY = Accessor.<WithInnerClass, Inner> of(WithInnerClass::property,  WithInnerClass::property);

         /**
          * Construct operator.
          */
         public Manipulator(Accessor<RootModel,WithInnerClass> parent) {
             super(parent);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Inner> property() {
             return parent.then(PROPERTY);
         }

     }
}
