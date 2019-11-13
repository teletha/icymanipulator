package icy.manipulator.property.copy.model;

import icy.manipulator.property.copy.model.Copy;
import icy.manipulator.property.copy.model.CopySub;
import icy.manipulator.property.copy.model.CopySubModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link CopySubModel}.
 */
@Generated("Icy Manipulator")
public abstract class CopySub extends CopySubModel {

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
    private static final MethodHandle updater(String name)  {
        try {
            Field field = CopySub.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle addressUpdater = updater("address");

    /** The exposed property. */
    public final String address;

    /**
     * HIDE CONSTRUCTOR
     */
    protected CopySub() {
        this.address = null;
    }

    /**
     * Return the address property.
     *
     * @return A value of address property.
     */
    @Override
    public final String address() {
        return this.address;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of address property.
     */
    @SuppressWarnings("unused")
    private final String getAddress() {
        return this.address;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of address property to assign.
     */
    private final void setAddress(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The address property requires non-null value.");
        }
        try {
            addressUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("CopySub [");
        builder.append("name=").append(name).append(", ");
        builder.append("age=").append(age).append(", ");
        builder.append("address=").append(address).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof CopySub == false) {
            return false;
        }

        CopySub other = (CopySub) o;
        if (!Objects.equals(name, other.name)) return false;
        if (age != other.age) return false;
        if (!Objects.equals(address, other.address)) return false;
        return true;
    }

    /**
     * Create new {@link CopySub} with the specified property and copy other properties from this model.
     *
     * @param value A new value to assign.
     * @return A created new model instance.
     */
    public CopySub withAge(int value) {
        if (this.age == value) {
            return this;
        }
        return with.name(this.name).age(value).address(this.address);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link CopySub}  builder methods.
     */
    public static class Ìnstantiator<Self extends CopySub & ÅssignableÅrbitrary<Self>> extends icy.manipulator.property.copy.model.Copy.Ìnstantiator {

        /**
         * Create new {@link CopySub} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableAge<ÅssignableAddress<Self>> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAddress<Next> {

        /**
         * Assign address property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next address(String value) {
            ((CopySub) this).setAddress(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends CopySub> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableAddress, Copy.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends CopySub implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Address = "address";
    }
}
