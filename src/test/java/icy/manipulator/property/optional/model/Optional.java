package icy.manipulator.property.optional.model;

import icy.manipulator.property.optional.model.Optional;
import icy.manipulator.property.optional.model.OptionalModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OptionalModel}.
 */
@Generated("Icy Manipulator")
public abstract class Optional implements OptionalModel {

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
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = OptionalModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle name$927011984= invoker("name", String.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Optional.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The exposed property. */
    public final java.util.Optional<String> name;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Optional() {
        this.name = null;
    }

    /**
     * Return the name property.
     *
     * @return A value of name property.
     */
    @Override
    public final java.util.Optional<String> name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of name property.
     */
    @SuppressWarnings("unused")
    private final java.util.Optional<String> getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of name property to assign.
     */
    private final void setName(java.util.Optional<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("The name property requires non-null value.");
        }
        try {
            nameUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Optional [");
        builder.append("name=").append(name).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Optional == false) {
            return false;
        }

        Optional other = (Optional) o;
        if (!Objects.equals(name, other.name)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Optional}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Optional & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Optional} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final Self name(java.util.Optional<String> name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return (Self)o;
        }

        /**
         * Create new {@link Optional} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final Self name(String value) {
            Åssignable o = new Åssignable();
            o.name(value);
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
        default Next name(java.util.Optional<String> value) {
            ((Optional) this).setName(value);
            return (Next) this;
        }

        /**
         * Assign name property.
         * 
         * @return The next assignable model.
         */
        default Next name(String value) {
            return name(java.util.Optional.of(value));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Optional> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Optional implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
    }
}
