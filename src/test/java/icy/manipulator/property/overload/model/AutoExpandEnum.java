package icy.manipulator.property.overload.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
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
    private static final MethodHandle updater(String name)  {
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

    /** The exposed property. */
    public final Answer answer;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandEnum() {
        this.answer = null;
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

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandEnum}  builder methods.
     */
    public static final class Ìnstantiator<Self extends AutoExpandEnum & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public final Self answer(Answer answer) {
            Åssignable o = new Åssignable();
            o.answer(answer);
            return (Self) o;
        }

        /** Set answer property with Answer.Yes */
        public final Self yes() {
            Åssignable o = new Åssignable();
            o.yes();
            return (Self) o;
        }

        /** Set answer property with Answer.No */
        public final Self no() {
            Åssignable o = new Åssignable();
            o.no();
            return (Self) o;
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
         * Assign {@link Answer#Yes} to answer property.
         * 
         * @return The next assignable model.
         */
        default Next yes() {
            return answer(Answer.Yes);
        }

        /**
         * Assign {@link Answer#No} to answer property.
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
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandEnum> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableAnswer {
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
    }
}
