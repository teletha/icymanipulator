package icy.manipulator.property.extend.model;

import icy.manipulator.property.base.model.Mixed;
import icy.manipulator.property.extend.model.MixedRequired;
import icy.manipulator.property.extend.model.MixedRequiredModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixedRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class MixedRequired extends MixedRequiredModel {

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
            Field field = MixedRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle zipUpdater = updater("zip");

    /** The exposed property. */
    public final String zip;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixedRequired() {
        this.zip = null;
    }

    /**
     * Return the zip property.
     *
     * @return A value of zip property.
     */
    @Override
    public final String zip() {
        return this.zip;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of zip property.
     */
    @SuppressWarnings("unused")
    private final String getZip() {
        return this.zip;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of zip property to assign.
     */
    private final void setZip(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The zip property requires non-null value.");
        }
        try {
            zipUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("MixedRequired [");
        builder.append("name=").append(name).append(", ");
        builder.append("age=").append(age).append(", ");
        builder.append("zip=").append(zip).append(", ");
        builder.append("optionAddress=").append(optionAddress).append(", ");
        builder.append("optionCommnet=").append(optionCommnet).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, zip, optionAddress, optionCommnet);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MixedRequired == false) {
            return false;
        }

        MixedRequired other = (MixedRequired) o;
        if (!Objects.equals(name, other.name)) return false;
        if (age != other.age) return false;
        if (!Objects.equals(zip, other.zip)) return false;
        if (!Objects.equals(optionAddress, other.optionAddress)) return false;
        if (!Objects.equals(optionCommnet, other.optionCommnet)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link MixedRequired}  builder methods.
     */
    public static class Ìnstantiator<Self extends MixedRequired & ÅssignableÅrbitrary<Self>> extends icy.manipulator.property.base.model.Mixed.Ìnstantiator {

        /**
         * Create new {@link MixedRequired} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableAge<ÅssignableZip<Self>> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableZip<Next> {

        /**
         * Assign zip property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next zip(String value) {
            ((MixedRequired) this).setZip(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedRequired> extends Mixed.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableZip, Mixed.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixedRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Zip = "zip";
    }
}
