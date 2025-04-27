package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.AutoExpandSet;
import java.lang.CharSequence;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Generated model for {@link AutoExpandSetModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class AutoExpandSet extends AutoExpandSetModel {

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
    private static final Field updater(String name)  {
        try {
            Field field = AutoExpandSet.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Create fast property updater.
     *
     * @param field A target field.
     * @return A fast property updater.
     */
    private static final MethodHandle handler(Field field)  {
        try {
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final Field valuesField = updater("values");

    /** The fast final property updater. */
    private static final MethodHandle valuesUpdater = handler(valuesField);

    /** The final property updater. */
    private static final Field genericsField = updater("generics");

    /** The fast final property updater. */
    private static final MethodHandle genericsUpdater = handler(genericsField);

    /** The final property updater. */
    private static final Field upperBoundableField = updater("upperBoundable");

    /** The fast final property updater. */
    private static final MethodHandle upperBoundableUpdater = handler(upperBoundableField);

    /** The exposed property. */
    public final Set<String> values;

    /** The exposed property. */
    public final Set<Supplier<String>> generics;

    /** The exposed property. */
    public final Set<CharSequence> upperBoundable;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandSet() {
        this.values = null;
        this.generics = super.generics();
        this.upperBoundable = super.upperBoundable();
    }

    /**
     * Return the values property.
     *
     * @return A value of values property.
     */
    @Override
    public final Set<String> values() {
        return this.values;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of values property.
     */
    @SuppressWarnings("unused")
    private final Set<String> getValues() {
        return this.values;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of values property to assign.
     */
    private final void setValues(Set<String> value) {
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
    public final Set<Supplier<String>> generics() {
        return this.generics;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of generics property.
     */
    @SuppressWarnings("unused")
    private final Set<Supplier<String>> getGenerics() {
        return this.generics;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of generics property to assign.
     */
    private final void setGenerics(Set<Supplier<String>> value) {
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
     * Return the upperBoundable property.
     *
     * @return A value of upperBoundable property.
     */
    @Override
    public final Set<CharSequence> upperBoundable() {
        return this.upperBoundable;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of upperBoundable property.
     */
    @SuppressWarnings("unused")
    private final Set<CharSequence> getUpperBoundable() {
        return this.upperBoundable;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of upperBoundable property to assign.
     */
    private final void setUpperBoundable(Set<CharSequence> value) {
        if (value == null) {
            value = super.upperBoundable();
        }
        try {
            upperBoundableUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("AutoExpandSet [");
        builder.append("values=").append(values).append(", ");
        builder.append("generics=").append(generics).append(", ");
        builder.append("upperBoundable=").append(upperBoundable).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(values, generics, upperBoundable);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof AutoExpandSet == false) {
            return false;
        }

        AutoExpandSet other = (AutoExpandSet) o;
        if (!Objects.equals(values, other.values)) return false;
        if (!Objects.equals(generics, other.generics)) return false;
        if (!Objects.equals(upperBoundable, other.upperBoundable)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandSet}  builder methods.
     */
    public static class Ìnstantiator<Self extends AutoExpandSet & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandSet} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(Set<String> values) {
            Åssignable o = new Åssignable();
            o.values(values);
            return (Self)o;
        }

        /**
         * Create new {@link AutoExpandSet} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String... values) {
            return values(Set.of(values));
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
        default Next values(Set<? extends String> value) {
            ((AutoExpandSet) this).setValues((java.util.Set)value);
            return (Next) this;
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String... values) {
            return values(Set.of(values));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandSet> {

        /**
         * Assign generics property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next generics(Set<? extends Supplier<String>> value) {
            ((AutoExpandSet) this).setGenerics((java.util.Set)value);
            return (Next) this;
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(Supplier<String>... values) {
            return generics(Set.of(values));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next upperBoundable(Set<? extends CharSequence> value) {
            ((AutoExpandSet) this).setUpperBoundable((java.util.Set)value);
            return (Next) this;
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence... values) {
            return upperBoundable(Set.of(values));
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
    private static final class Åssignable extends AutoExpandSet implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Values = "values";
        static final String Generics = "generics";
        static final String UpperBoundable = "upperBoundable";
    }
}
