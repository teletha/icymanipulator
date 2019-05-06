package icy.manipulator.property.overload;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OverloadModel}.
 */
@Generated("Icy Manipulator")
public class Overload extends OverloadModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Overload.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle numberUpdater = updater("number");

    /** The exposed property. */
    public final int number;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Overload() {
        this.number = 0;
    }

    /**
     * Retrieve number property.
     */
    @Override
    public final int number() {
        return this.number;
    }

    /**
     * Create uninitialized {@link Overload}.
     */
    public static final <T extends ÅssignableNumber> T create() {
        return (T) new Åssignable();
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableNumber {

        /**
         * Modify number property.
         */
        @Override
        public final <T extends Overload> T number(int value) {
            try {
                numberUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * .
     */
    public static interface ÅssignableNumber {
        <T extends Overload> T number(int value);
    }
}
