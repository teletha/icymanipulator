package icy.manipulator.property.generic.model;

import icy.manipulator.property.generic.model.SelfRef;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.ToIntFunction;

/**
 * Generated model for {@link SelfRefModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class SelfRef implements icy.manipulator.property.generic.model.SelfRefModel {

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
            Method method = icy.manipulator.property.generic.model.SelfRefModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle values$912239839= invoker("values", double.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = SelfRef.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The final property updater. */
    private static final MethodHandle calcUpdater = updater("calc");

    /** The exposed property. */
    public final int value;

    /** The exposed property. */
    public final ToIntFunction<SelfRef> calc;

    /**
     * HIDE CONSTRUCTOR
     */
    protected SelfRef() {
        this.value = 0;
        this.calc = null;
    }

    /**
     * Return the value property.
     *
     * @return A value of value property.
     */
    @Override
    public final int value() {
        return this.value;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final int getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(int value) {
        try {
            valueUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the calc property.
     *
     * @return A value of calc property.
     */
    @Override
    public final ToIntFunction<SelfRef> calc() {
        return this.calc;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of calc property.
     */
    @SuppressWarnings("unused")
    private final ToIntFunction<SelfRef> getCalc() {
        return this.calc;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of calc property to assign.
     */
    private final void setCalc(ToIntFunction<SelfRef> value) {
        if (value == null) {
            throw new IllegalArgumentException("The calc property requires non-null value.");
        }
        try {
            calcUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("SelfRef [");
        builder.append("value=").append(value).append(", ");
        builder.append("calc=").append(calc).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, calc);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof SelfRef == false) {
            return false;
        }

        SelfRef other = (SelfRef) o;
        if (value != other.value) return false;
        if (!Objects.equals(calc, other.calc)) return false;
        return true;
    }

    public static <SELF extends icy.manipulator.property.generic.model.SelfRefModel> Ìnstantiator<?, SELF> with() {
        return new Ìnstantiator();
    }

    /**
     * Namespace for {@link SelfRef}  builder methods.
     */
    public static class Ìnstantiator<Self extends SelfRef & ÅssignableÅrbitrary<Self, SELF>, SELF extends icy.manipulator.property.generic.model.SelfRefModel> {

        /**
         * Create new {@link SelfRef} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableCalc<Self, SELF> value(int value) {
            Åssignable o = new Åssignable();
            o.value(value);
            return o;
        }

        /**
         * Create new {@link SelfRef} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableCalc<Self, SELF> values(double value) {
            Åssignable o = new Åssignable();
            o.values(value);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValue<Next, SELF extends icy.manipulator.property.generic.model.SelfRefModel> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(int value) {
            ((SelfRef) this).setValue(value);
            return (Next) this;
        }

        /**
         * Assign value property.
         * 
         * @return The next assignable model.
         */
        default Next values(double value) {
            try {
                return value((int) values$912239839.invoke(this, value));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableCalc<Next, SELF extends icy.manipulator.property.generic.model.SelfRefModel> {

        /**
         * Assign calc property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next calc(ToIntFunction<SelfRef> value) {
            ((SelfRef) this).setCalc((java.util.function.ToIntFunction)value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends SelfRef, SELF extends icy.manipulator.property.generic.model.SelfRefModel> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableValue, ÅssignableCalc {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable<SELF extends icy.manipulator.property.generic.model.SelfRefModel> extends SelfRef implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Value = "value";
        static final String Calc = "calc";
    }
}
