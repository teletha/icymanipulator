package icy.manipulator.property.extend.model;

import icy.manipulator.property.extend.model.ArbitraryRequired;
import icy.manipulator.property.extend.model.ArbitraryRequiredModel;
import icy.manipulator.property.model.Arbitrary;
import java.lang.Override;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ArbitraryRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class ArbitraryRequired extends ArbitraryRequiredModel {

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
            Field field = ArbitraryRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle idUpdater = updater("id");

    /** The exposed property. */
    public final long id;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ArbitraryRequired() {
        this.id = 0L;
    }

    /**
     * Return the id property.
     *
     * @return A value of id property.
     */
    @Override
    public final long id() {
        return this.id;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of id property.
     */
    @SuppressWarnings("unused")
    private final long getId() {
        return this.id;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of id property to assign.
     */
    private final void setId(long value) {
        try {
            idUpdater.invoke(this, value);
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
        StringJoiner builder = new StringJoiner(", ", "ArbitraryRequired [", "]");
        builder.add("id=" + id);
        builder.add("optionNum=" + optionNum);
        builder.add("optionComment=" + optionComment);
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, optionNum, optionComment);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ArbitraryRequired == false) {
            return false;
        }

        ArbitraryRequired other = (ArbitraryRequired) o;
        if (id != other.id) {
            return false;
        }
        if (optionNum != other.optionNum) {
            return false;
        }
        if (!Objects.equals(optionComment, other.optionComment)) {
            return false;
        }
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ArbitraryRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends ArbitraryRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link ArbitraryRequired} with the specified id property.
         * 
         * @return The next assignable model.
         */
        public final Self id(long id) {
            Åssignable o = new Åssignable();
            o.id(id);
            return (Self)o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableId<Next> {

        /**
         * Assign id property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next id(long value) {
            ((ArbitraryRequired) this).setId(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends ArbitraryRequired> extends Arbitrary.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableId, Arbitrary.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends ArbitraryRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Id = "id";
    }
}
