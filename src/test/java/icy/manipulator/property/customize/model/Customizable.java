package icy.manipulator.property.customize.model;

import icy.manipulator.property.customize.model.Customizable;
import icy.manipulator.property.customize.model.CustomizableModel;
import icy.manipulator.property.customize.model.CustomizableModel.Customizer;
import icy.manipulator.property.customize.model.CustomizableModel.SubCustomizer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link CustomizableModel}.
 */
@Generated("Icy Manipulator")
public abstract class Customizable extends CustomizableModel {

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
            Field field = Customizable.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The exposed property. */
    public final String name;

    /** The property customizer. */
    private final Customizer<String> nameCustomizer = new Customizer<String>() {

        @Override
        public String get() {
            return name;
        }
    };

    /** The exposed property. */
    public final String value;

    /** The property customizer. */
    private final SubCustomizer valueCustomizer = new SubCustomizer() {

        @Override
        public String get() {
            return value;
        }
    };

    /**
     * HIDE CONSTRUCTOR
     */
    protected Customizable() {
        this.name = null;
        this.value = null;
    }

    /**
     * Return name.
     *  
     *  @return A name.
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
        try {
            nameUpdater.invoke(this, value);
            nameCustomizer.accept(this.name);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Get value by getter.
     *  
     *  @return
     */
    public final String nameByGetter() {
        return nameCustomizer.$ByGetter();
    }

    /**
     * Get value by setter.
     *  
     *  @return
     */
    public final String nameBySetter() {
        return nameCustomizer.$BySetter();
    }

    /**
     * Get value as {@link Supplier}.
     *  
     *  @return
     */
    public final Supplier<String> nameByGetterAsSupplier() {
        return nameCustomizer.$ByGetterAsSupplier();
    }

    /**
     * Return name.
     *  
     *  @return A name.
     */
    @Override
    public final String value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final String getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The value property requires non-null value.");
        }
        try {
            valueUpdater.invoke(this, value);
            valueCustomizer.accept(this.value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Get value on sub.
     *  
     *  @return
     */
    public final String valueFromSub() {
        return valueCustomizer.$FromSub();
    }

    /**
     * Get value by getter.
     *  
     *  @return
     */
    public final String valueByGetter() {
        return valueCustomizer.$ByGetter();
    }

    /**
     * Get value by setter.
     *  
     *  @return
     */
    public final String valueBySetter() {
        return valueCustomizer.$BySetter();
    }

    /**
     * Get value as {@link Supplier}.
     *  
     *  @return
     */
    public final Supplier<String> valueByGetterAsSupplier() {
        return valueCustomizer.$ByGetterAsSupplier();
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Customizable [");
        builder.append("name=").append(name).append(", ");
        builder.append("value=").append(value).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Customizable == false) {
            return false;
        }

        Customizable other = (Customizable) o;
        if (!Objects.equals(name, other.name)) return false;
        if (!Objects.equals(value, other.value)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Customizable}  builder methods.
     */
    public static class Ìnstantiator<Self extends Customizable & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Customizable} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableValue<Self> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
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
            ((Customizable) this).setName(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValue<Next> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(String value) {
            ((Customizable) this).setValue(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Customizable> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableValue {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Customizable implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Value = "value";
    }
}
