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
public abstract class Overload extends OverloadModel {

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
    private static final MethodHandle sizeint= updater("size", int.class);

    /** The overload method invoker. */
    private static final MethodHandle sizeByTextjavalangString= updater("sizeByText", String.class);

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
    protected Overload() {
        this.size = null;
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
     * 
     */
    abstract Overload size(BigDecimal value);

    /**
     * Provide classic getter API.
     */
    final BigDecimal getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     */
    final void setSize(BigDecimal value) {
        try {
            sizeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Retrieve date property.
     */
    @Override
    public final LocalDate date() {
        return this.date;
    }

    /**
     * 
     */
    abstract Overload date(LocalDate value);

    /**
     * Provide classic getter API.
     */
    final LocalDate getDate() {
        return this.date;
    }

    /**
     * Provide classic setter API.
     */
    final void setDate(LocalDate value) {
        try {
            dateUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Builder namespace for {@link Overload}.
     */
    public static final class with {

        /** Create Uninitialized {@link Overload}. */
        public static final <Self extends ÅssignableDate<Overload>> Self size(BigDecimal value) {
            return (Self) new Åssignable().size(value);
        }

        /** Create Uninitialized {@link Overload}. */
        public static final <Self extends ÅssignableDate<Overload>> Self size(int number) {
            return (Self) new Åssignable().size(number);
        }

        /** Create Uninitialized {@link Overload}. */
        public static final <Self extends ÅssignableDate<Overload>> Self sizeByText(String number) {
            return (Self) new Åssignable().sizeByText(number);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableSize, ÅssignableDate {

        /**  {@inheritDoc} */
        @Override
        public final Åssignable size(BigDecimal value) {
            setSize(value);
            return this;
        }

        /**  {@inheritDoc} */
        @Override
        public final Åssignable date(LocalDate value) {
            setDate(value);
            return this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {

        /**
         * The overload setter.
         */
        default Next size(int number) {
            try {
                return size((BigDecimal) sizeint.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * The overload setter.
         */
        default Next sizeByText(String number) {
            try {
                return size((BigDecimal) sizeByTextjavalangString.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /** Setter */
        Next size(BigDecimal value);
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDate<Next> {

        /**
         * The overload setter.
         */
        default Next date(int year, int month, int day) {
            try {
                return date((LocalDate) dateintintint.invoke(this, year, month, day));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /** Setter */
        Next date(LocalDate value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Date = "date";
    }
}
