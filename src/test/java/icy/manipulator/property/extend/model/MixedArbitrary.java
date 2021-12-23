package icy.manipulator.property.extend.model;

import icy.manipulator.property.base.model.Mixed;
import icy.manipulator.property.extend.model.MixedArbitrary;
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
 * Generated model for {@link MixedArbitraryModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class MixedArbitrary extends MixedArbitraryModel {

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
            Field field = MixedArbitrary.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle optionZipUpdater = updater("optionZip");

    /** The exposed property. */
    public final String optionZip;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixedArbitrary() {
        this.optionZip = super.optionZip();
    }

    /**
     * Return the optionZip property.
     *
     * @return A value of optionZip property.
     */
    @Override
    public final String optionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionZip property.
     */
    @SuppressWarnings("unused")
    private final String getOptionZip() {
        return this.optionZip;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionZip property to assign.
     */
    private final void setOptionZip(String value) {
        if (value == null) {
            value = super.optionZip();
        }
        try {
            optionZipUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("MixedArbitrary [");
        builder.append("name=").append(name).append(", ");
        builder.append("age=").append(age).append(", ");
        builder.append("optionAddress=").append(optionAddress).append(", ");
        builder.append("optionCommnet=").append(optionCommnet).append(", ");
        builder.append("optionZip=").append(optionZip).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, optionAddress, optionCommnet, optionZip);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MixedArbitrary == false) {
            return false;
        }

        MixedArbitrary other = (MixedArbitrary) o;
        if (!Objects.equals(name, other.name)) return false;
        if (age != other.age) return false;
        if (!Objects.equals(optionAddress, other.optionAddress)) return false;
        if (!Objects.equals(optionCommnet, other.optionCommnet)) return false;
        if (!Objects.equals(optionZip, other.optionZip)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link MixedArbitrary}  builder methods.
     */
    public static class Ìnstantiator<Self extends MixedArbitrary & ÅssignableÅrbitrary<Self>> extends icy.manipulator.property.base.model.Mixed.Ìnstantiator {

        /**
         * Create new {@link MixedArbitrary} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableAge<Self> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MixedArbitrary> extends Mixed.ÅssignableÅrbitrary<Next> {

        /**
         * Assign optionZip property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionZip(String value) {
            ((MixedArbitrary) this).setOptionZip(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends Mixed.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixedArbitrary implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String OptionZip = "optionZip";
    }
}
