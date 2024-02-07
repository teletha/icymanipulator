package icy.manipulator.property.group.model;

import icy.manipulator.property.group.model.EnumGroupSubclass;
import java.lang.Override;
import java.lang.StringBuilder;
import java.util.Objects;

/**
 * Generated model for {@link EnumGroupSubclassModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class EnumGroupSubclass extends EnumGroupSubclassModel {

    /**
     * HIDE CONSTRUCTOR
     */
    protected EnumGroupSubclass() {
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("EnumGroupSubclass [");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash();
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof EnumGroupSubclass == false) {
            return false;
        }

        EnumGroupSubclass other = (EnumGroupSubclass) o;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link EnumGroupSubclass}  builder methods.
     */
    public static class Ìnstantiator<Self extends EnumGroupSubclass & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link EnumGroupSubclass}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends EnumGroupSubclass> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends EnumGroupSubclass implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
    }
}
