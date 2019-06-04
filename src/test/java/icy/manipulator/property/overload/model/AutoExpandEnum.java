package icy.manipulator.property.overload.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

import javax.annotation.processing.Generated;

/**
 * Generated model for {@link AutoExpandEnumModel}.
 */
@Generated("Icy Manipulator")
public abstract class AutoExpandEnum extends AutoExpandEnumModel {

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
            Field field = AutoExpandEnum.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle answerUpdater = updater("answer");

    /** The final property updater. */
    private static final MethodHandle visibleUpdater = updater("visible");

    /** The exposed property. */
    public final Answer answer;

    /** The exposed property. */
    public final Visible visible;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandEnum() {
        this.answer = null;
        this.visible = null;
    }

    /**
     * Return the answer property.
     *
     * @return A value of answer property.
     */
    @Override
    public final Answer answer() {
        return this.answer;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of answer property.
     */
    @SuppressWarnings("unused")
    private final Answer getAnswer() {
        return this.answer;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of answer property to assign.
     */
    private final void setAnswer(Answer value) {
        if (value == null) {
            throw new IllegalArgumentException("The answer property requires non-null value.");
        }
        try {
            answerUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the visible property.
     *
     * @return A value of visible property.
     */
    @Override
    public final Visible visible() {
        return this.visible;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of visible property.
     */
    @SuppressWarnings("unused")
    private final Visible getVisible() {
        return this.visible;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of visible property to assign.
     */
    private final void setVisible(Visible value) {
        if (value == null) {
            throw new IllegalArgumentException("The visible property requires non-null value.");
        }
        try {
            visibleUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("AutoExpandEnum [");
        builder.append("answer=").append(answer).append(", ");
        builder.append("visible=").append(visible).append("]");
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
        return Objects.hash(answer, visible);
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
        if (o instanceof AutoExpandEnum == false) {
            return false;
        }

        AutoExpandEnum other = (AutoExpandEnum) o;
        if (!Objects.equals(answer, other.answer)) return false;
        if (!Objects.equals(visible, other.visible)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandEnum} builder methods.
     */
    public static class Ìnstantiator<Self extends AutoExpandEnum & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableVisible<Self> answer(Answer answer) {
            Åssignable o = new Åssignable();
            o.answer(answer);
            return o;
        }

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableVisible<Self> yes() {
            Åssignable o = new Åssignable();
            o.yes();
            return o;
        }

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableVisible<Self> no() {
            Åssignable o = new Åssignable();
            o.no();
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAnswer<Next> {

        /**
         * Assign answer property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next answer(Answer value) {
            ((AutoExpandEnum) this).setAnswer(value);
            return (Next) this;
        }

        /**
         * Assign answer property.
         * 
         * @return The next assignable model.
         */
        default Next yes() {
            return answer(Answer.Yes);
        }

        /**
         * Assign answer property.
         * 
         * @return The next assignable model.
         */
        default Next no() {
            return answer(Answer.No);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableVisible<Next> {

        /**
         * Assign visible property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next visible(Visible value) {
            ((AutoExpandEnum) this).setVisible(value);
            return (Next) this;
        }

        /**
         * Assign visible property.
         * 
         * @return The next assignable model.
         */
        default Next expose() {
            return visible(Visible.EXPOSE);
        }

        /**
         * Assign visible property.
         * 
         * @return The next assignable model.
         */
        default Next hidden() {
            return visible(Visible.HIDDEN);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandEnum> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableAnswer, ÅssignableVisible {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends AutoExpandEnum implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Answer = "answer";

        static final String Visible = "visible";
    }
}
