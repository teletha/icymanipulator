package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link PersonModel}.
 */
public abstract class Person extends PersonModel implements Manipulatable<Person> {

     /** The model manipulator for reuse. */
     private static final Manipulator MANIPULATOR = new Manipulator(null);

     /**
      * HIDE CONSTRUCTOR
      */
     protected Person() {
     }

     /**
     * Retrieve name property.
     */
     public String name() {
         return this.name;
     }

     /**
     * Modify name property.
     */
     public Person name(String value) {
         this.name = value;

         return this;
     }

     /**
     * Retrieve age property.
     */
     public int age() {
         return this.age;
     }

     /**
     * Modify age property.
     */
     public Person age(int value) {
         this.age = value;

         return this;
     }

     /**
     * Retrieve gender property.
     */
     public Gender gender() {
         return this.gender;
     }

     /**
     * Modify gender property.
     */
     public Person gender(Gender value) {
         this.gender = value;

         return this;
     }

     /**
      * Create model builder without base model.
      */
     public static final Person with() {
         return new Melty(null);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final Person with(Person base) {
         return new Melty(base);
     }

     /**
      * Create model manipulator.
      */
     public static final Manipulator<Person>manipulate() {
         return MANIPULATOR;
     }

     /**
      * Immutable Model.
      */
     private static final class Icy extends Person {

         /**
          * HIDE CONSTRUCTOR
          */
         private Icy(String name, int age, Gender gender) {
                 this.name = name;
                 this.age = age;
                 this.gender = gender;
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public Person melt() {
             return new Melty(this);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public Person name(String value) {
             if (this.name == value) {
                 return this;
             }
             return new Icy(value, this.age, this.gender);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public Person age(int value) {
             if (this.age == value) {
                 return this;
             }
             return new Icy(this.name, value, this.gender);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public Person gender(Gender value) {
             if (this.gender == value) {
                 return this;
             }
             return new Icy(this.name, this.age, value);
         }

     }
     /**
      * Mutable Model.
      */
     private static final class Melty extends Person {

         /**
          * HIDE CONSTRUCTOR
          */
         private Melty(Person base) {
             if (base != null) {
                 this.name = base.name;
                 this.age = base.age;
                 this.gender = base.gender;
             }
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public Person ice() {
             return new Icy(name, age, gender);
         }
     }
     /**
      * Model Manipulator.
      */
     public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel,Person> {

         /** The accessor for name property. */
         private static final Accessor NAME = Accessor.<Person, String> of(Person::name,  Person::name);

         /** The accessor for age property. */
         private static final Accessor AGE = Accessor.<Person, Integer> of(Person::age,  Person::age);

         /** The accessor for gender property. */
         private static final Accessor GENDER = Accessor.<Person, Gender> of(Person::gender,  Person::gender);

         /**
          * Construct operator.
          */
         public Manipulator(Accessor<RootModel,Person> parent) {
             super(parent);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,String> name() {
             return parent.then(NAME);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> age() {
             return parent.then(AGE);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Gender> gender() {
             return parent.then(GENDER);
         }

     }
}
