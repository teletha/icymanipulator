package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.Overload;
import icy.manipulator.property.overload.model.OverloadModel;
import java.lang.String;
import java.lang.Throwable;
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
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = OverloadModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle size$622111980= invoker("size", int.class);

    /** The overload or intercept method invoker. */
    private static final MethodHandle sizeByText$1195967339= invoker("sizeByText", String.class);

    /** The overload or intercept method invoker. */
    private static final MethodHandle date$718095476= invoker("date", int.class, int.class, int.class);

    /** The overload or intercept method invoker. */
    private static final MethodHandle today$1= invoker("today");

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
            throw quiet(e);
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
     * Return the size property.
     *
     * @return A value of size property.
     */
    @Override
    public final BigDecimal size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of size property.
     */
    @SuppressWarnings("unused")
    private final BigDecimal getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of size property to assign.
     */
    private final void setSize(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("The size property requires non-null value.");
        }
        try {
            sizeUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the date property.
     *
     * @return A value of date property.
     */
    @Override
    public final LocalDate date() {
        return this.date;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of date property.
     */
    @SuppressWarnings("unused")
    private final LocalDate getDate() {
        return this.date;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of date property to assign.
     */
    private final void setDate(LocalDate value) {
        if (value == null) {
            throw new IllegalArgumentException("The date property requires non-null value.");
        }
        try {
            dateUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Overload}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Overload & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Overload} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<Self>> T size(BigDecimal size) {
            Åssignable o = new Åssignable();
            o.size(size);
            return (T) o;
        }

        /**
         * Create new {@link Overload} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<Self>> T size(int number) {
            Åssignable o = new Åssignable();
            o.size(number);
            return (T) o;
        }

        /**
         * Create new {@link Overload} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableDate<Self>> T sizeByText(String number) {
            Åssignable o = new Åssignable();
            o.sizeByText(number);
            return (T) o;
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
        default Next size(BigDecimal value) {
            ((Overload) this).setSize(value);
            return (Next) this;
        }

        /**
         * Assign size property.
         * 
         * @return The next assignable model.
         */
        default Next size(int number) {
            try {
                return size((BigDecimal) size$622111980.invoke(this, number));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }

        /**
         * Assign size property.
         * 
         * @return The next assignable model.
         */
        default Next sizeByText(String number) {
            try {
                return size((BigDecimal) sizeByText$1195967339.invoke(this, number));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDate<Next> {

        /**
         * Assign date property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next date(LocalDate value) {
            ((Overload) this).setDate(value);
            return (Next) this;
        }

        /**
         * Assign date property.
         * 
         * @return The next assignable model.
         */
        default Next date(int year, int month, int day) {
            try {
                return date((LocalDate) date$718095476.invoke(this, year, month, day));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }

        /**
         * Assign date property.
         * 
         * @return The next assignable model.
         */
        default Next today() {
            try {
                return date((LocalDate) today$1.invoke(this));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Overload> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableSize, ÅssignableDate {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Date = "date";
    }
}
