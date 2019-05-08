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
    private static final MethodHandle updater(String name) {
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
    protected Subclass(String nickname) {
        super(nickname);
        this.nickname = nickname;
    }

    /**
     * Retrieve nickname property.
     */
    @Override
    public final String nickname() {
        return this.nickname;
    }

    /**
     * The internal access API for nickname property setter.
     */
    protected abstract <T extends Subclass> T nickname(String value);

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
        this.nickname(value);
    }

    /**
     * Builder namespace for {@link Subclass}.
     */
    public static final class with {

        /** Create Uninitialized {@link Subclass}. */
        public static final <Self extends ÅssignableNickname<Subclass>> Self name(String value) {
            return (Self) new Åssignable(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Subclass implements ÅssignableNickname<Subclass> {

        /**
         * Initialize by first property.
         */
        private Åssignable(String nickname) {
            super(nickname);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T extends Single> T name(String value) {
            return super.name(value);
        }

        /**
         * Modify nickname property.
         */
        @Override
        public final Subclass nickname(String value) {
            try {
                nicknameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
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
