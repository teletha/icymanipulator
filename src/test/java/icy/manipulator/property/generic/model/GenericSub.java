package icy.manipulator.property.generic.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

import javax.annotation.processing.Generated;

/**
 * Generated model for {@link GenericSubModel<P, Q>}.
 */
@Generated("Icy Manipulator")
public abstract class GenericSub<P, Q extends CharSequence> extends GenericSubModel<P, Q> {

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
    private static final MethodHandle updater(String name) {
        try {
            Field field = GenericSub.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle commentUpdater = updater("comment");

    /** The exposed property. */
    public final Q comment;

    /**
     * HIDE CONSTRUCTOR
     */
    protected GenericSub() {
        this.comment = null;
    }

    /**
     * Return the comment property.
     *
     * @return A value of comment property.
     */
    @Override
    public final Q comment() {
        return this.comment;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of comment property.
     */
    @SuppressWarnings("unused")
    private final Q getComment() {
        return this.comment;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of comment property to assign.
     */
    private final void setComment(Q value) {
        if (value == null) {
            throw new IllegalArgumentException("The comment property requires non-null value.");
        }
        try {
            commentUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("GenericSub<P, Q> [");
        builder.append("comment=").append(comment).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all
     * the property values were placed into an array, and that array were hashed by calling
     * Arrays.hashCode(Object[]).
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently,
     * if both properties are null, true is returned and if exactly one property is null, false is
     * returned. Otherwise, equality is determined by using the equals method of the base model.
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof GenericSub == false) {
            return false;
        }

        GenericSub<P, Q> other = (GenericSub<P, Q>) o;
        if (!Objects.equals(comment, other.comment)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final <P, Q extends CharSequence> Ìnstantiator<?, P, Q> genericSub() {
        return new Ìnstantiator();
    }

    /**
     * Namespace for {@link GenericSub<P, Q>} builder methods.
     */
    public static class Ìnstantiator<Self extends GenericSub<P, Q> & ÅssignableÅrbitrary<Self, P, Q>, P, Q extends CharSequence> {

        /**
         * Create new {@link GenericSub<P, Q>} with the specified comment property.
         * 
         * @return The next assignable model.
         */
        public Self comment(Q comment) {
            Åssignable o = new Åssignable();
            o.comment(comment);
            return (Self) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableComment<Next, P, Q extends CharSequence> {

        /**
         * Assign comment property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next comment(Q value) {
            ((GenericSub) this).setComment(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends GenericSub<P, Q>, P, Q extends CharSequence> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableComment, Generic.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends GenericSub implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Comment = "comment";
    }
}