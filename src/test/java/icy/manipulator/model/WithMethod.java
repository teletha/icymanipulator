package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link WithMethodModel}.
 */
public abstract class WithMethod extends WithMethodModel implements Manipulatable<WithMethod> {

     /** The model manipulator for reuse. */
     private static final Manipulator MANIPULATOR = new Manipulator(null);

     /**
      * HIDE CONSTRUCTOR
      */
     protected WithMethod() {
     }

     /**
     * Retrieve property property.
     */
     public String property() {
         return this.property;
     }

     /**
     * Modify property property.
     */
     public WithMethod property(String value) {
         this.property = value;

         return this;
     }

     /**
      * Create model builder without base model.
      */
     public static final WithMethod with() {
         return new Melty(null);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final WithMethod with(WithMethod base) {
         return new Melty(base);
     }

     /**
      * Create model manipulator.
      */
     public static final Manipulator<WithMethod>manipulate() {
         return MANIPULATOR;
     }

     /**
      * Immutable Model.
      */
     private static final class Icy extends WithMethod {

         /**
          * HIDE CONSTRUCTOR
          */
         private Icy(String property) {
                 this.property = property;
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithMethod melt() {
             return new Melty(this);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithMethod property(String value) {
             if (this.property == value) {
                 return this;
             }
             return new Icy(value);
         }

     }
     /**
      * Mutable Model.
      */
     private static final class Melty extends WithMethod {

         /**
          * HIDE CONSTRUCTOR
          */
         private Melty(WithMethod base) {
             if (base != null) {
                 this.property = base.property;
             }
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public WithMethod ice() {
             return new Icy(property);
         }
     }
     /**
      * Model Manipulator.
      */
     public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel,WithMethod> {

         /** The accessor for property property. */
         private static final Accessor PROPERTY = Accessor.<WithMethod, String> of(WithMethod::property,  WithMethod::property);

         /**
          * Construct operator.
          */
         public Manipulator(Accessor<RootModel,WithMethod> parent) {
             super(parent);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,String> property() {
             return parent.then(PROPERTY);
         }

     }
}
