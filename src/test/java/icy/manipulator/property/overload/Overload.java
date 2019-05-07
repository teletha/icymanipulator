package icy.manipulator.property.overload;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OverloadModel}.
 */
@Generated("Icy Manipulator")
public class Overload extends OverloadModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle updater(String name, Class... parameterTypes)  {
        try {
            Method method = OverloadModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload method invoker. */
    private static final MethodHandle numberjavalangString= updater("number", String.class);

    /** The overload method invoker. */
    private static final MethodHandle dateintintint= updater("date", int.class, int.class, int.class);

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

    /** The final property updater. */
    private static final MethodHandle dateUpdater = updater("date");

    /** The exposed property. */
    public final int number;

    /** The exposed property. */
    public final LocalDate date;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Overload(int number) {
        this.number = number;
        this.date = null;
    }

    /**
     * Retrieve number property.
     */
    @Override
    public final int number() {
        return this.number;
    }

    /**
     * Retrieve date property.
     */
    @Override
    public final LocalDate date() {
        return this.date;
    }

    /**
     * Builder namespace for {@link Overload}.
     */
    public static final class with {

        /**
         * Create uninitialized {@link Overload}.
         */
        public static final <T extends ÅssignableDate> T number(int value) {
            return (T) new Åssignable(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableNumber, ÅssignableDate {
        private Åssignable(int number) {
            super(number);
        }

        /**
         * Modify number property.
         */
        @Override
        public final <T extends ÅssignableDate> T number(int value) {
            try {
                numberUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify date property.
         */
        @Override
        public final <T extends Overload> T date(LocalDate value) {
            try {
                dateUpdater.invoke(this, value);
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
        default <T extends ÅssignableDate> T number(String number) {
            try {
                return number((int) numberjavalangString.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
        <T extends ÅssignableDate> T number(int value);
    }

    /**
     * .
     */
    public static interface ÅssignableDate {
        default <T extends Overload> T date(int year, int month, int day) {
            try {
                return date((LocalDate) dateintintint.invoke(this, year, month, day));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
        <T extends Overload> T date(LocalDate value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Number = "number";
        static final String Date = "date";
    }
}
