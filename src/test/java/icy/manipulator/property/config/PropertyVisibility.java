package icy.manipulator.property.config;

import icy.manipulator.property.config.PropertyVisibility;
import icy.manipulator.property.config.PropertyVisibilityModel;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link PropertyVisibilityModel}.
 */
@Generated("Icy Manipulator")
class PropertyVisibility extends PropertyVisibilityModel {

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
            Field field = PropertyVisibility.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle packagePrivatePropertyUpdater = updater("packagePrivateProperty");

    /** The final property updater. */
    private static final MethodHandle protectedPropertyUpdater = updater("protectedProperty");

    /** The exposed property. */
    final String packagePrivateProperty;

    /** The exposed property. */
    protected final String protectedProperty;

    /**
     * HIDE CONSTRUCTOR
     */
    protected PropertyVisibility() {
        this.packagePrivateProperty = null;
        this.protectedProperty = null;
    }

    /**
     * Return the packagePrivateProperty property.
     *
     * @return A value of packagePrivateProperty property.
     */
    @Override
    final String packagePrivateProperty() {
        return this.packagePrivateProperty;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of packagePrivateProperty property.
     */
    @SuppressWarnings("unused")
    private final String getPackagePrivateProperty() {
        return this.packagePrivateProperty;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of packagePrivateProperty property to assign.
     */
    private final void setPackagePrivateProperty(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The packagePrivateProperty property requires non-null value.");
        }
        try {
            packagePrivatePropertyUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the protectedProperty property.
     *
     * @return A value of protectedProperty property.
     */
    @Override
    protected final String protectedProperty() {
        return this.protectedProperty;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of protectedProperty property.
     */
    @SuppressWarnings("unused")
    private final String getProtectedProperty() {
        return this.protectedProperty;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of protectedProperty property to assign.
     */
    private final void setProtectedProperty(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The protectedProperty property requires non-null value.");
        }
        try {
            protectedPropertyUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("PropertyVisibility [");
        builder.append("packagePrivateProperty=").append(packagePrivateProperty).append(", ");
        builder.append("protectedProperty=").append(protectedProperty).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(packagePrivateProperty, protectedProperty);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof PropertyVisibility == false) {
            return false;
        }

        PropertyVisibility other = (PropertyVisibility) o;
        if (!Objects.equals(packagePrivateProperty, other.packagePrivateProperty)) return false;
        if (!Objects.equals(protectedProperty, other.protectedProperty)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link PropertyVisibility}  builder methods.
     */
    public static class Ìnstantiator<Self extends PropertyVisibility & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link PropertyVisibility} with the specified packagePrivateProperty property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableProtectedProperty<Self> packagePrivateProperty(String packagePrivateProperty) {
            Åssignable o = new Åssignable();
            o.packagePrivateProperty(packagePrivateProperty);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignablePackagePrivateProperty<Next> {

        /**
         * Assign packagePrivateProperty property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next packagePrivateProperty(String value) {
            ((PropertyVisibility) this).setPackagePrivateProperty(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableProtectedProperty<Next> {

        /**
         * Assign protectedProperty property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next protectedProperty(String value) {
            ((PropertyVisibility) this).setProtectedProperty(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends PropertyVisibility> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignablePackagePrivateProperty, ÅssignableProtectedProperty {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends PropertyVisibility implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String PackagePrivateProperty = "packagePrivateProperty";
        static final String ProtectedProperty = "protectedProperty";
    }
}
