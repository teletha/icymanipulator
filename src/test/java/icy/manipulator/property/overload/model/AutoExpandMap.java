package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.AutoExpandMap;
import java.lang.CharSequence;
import java.lang.Integer;
import java.lang.Number;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Generated model for {@link AutoExpandMapModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class AutoExpandMap extends AutoExpandMapModel {

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
            Field field = AutoExpandMap.class.getDeclaredField(name);
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
    public final Map<String, Integer> values;

    /** The exposed property. */
    public final Map<String, Supplier<String>> generics;

    /** The exposed property. */
    public final Map<CharSequence, Number> upperBoundable;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandMap() {
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
    public final Map<String, Integer> values() {
        return this.values;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of values property.
     */
    @SuppressWarnings("unused")
    private final Map<String, Integer> getValues() {
        return this.values;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of values property to assign.
     */
    private final void setValues(Map<String, Integer> value) {
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
    public final Map<String, Supplier<String>> generics() {
        return this.generics;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of generics property.
     */
    @SuppressWarnings("unused")
    private final Map<String, Supplier<String>> getGenerics() {
        return this.generics;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of generics property to assign.
     */
    private final void setGenerics(Map<String, Supplier<String>> value) {
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
    public final Map<CharSequence, Number> upperBoundable() {
        return this.upperBoundable;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of upperBoundable property.
     */
    @SuppressWarnings("unused")
    private final Map<CharSequence, Number> getUpperBoundable() {
        return this.upperBoundable;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of upperBoundable property to assign.
     */
    private final void setUpperBoundable(Map<CharSequence, Number> value) {
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
        StringBuilder builder = new StringBuilder("AutoExpandMap [");
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
        if (o instanceof AutoExpandMap == false) {
            return false;
        }

        AutoExpandMap other = (AutoExpandMap) o;
        if (!Objects.equals(values, other.values)) return false;
        if (!Objects.equals(generics, other.generics)) return false;
        if (!Objects.equals(upperBoundable, other.upperBoundable)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandMap}  builder methods.
     */
    public static class Ìnstantiator<Self extends AutoExpandMap & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(Map<String, Integer> values) {
            Åssignable o = new Åssignable();
            o.values(values);
            return (Self)o;
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1) {
            return values(Map.of(key1, value1));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2) {
            return values(Map.of(key1, value1, key2, value2));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3) {
            return values(Map.of(key1, value1, key2, value2, key3, value3));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7, String key8, Integer value8) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8));
        }

        /**
         * Create new {@link AutoExpandMap} with the specified values property.
         * 
         * @return The next assignable model.
         */
        public Self values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7, String key8, Integer value8, String key9, Integer value9) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9));
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
        default Next values(Map<? extends String, ? extends Integer> value) {
            ((AutoExpandMap) this).setValues((java.util.Map)value);
            return (Next) this;
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1) {
            return values(Map.of(key1, value1));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2) {
            return values(Map.of(key1, value1, key2, value2));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3) {
            return values(Map.of(key1, value1, key2, value2, key3, value3));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7, String key8, Integer value8) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8));
        }

        /**
         * Assign values property.
         * 
         * @return The next assignable model.
         */
        default Next values(String key1, Integer value1, String key2, Integer value2, String key3, Integer value3, String key4, Integer value4, String key5, Integer value5, String key6, Integer value6, String key7, Integer value7, String key8, Integer value8, String key9, Integer value9) {
            return values(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9));
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandMap> {

        /**
         * Assign generics property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next generics(Map<? extends String, ? extends Supplier<String>> value) {
            ((AutoExpandMap) this).setGenerics((java.util.Map)value);
            return (Next) this;
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1) {
            return generics(Map.of(key1, value1));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2) {
            return generics(Map.of(key1, value1, key2, value2));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4, String key5, Supplier<String> value5) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4, String key5, Supplier<String> value5, String key6, Supplier<String> value6) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4, String key5, Supplier<String> value5, String key6, Supplier<String> value6, String key7, Supplier<String> value7) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4, String key5, Supplier<String> value5, String key6, Supplier<String> value6, String key7, Supplier<String> value7, String key8, Supplier<String> value8) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8));
        }

        /**
         * Assign generics property.
         * 
         * @return The next assignable model.
         */
        default Next generics(String key1, Supplier<String> value1, String key2, Supplier<String> value2, String key3, Supplier<String> value3, String key4, Supplier<String> value4, String key5, Supplier<String> value5, String key6, Supplier<String> value6, String key7, Supplier<String> value7, String key8, Supplier<String> value8, String key9, Supplier<String> value9) {
            return generics(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next upperBoundable(Map<? extends CharSequence, ? extends Number> value) {
            ((AutoExpandMap) this).setUpperBoundable((java.util.Map)value);
            return (Next) this;
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1) {
            return upperBoundable(Map.of(key1, value1));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2) {
            return upperBoundable(Map.of(key1, value1, key2, value2));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4, CharSequence key5, Number value5) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4, CharSequence key5, Number value5, CharSequence key6, Number value6) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4, CharSequence key5, Number value5, CharSequence key6, Number value6, CharSequence key7, Number value7) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4, CharSequence key5, Number value5, CharSequence key6, Number value6, CharSequence key7, Number value7, CharSequence key8, Number value8) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8));
        }

        /**
         * Assign upperBoundable property.
         * 
         * @return The next assignable model.
         */
        default Next upperBoundable(CharSequence key1, Number value1, CharSequence key2, Number value2, CharSequence key3, Number value3, CharSequence key4, Number value4, CharSequence key5, Number value5, CharSequence key6, Number value6, CharSequence key7, Number value7, CharSequence key8, Number value8, CharSequence key9, Number value9) {
            return upperBoundable(Map.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9));
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
    private static final class Åssignable extends AutoExpandMap implements ÅssignableAll, ÅssignableÅrbitrary {
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
