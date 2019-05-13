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
            throw new Error(e);
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
     * Retrieve answer property.
     */
    @Override
    public final Answer answer() {
        return this.answer;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final Answer getAnswer() {
        return this.answer;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setAnswer(Answer value) {
        ((ÅssignableAnswer) this).answer(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link AutoExpandEnum}.
     */
    public static final class Ìnstantiator<Self extends AutoExpandEnum & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link AutoExpandEnum}.
         */
        public final <T extends Self> T answer(Answer answer) {
            Åssignable o = new Åssignable();
            o.answer(answer);
            return (T) o;
        }
        /**
         * Create uninitialized {@link AutoExpandEnum}.
         */
        public final <T extends Self> T yes() {
            Åssignable o = new Åssignable();
            o.yes();
            return (T) o;
        }
        /**
         * Create uninitialized {@link AutoExpandEnum}.
         */
        public final <T extends Self> T no() {
            Åssignable o = new Åssignable();
            o.no();
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAnswer<Next> {
        /**
         * The base setter.
         */
        default Next answer(Answer value) {
            try {
                answerUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * The overload setter.
         */
        default Next yes() {
            return answer(Answer.Yes);
        }

        /**
         * The overload setter.
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
