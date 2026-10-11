package icy.manipulator.property.extend.model;

import icy.manipulator.property.base.model.Mixed;
import icy.manipulator.property.extend.model.MixedRequired;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Objects;

/**
 * Generated model for {@link MixedRequiredModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class MixedRequired extends MixedRequiredModel {

    /** The property. */
    protected String zip;

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
        this.zip = value;
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
