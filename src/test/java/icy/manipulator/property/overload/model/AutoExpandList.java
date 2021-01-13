package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.AutoExpandList;
import icy.manipulator.property.overload.model.AutoExpandListModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link AutoExpandListModel}.
 */
@Generated("Icy Manipulator")
public class AutoExpandList extends AutoExpandListModel {

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
            Field field = AutoExpandList.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valuesUpdater = updater("values");

    /** The final property updater. */
    private static final MethodHandle genericsUpdater = updater("generics");

    /** The exposed property. */
    public final List<String> values;

    /** The exposed property. */
    public final List<Supplier<String>> generics;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandList() {
        this.values = null;
        this.generics = super.generics();
    }

    /**
     * Return the values property.
     *
     * @return A value of values property.
     */
    @Override
    public final List<String> values() {
        return this.values;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of values property.
     */
    @SuppressWarnings("unused")
    private final List<String> getValues() {
        return this.values;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of values property to assign.
     */
    private final void setValues(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("The values property requires non-null value.");
        }
        try {
            valuesUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the generics property.
     *
     * @return A value of generics property.
     */
    @Override
    public final List<Supplier<String>> generics() {
        return this.generics;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of generics property.
     */
    @SuppressWarnings("unused")
    private final List<Supplier<String>> getGenerics() {
        return this.generics;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of generics property to assign.
     */
    private final void setGenerics(List<Supplier<String>> value) {
        if (value == null) {
            value = super.generics();
        }
        try {
            genericsUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("AutoExpandList [");
        builder.append("values=").append(values).append(", ");
        builder.append("generics=").append(generics).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(values, generics);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof AutoExpandList == false) {
            return false;
        }

        AutoExpandList other = (AutoExpandList) o;
        if (!Objects.equals(values, other.values)) return false;
        if (!Objects.equals(generics, other.generics)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandList}  builder methods.
     */
    public static class Ìnstantiator<Self extends AutoExpandList & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandList} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(List<String> values) {
            Åssignable o = new Åssignable();
            o.values(values);
            return (Self)o;
        }

        /**
         * Create new {@link AutoExpandList} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String... values) {
            return values(List.of(values));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValues<Next> {

        /**
         * Assign values property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next values(List<String> value) {
            ((AutoExpandList) this).setValues(value);
            return (Next) this;
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String... values) {
            return values(List.of(values));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandList> {

        /**
         * Assign generics property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next generics(List<Supplier<String>> value) {
            ((AutoExpandList) this).setGenerics(value);
            return (Next) this;
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(Supplier<String>... values) {
            return generics(List.of(values));
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableValues {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends AutoExpandList implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Values = "values";
        static final String Generics = "generics";
    }
}
