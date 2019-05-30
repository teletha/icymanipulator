package icy.manipulator.property.group.model;

import icy.manipulator.property.group.model.EnumGroup;
import icy.manipulator.property.group.model.EnumGroupModel;
import icy.manipulator.property.group.model.EnumGroupModel.Color;
import java.lang.Throwable;
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
            Field field = EnumGroup.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
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

    /**
     * Return the color property.
     *
     * @return A value of color property.
     */
    @Override
    public final Color color() {
        return this.color;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of color property.
     */
    @SuppressWarnings("unused")
    private final Color getColor() {
        return this.color;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of color property to assign.
     */
    private final void setColor(Color value) {
        if (value == null) {
            throw new IllegalArgumentException("The color property requires non-null value.");
        }
        try {
            colorUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the size property.
     *
     * @return A value of size property.
     */
    @Override
    public final int size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of size property.
     */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of size property to assign.
     */
    private final void setSize(int value) {
        try {
            sizeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link EnumGroup}  builder methods.
     */
    public static final class Ìnstantiator<Self extends EnumGroup & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link EnumGroup} with the specified color property.
         * 
         * @return The next assignable model.
         */
        public final Self color(Color color, int size) {
            Åssignable o = new Åssignable();
            o.color(color);
            o.size(size);
            return (Self)o;
        }

        /** Set color property with Red. */
        public final Self red(int size) {
            Åssignable o = new Åssignable();
            o.red();
            o.size(size);
            return (Self)o;
        }

        /** Set color property with Blue. */
        public final Self blue(int size) {
            Åssignable o = new Åssignable();
            o.blue();
            o.size(size);
            return (Self)o;
        }

        /** Set color property with Green. */
        public final Self green(int size) {
            Åssignable o = new Åssignable();
            o.green();
            o.size(size);
            return (Self)o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableColor<Next> {

        /**
         * Assign color property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next color(Color value) {
            ((EnumGroup) this).setColor(value);
            return (Next) this;
        }

        /**
         * Assign {@link Color#Red} to color property.
         * 
         * @return The next assignable model.
         */
        default Next red() {
            return color(Color.Red);
        }

        /**
         * Assign {@link Color#Blue} to color property.
         * 
         * @return The next assignable model.
         */
        default Next blue() {
            return color(Color.Blue);
        }

        /**
         * Assign {@link Color#Green} to color property.
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
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next size(int value) {
            ((EnumGroup) this).setSize(value);
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
