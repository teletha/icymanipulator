package icy.manipulator.property.group.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link EnumGroupModel}.
 */
@Generated("Icy Manipulator")
public abstract class EnumGroup extends EnumGroupModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = EnumGroup.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle colorUpdater = updater("color");

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The exposed property. */
    public final Color color;

    /** The exposed property. */
    public final int size;

    /**
     * HIDE CONSTRUCTOR
     */
    protected EnumGroup() {
        this.color = null;
        this.size = 0;
    }

    /** Return the color property. */
    @Override
    public final Color color() {
        return this.color;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final Color getColor() {
        return this.color;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setColor(Color value) {
        ((ÅssignableColor) this).color(value);
    }

    /** Return the size property. */
    @Override
    public final int size() {
        return this.size;
    }

    /** Provide classic getter API. */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /** Provide classic setter API. */
    @SuppressWarnings("unused")
    private void setSize(int value) {
        ((ÅssignableSize) this).size(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link EnumGroup}  builder methods.
     */
    public static final class Ìnstantiator<Self extends EnumGroup & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new EnumGroup with the specifiedcolor property.
         * 
         * @return The next assignable model.
         */
        public final Self color(Color color, int INT) {
            Åssignable o = new Åssignable();
            o.color(color);
            o.size(INT);
            return (Self) o;
        }

        /**
         * Create new EnumGroup with the specifiedcolor property.
         * 
         * @return The next assignable model.
         */
        public final Self red(int INT) {
            Åssignable o = new Åssignable();
            o.red();
            o.size(INT);
            return (Self) o;
        }

        /**
         * Create new EnumGroup with the specifiedcolor property.
         * 
         * @return The next assignable model.
         */
        public final Self blue(int INT) {
            Åssignable o = new Åssignable();
            o.blue();
            o.size(INT);
            return (Self) o;
        }

        /**
         * Create new EnumGroup with the specifiedcolor property.
         * 
         * @return The next assignable model.
         */
        public final Self green(int INT) {
            Åssignable o = new Åssignable();
            o.green();
            o.size(INT);
            return (Self) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableColor<Next> {

        /**
         * Assign color property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next color(Color value) {
            try {
                colorUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * Assign color property by {@link Color#Red}.
         * 
         * @return The next assignable model.
         */
        default Next red() {
            return color(Color.Red);
        }

        /**
         * Assign color property by {@link Color#Blue}.
         * 
         * @return The next assignable model.
         */
        default Next blue() {
            return color(Color.Blue);
        }

        /**
         * Assign color property by {@link Color#Green}.
         * 
         * @return The next assignable model.
         */
        default Next green() {
            return color(Color.Green);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {

        /**
         * Assign size property.
         * 
         * @param value A value to assign.
         * @return The next assignable model.
         */
        default Next size(int value) {
            try {
                sizeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends EnumGroup> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableColor, ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends EnumGroup implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Color = "color";
        static final String Size = "size";
    }
}
