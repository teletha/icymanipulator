package icy.manipulator.property.extend.model;

import icy.manipulator.property.model.Multiple;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link SubclassModel}.
 */
@Generated("Icy Manipulator")
public abstract class Subclass extends SubclassModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Subclass.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nicknameUpdater = updater("nickname");

    /** The exposed property. */
    public final String nickname;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Subclass() {
        this.nickname = null;
    }

    /**
     * Retrieve nickname property.
     */
    @Override
    public final String nickname() {
        return this.nickname;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getNickname() {
        return this.nickname;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setNickname(String value) {
        ((ÅssignableNickname) this).nickname(value);
    }

    /** The singleton builder. */
    public static final  ÌnstantiatorTyped<?> with = new ÌnstantiatorTyped();

    public static final class ÌnstantiatorTyped<Self extends Subclass & ÅssignableÅrbitrary<Self>> extends Ìnstantiator<Self> {
    }

    /**
     * Builder namespace for {@link Subclass}.
     */
    protected static class Ìnstantiator<Self> extends Multiple.Ìnstantiator<ÅssignableNickname<Self>> {

        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNickname<Next> {

        /**
         * The setter.
         */
        default Next nickname(String value) {
            try {
                nicknameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Subclass> extends icy.manipulator.property.model.Multiple.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableNickname, Multiple.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Subclass implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Nickname = "nickname";
    }
}
