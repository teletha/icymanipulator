package icy.manipulator.property.generic.model;

import icy.manipulator.property.generic.model.Wildcard;
import icy.manipulator.property.generic.model.WildcardModel;
import icy.manipulator.property.generic.model.WildcardModel.Member;
import java.lang.CharSequence;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Number;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link WildcardModel}.
 */
@Generated("Icy Manipulator")
public class Wildcard extends WildcardModel {

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

    /** The final property updater. */
    private static final MethodHandle memberTypeUpdater = updater("memberType");

    /** The exposed property. */
    public final Class<? extends Collection> extendType;

    /** The exposed property. */
    public final List<? super Integer> superType;

    /** The exposed property. */
    public final Supplier<?> wildcard;

    /** The exposed property. */
    public final Map<? extends CharSequence, List<Class<? extends Number>>> combine;

    /** The exposed property. */
    public final Class<? extends Member> memberType;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Wildcard() {
        this.extendType = super.extendType();
        this.superType = super.superType();
        this.wildcard = super.wildcard();
        this.combine = super.combine();
        this.memberType = super.memberType();
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
        } catch (UnsupportedOperationException e) {
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
        } catch (UnsupportedOperationException e) {
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
        } catch (UnsupportedOperationException e) {
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
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the memberType property.
     *
     * @return A value of memberType property.
     */
    @Override
    public final Class<? extends Member> memberType() {
        return this.memberType;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of memberType property.
     */
    @SuppressWarnings("unused")
    private final Class<? extends Member> getMemberType() {
        return this.memberType;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of memberType property to assign.
     */
    private final void setMemberType(Class<? extends Member> value) {
        if (value == null) {
            value = super.memberType();
        }
        try {
            memberTypeUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Wildcard [");
        builder.append("extendType=").append(extendType).append(", ");
        builder.append("superType=").append(superType).append(", ");
        builder.append("wildcard=").append(wildcard).append(", ");
        builder.append("combine=").append(combine).append(", ");
        builder.append("memberType=").append(memberType).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(extendType, superType, wildcard, combine, memberType);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Wildcard == false) {
            return false;
        }

        Wildcard other = (Wildcard) o;
        if (!Objects.equals(extendType, other.extendType)) return false;
        if (!Objects.equals(superType, other.superType)) return false;
        if (!Objects.equals(wildcard, other.wildcard)) return false;
        if (!Objects.equals(combine, other.combine)) return false;
        if (!Objects.equals(memberType, other.memberType)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Wildcard}  builder methods.
     */
    public static class Ìnstantiator<Self extends Wildcard & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link Wildcard}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }

        /**
         * Create initialized {@link Wildcard} with extendType property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self extendType(Class<? extends Collection> value) {
            return create().extendType(value);
        }

        /**
         * Create initialized {@link Wildcard} with superType property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self superType(List<? super Integer> value) {
            return create().superType(value);
        }

        /**
         * Create initialized {@link Wildcard} with wildcard property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self wildcard(Supplier<?> value) {
            return create().wildcard(value);
        }

        /**
         * Create initialized {@link Wildcard} with combine property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self combine(Map<? extends CharSequence, List<Class<? extends Number>>> value) {
            return create().combine(value);
        }

        /**
         * Create initialized {@link Wildcard} with memberType property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self memberType(Class<? extends Member> value) {
            return create().memberType(value);
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

        /**
         * Assign memberType property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next memberType(Class<? extends Member> value) {
            ((Wildcard) this).setMemberType(value);
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
        static final String MemberType = "memberType";
    }
}
