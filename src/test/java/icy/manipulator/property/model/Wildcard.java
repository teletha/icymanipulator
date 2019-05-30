package icy.manipulator.property.model;

import icy.manipulator.property.model.Wildcard;
import icy.manipulator.property.model.WildcardModel;
import java.lang.CharSequence;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Number;
import java.lang.Override;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Supplier;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link WildcardModel}.
 */
@Generated("Icy Manipulator")
public abstract class Wildcard extends WildcardModel {

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
            Field field = Wildcard.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle extendTypeUpdater = updater("extendType");

    /** The final property updater. */
    private static final MethodHandle superTypeUpdater = updater("superType");

    /** The final property updater. */
    private static final MethodHandle wildcardUpdater = updater("wildcard");

    /** The final property updater. */
    private static final MethodHandle combineUpdater = updater("combine");

    /** The exposed property. */
    public final Class<? extends Collection> extendType;

    /** The exposed property. */
    public final List<? super Integer> superType;

    /** The exposed property. */
    public final Supplier<?> wildcard;

    /** The exposed property. */
    public final Map<? extends CharSequence, List<Class<? extends Number>>> combine;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Wildcard() {
        this.extendType = super.extendType();
        this.superType = super.superType();
        this.wildcard = super.wildcard();
        this.combine = super.combine();
    }

    /**
     * Return the extendType property.
     *
     * @return A value of extendType property.
     */
    @Override
    public final Class<? extends Collection> extendType() {
        return this.extendType;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of extendType property.
     */
    @SuppressWarnings("unused")
    private final Class<? extends Collection> getExtendType() {
        return this.extendType;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of extendType property to assign.
     */
    private final void setExtendType(Class<? extends Collection> value) {
        if (value == null) {
            value = super.extendType();
        }
        try {
            extendTypeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the superType property.
     *
     * @return A value of superType property.
     */
    @Override
    public final List<? super Integer> superType() {
        return this.superType;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of superType property.
     */
    @SuppressWarnings("unused")
    private final List<? super Integer> getSuperType() {
        return this.superType;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of superType property to assign.
     */
    private final void setSuperType(List<? super Integer> value) {
        if (value == null) {
            value = super.superType();
        }
        try {
            superTypeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the wildcard property.
     *
     * @return A value of wildcard property.
     */
    @Override
    public final Supplier<?> wildcard() {
        return this.wildcard;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of wildcard property.
     */
    @SuppressWarnings("unused")
    private final Supplier<?> getWildcard() {
        return this.wildcard;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of wildcard property to assign.
     */
    private final void setWildcard(Supplier<?> value) {
        if (value == null) {
            value = super.wildcard();
        }
        try {
            wildcardUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the combine property.
     *
     * @return A value of combine property.
     */
    @Override
    public final Map<? extends CharSequence, List<Class<? extends Number>>> combine() {
        return this.combine;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of combine property.
     */
    @SuppressWarnings("unused")
    private final Map<? extends CharSequence, List<Class<? extends Number>>> getCombine() {
        return this.combine;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of combine property to assign.
     */
    private final void setCombine(Map<? extends CharSequence, List<Class<? extends Number>>> value) {
        if (value == null) {
            value = super.combine();
        }
        try {
            combineUpdater.invoke(this, value);
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
        StringJoiner builder = new StringJoiner(", ", "Wildcard [", "]");
        builder.add("extendType=" + extendType);
        builder.add("superType=" + superType);
        builder.add("wildcard=" + wildcard);
        builder.add("combine=" + combine);
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(extendType, superType, wildcard, combine);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Wildcard}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Wildcard & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link Wildcard}.
         */
        public final Self create() {
            return (Self) new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Wildcard> {

        /**
         * Assign extendType property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next extendType(Class<? extends Collection> value) {
            ((Wildcard) this).setExtendType(value);
            return (Next) this;
        }

        /**
         * Assign superType property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next superType(List<? super Integer> value) {
            ((Wildcard) this).setSuperType(value);
            return (Next) this;
        }

        /**
         * Assign wildcard property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next wildcard(Supplier<?> value) {
            ((Wildcard) this).setWildcard(value);
            return (Next) this;
        }

        /**
         * Assign combine property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next combine(Map<? extends CharSequence, List<Class<? extends Number>>> value) {
            ((Wildcard) this).setCombine(value);
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
    private static final class Åssignable extends Wildcard implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String ExtendType = "extendType";
        static final String SuperType = "superType";
        static final String Wildcard = "wildcard";
        static final String Combine = "combine";
    }
}
