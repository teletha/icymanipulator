package icy.manipulator.property.base.model;

import icy.manipulator.property.base.model.Arbitrary;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Generated model for {@link ArbitraryModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class Arbitrary extends ArbitraryModel {

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
            Field field = Arbitrary.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle optionCommentUpdater = updater("optionComment");

    /** The property holder.*/
    // A primitive property is hidden coz native-image builder can't cheat assigning to final field.
    // If you want expose as public-final field, you must use the wrapper type instead of primitive type.
    protected int optionNum;

    /** The property holder.*/
    public final String optionComment;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Arbitrary() {
        this.optionNum = super.optionNum();
        this.optionComment = super.optionComment();
    }

    /**
     * Return the optionNum property.
     *
     * @return A value of optionNum property.
     */
    @Override
    public final int optionNum() {
        return this.optionNum;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionNum property.
     */
    @SuppressWarnings("unused")
    private final int getOptionNum() {
        return this.optionNum;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionNum property to assign.
     */
    private final void setOptionNum(int value) {
        try {
            this.optionNum = (int) value;
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the optionComment property.
     *
     * @return A value of optionComment property.
     */
    @Override
    public final String optionComment() {
        return this.optionComment;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of optionComment property.
     */
    @SuppressWarnings("unused")
    private final String getOptionComment() {
        return this.optionComment;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of optionComment property to assign.
     */
    private final void setOptionComment(String value) {
        if (value == null) {
            value = super.optionComment();
        }
        try {
            optionCommentUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Arbitrary [");
        builder.append("optionNum=").append(optionNum).append(", ");
        builder.append("optionComment=").append(optionComment).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(optionNum, optionComment);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Arbitrary == false) {
            return false;
        }

        Arbitrary other = (Arbitrary) o;
        if (optionNum != other.optionNum) return false;
        if (!Objects.equals(optionComment, other.optionComment)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Arbitrary}  builder methods.
     */
    public static class Ìnstantiator<Self extends Arbitrary & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link Arbitrary}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }

        /**
         * Create initialized {@link Arbitrary} with optionNum property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self optionNum(int value) {
            return create().optionNum(value);
        }

        /**
         * Create initialized {@link Arbitrary} with optionComment property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self optionComment(String value) {
            return create().optionComment(value);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Arbitrary> {

        /**
         * Assign optionNum property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionNum(int value) {
            ((Arbitrary) this).setOptionNum(value);
            return (Next) this;
        }

        /**
         * Assign optionComment property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next optionComment(String value) {
            ((Arbitrary) this).setOptionComment(value);
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
    private static final class Åssignable extends Arbitrary implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String OptionNum = "optionNum";
        static final String OptionComment = "optionComment";
    }
}
