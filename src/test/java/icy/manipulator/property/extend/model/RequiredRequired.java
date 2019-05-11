package icy.manipulator.property.extend.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link RequiredRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class RequiredRequired extends RequiredRequiredModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = RequiredRequired.class.getDeclaredField(name);
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
    protected RequiredRequired() {
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
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link RequiredRequired}.
     */
    public static final class Ìnstantiator<Self extends RequiredRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create uninitialized {@link RequiredRequired}.
         */
        public final <T extends ÅssignableStand<ÅssignableAge<ÅssignableNickname<Self>>>> T name(String value) {
            return (T) new Åssignable().name(value);
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
    public static interface ÅssignableÅrbitrary<Next extends RequiredRequired> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableNickname, icy.manipulator.property.model.Multiple.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends RequiredRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Nickname = "nickname";
    }
}
