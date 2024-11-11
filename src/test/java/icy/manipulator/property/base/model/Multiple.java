package icy.manipulator.property.base.model;

import icy.manipulator.property.base.model.Multiple;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Generated model for {@link MultipleModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class Multiple extends MultipleModel {

     /** Determines if the execution environment is a Native Image of GraalVM. */
    private static final boolean NATIVE = "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"));

    /**
     * Deceive complier that the specified checked exception is unchecked exception.
     *
     * @param <T> A dummy type for {@link RuntimeException}.
     * @param throwable Any error.
     * @return A runtime error.
     * @throws T Dummy error to deceive compiler.
     */
    private static final <T extends Throwable> T quiet(Throwable throwable) throws T {
        throw (T) throwable;
    }

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final Field updater(String name)  {
        try {
            Field field = Multiple.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Create fast property updater.
     *
     * @param field A target field.
     * @return A fast property updater.
     */
    private static final MethodHandle handler(Field field)  {
        try {
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final Field nameField = updater("name");

    /** The fast final property updater. */
    private static final MethodHandle nameUpdater = handler(nameField);

    /** The final property updater. */
    private static final Field standField = updater("stand");

    /** The fast final property updater. */
    private static final MethodHandle standUpdater = handler(standField);

    /** The final property updater. */
    private static final Field ageField = updater("age");

    /** The fast final property updater. */
    private static final MethodHandle ageUpdater = handler(ageField);

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /** The exposed property. */
    public final int age;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Multiple() {
        this.name = null;
        this.stand = null;
        this.age = 0;
    }

    /**
     * Return the name property.
     *
     * @return A value of name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of name property.
     */
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of name property to assign.
     */
    private final void setName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The name property requires non-null value.");
        }
        try {
            nameUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the stand property.
     *
     * @return A value of stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of stand property.
     */
    @SuppressWarnings("unused")
    private final String getStand() {
        return this.stand;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of stand property to assign.
     */
    private final void setStand(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The stand property requires non-null value.");
        }
        try {
            standUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the age property.
     *
     * @return A value of age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of age property.
     */
    @SuppressWarnings("unused")
    private final int getAge() {
        return this.age;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of age property to assign.
     */
    private final void setAge(int value) {
        try {
            if (NATIVE) {
                ageField.setInt(this, (int) value);
            } else {
                ageUpdater.invoke(this, value);
            }
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Multiple [");
        builder.append("name=").append(name).append(", ");
        builder.append("stand=").append(stand).append(", ");
        builder.append("age=").append(age).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, stand, age);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Multiple == false) {
            return false;
        }

        Multiple other = (Multiple) o;
        if (!Objects.equals(name, other.name)) return false;
        if (!Objects.equals(stand, other.stand)) return false;
        if (age != other.age) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Multiple}  builder methods.
     */
    public static class Ìnstantiator<Self extends Multiple & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Multiple} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableStand<ÅssignableAge<Self>> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /**
         * Assign name property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next name(String value) {
            ((Multiple) this).setName(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableStand<Next> {

        /**
         * Assign stand property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next stand(String value) {
            ((Multiple) this).setStand(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAge<Next> {

        /**
         * Assign age property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next age(int value) {
            ((Multiple) this).setAge(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Multiple> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableStand, ÅssignableAge {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Multiple implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
        static final String Age = "age";
    }
}