package icy.manipulator.property.overload;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
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
    private static final MethodHandle updater(String name, Class... parameterTypes) {
        try {
            Method method = OverloadModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload method invoker. */
    private static final MethodHandle sizeint = updater("size", int.class);

    /** The overload method invoker. */
    private static final MethodHandle sizeByTextjavalangString = updater("sizeByText", String.class);

    /** The overload method invoker. */
    private static final MethodHandle dateintintint = updater("date", int.class, int.class, int.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name) {
        try {
            Field field = Overload.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The final property updater. */
    private static final MethodHandle dateUpdater = updater("date");

    /** The exposed property. */
    public final BigDecimal size;

    /** The exposed property. */
    public final LocalDate date;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Overload(BigDecimal size) {
        this.size = size;
        this.date = null;
    }

    /**
     * Retrieve size property.
     */
    @Override
    public final BigDecimal size() {
        return this.size;
    }

    /**
     * Retrieve date property.
     */
    @Override
    public final LocalDate date() {
        return this.date;
    }

    /** The singleton model builder. */
    public static final ÅssignableSize with = new ÅssignableSize() {

        /** Create Uninitialized {@link Overload}. */
        @Override
        public <T extends ÅssignableDate> T size(BigDecimal value) {
            return (T) new Åssignable(value);
        }

        /** Create Uninitialized {@link Overload}. */
        @Override
        public <T extends ÅssignableDate> T size(int number) {
            return new Åssignable(null).size(number);
        }

        /** Create Uninitialized {@link Overload}. */
        @Override
        public <T extends ÅssignableDate> T sizeByText(String number) {
            return new Åssignable(null).sizeByText(number);
        }
    };

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableSize, ÅssignableDate {

        /**
         * Initialize by first property.
         */
        private Åssignable(BigDecimal size) {
            super(size);
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
     * Property assignment API.
     */
    public static interface ÅssignableSize {

        /**
         * The overload setter.
         */
        default <T extends ÅssignableDate> T size(int number) {
            try {
                return size((BigDecimal) sizeint.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * The overload setter.
         */
        default <T extends ÅssignableDate> T sizeByText(String number) {
            try {
                return size((BigDecimal) sizeByTextjavalangString.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * Modify size property.
         */
        default <T extends ÅssignableDate> T size(BigDecimal value) {
            try {
                sizeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDate {

        /**
         * The overload setter.
         */
        default <T extends Overload> T date(int year, int month, int day) {
            try {
                return date((LocalDate) dateintintint.invoke(this, year, month, day));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /** Setter */
        <T extends Overload> T date(LocalDate value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";

        static final String Date = "date";
    }
}
