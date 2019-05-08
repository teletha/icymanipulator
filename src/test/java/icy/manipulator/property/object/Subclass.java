package icy.manipulator.property.object;

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
     * 
     */
    abstract Subclass nickname(String value);

    /**
     * Provide classic getter API.
     */
    final String getNickname() {
        return this.nickname;
    }

    /**
     * Provide classic setter API.
     */
    final void setNickname(String value) {
        try {
            nicknameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Builder namespace for {@link Subclass}.
     */
    public static final class with {

        /** Create Uninitialized {@link Subclass}. */
        public static final <Self extends Subclass> Self nickname(String value) {
            return (Self) new Åssignable().nickname(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Subclass implements ÅssignableNickname<Subclass> {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable nickname(String value) {
            setNickname(value);
            return this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNickname<Next> {

        /** Setter */
        Next nickname(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Nickname = "nickname";
    }
}
