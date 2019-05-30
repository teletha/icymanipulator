package icy.manipulator.property.model;

import icy.manipulator.property.model.InterfaceArbitrary;
import icy.manipulator.property.model.InterfaceArbitraryModel;
import java.lang.Override;
import java.lang.String;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link InterfaceArbitraryModel}.
 */
@Generated("Icy Manipulator")
public abstract class InterfaceArbitrary implements InterfaceArbitraryModel {

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
            Field field = InterfaceArbitrary.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle optionalUpdater = updater("optional");

    /** The exposed property. */
    public final String optional;

    /**
     * HIDE CONSTRUCTOR
     */
    protected InterfaceArbitrary() {
        this.optional = InterfaceArbitraryModel.super.optional();
    }

    /**
     * Return the optional property.
     *
     * @return A value of optional property.
     */
    @Override
    public final String optional() {
        return this.optional;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optional property.
     */
    @SuppressWarnings("unused")
    private final String getOptional() {
        return this.optional;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optional property to assign.
     */
    private final void setOptional(String value) {
        if (value == null) {
            value = InterfaceArbitraryModel.super.optional();
        }
        try {
            optionalUpdater.invoke(this, value);
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
        StringJoiner builder = new StringJoiner(", ", "InterfaceArbitrary [", "]");
        builder.add("optional=" + optional);
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(optional);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link InterfaceArbitrary}  builder methods.
     */
    public static final class Ìnstantiator<Self extends InterfaceArbitrary & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link InterfaceArbitrary}.
         */
        public final Self create() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends InterfaceArbitrary> {

        /**
         * Assign optional property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optional(String value) {
            ((InterfaceArbitrary) this).setOptional(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends InterfaceArbitrary implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Optional = "optional";
    }
}
