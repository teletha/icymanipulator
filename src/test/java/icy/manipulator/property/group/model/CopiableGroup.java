package icy.manipulator.property.group.model;

import icy.manipulator.property.group.model.CopiableGroup;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Objects;

/**
 * Generated model for {@link CopiableGroupModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class CopiableGroup extends CopiableGroupModel {

    /** The property. */
    protected String name;

    /** The property. */
    protected int size;

    /**
     * HIDE CONSTRUCTOR
     */
    protected CopiableGroup() {
        this.name = null;
        this.size = 0;
    }

    /**
     * Construct with all properties.
     */
    private CopiableGroup(String name, int size) {
        this.name = name;
        this.size = size;
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
        this.name = value;
    }

    /**
     * Return the size property.
     *
     * @return A value of size property.
     */
    @Override
    public final int size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of size property.
     */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of size property to assign.
     */
    private final void setSize(int value) {
        this.size = value;
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CopiableGroup [");
        builder.append("name=").append(name).append(", ");
        builder.append("size=").append(size).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof CopiableGroup == false) {
            return false;
        }

        CopiableGroup other = (CopiableGroup) o;
        if (!Objects.equals(name, other.name)) return false;
        if (size != other.size) return false;
        return true;
    }

    /**
     * Create new {@link CopiableGroup} with the specified property and copy other properties from this model.
     *
     * @param value A new value to assign.
     * @return A created new model instance.
     */
    public CopiableGroup withSize(int value) {
        if (this.size == value) {
            return this;
        }
        return new CopiableGroup(this.name, value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link CopiableGroup}  builder methods.
     */
    public static class Ìnstantiator<Self extends CopiableGroup & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link CopiableGroup} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public Self name(String name, int size) {
            Åssignable o = new Åssignable();
            o.name(name);
            o.size(size);
            return (Self)o;
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
            ((CopiableGroup) this).setName(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {

        /**
         * Assign size property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next size(int value) {
            ((CopiableGroup) this).setSize(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends CopiableGroup> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends CopiableGroup implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Size = "size";
    }
}
