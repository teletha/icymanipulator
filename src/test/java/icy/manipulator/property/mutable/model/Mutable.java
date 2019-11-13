package icy.manipulator.property.mutable.model;

import icy.manipulator.property.mutable.model.Mutable;
import icy.manipulator.property.mutable.model.MutableModel;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MutableModel}.
 */
@Generated("Icy Manipulator")
public abstract class Mutable extends MutableModel {

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
            Field field = Mutable.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The final property updater. */
    private static final MethodHandle intNumUpdater = updater("intNum");

    /** The final property updater. */
    private static final MethodHandle longNumUpdater = updater("longNum");

    /** The final property updater. */
    private static final MethodHandle floatNumUpdater = updater("floatNum");

    /** The final property updater. */
    private static final MethodHandle doubleNumUpdater = updater("doubleNum");

    /** The exposed property. */
    public final String value;

    /** The exposed property. */
    public final int intNum;

    /** The exposed property. */
    public final long longNum;

    /** The exposed property. */
    public final float floatNum;

    /** The exposed property. */
    public final double doubleNum;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Mutable() {
        this.value = null;
        this.intNum = 0;
        this.longNum = 0L;
        this.floatNum = 0;
        this.doubleNum = 0D;
    }

    /**
     * Return the value property.
     *
     * @return A value of value property.
     */
    @Override
    public final String value() {
        return this.value;
    }

    /**
     * Assign the new value of value property.
     *
     * @paran value The new value property value to assign.
     * @return Chainable API.
     */
    public final Mutable assignValue(String value) {
        setValue(value);
        return this;
    }

    /**
     * Assign the new value of value property.
     *
     * @paran value The value property assigner which accepts the current value and returns new value.
     * @return Chainable API.
     */
    public final Mutable assignValue(UnaryOperator<String> value) {
        setValue(value.apply(this.value));
        return this;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of value property.
     */
    @SuppressWarnings("unused")
    private final String getValue() {
        return this.value;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of value property to assign.
     */
    private final void setValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The value property requires non-null value.");
        }
        try {
            valueUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the intNum property.
     *
     * @return A value of intNum property.
     */
    @Override
    public final int intNum() {
        return this.intNum;
    }

    /**
     * Assign the new value of intNum property.
     *
     * @paran value The new intNum property value to assign.
     * @return Chainable API.
     */
    public final Mutable assignIntNum(int value) {
        setIntNum(value);
        return this;
    }

    /**
     * Assign the new value of intNum property.
     *
     * @paran value The intNum property assigner which accepts the current value and returns new value.
     * @return Chainable API.
     */
    public final Mutable assignIntNum(IntUnaryOperator value) {
        setIntNum(value.applyAsInt(this.intNum));
        return this;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of intNum property.
     */
    @SuppressWarnings("unused")
    private final int getIntNum() {
        return this.intNum;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of intNum property to assign.
     */
    private final void setIntNum(int value) {
        try {
            intNumUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the longNum property.
     *
     * @return A value of longNum property.
     */
    @Override
    public final long longNum() {
        return this.longNum;
    }

    /**
     * Assign the new value of longNum property.
     *
     * @paran value The new longNum property value to assign.
     * @return Chainable API.
     */
    public final Mutable assignLongNum(long value) {
        setLongNum(value);
        return this;
    }

    /**
     * Assign the new value of longNum property.
     *
     * @paran value The longNum property assigner which accepts the current value and returns new value.
     * @return Chainable API.
     */
    public final Mutable assignLongNum(LongUnaryOperator value) {
        setLongNum(value.applyAsLong(this.longNum));
        return this;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of longNum property.
     */
    @SuppressWarnings("unused")
    private final long getLongNum() {
        return this.longNum;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of longNum property to assign.
     */
    private final void setLongNum(long value) {
        try {
            longNumUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the floatNum property.
     *
     * @return A value of floatNum property.
     */
    @Override
    public final float floatNum() {
        return this.floatNum;
    }

    /**
     * Assign the new value of floatNum property.
     *
     * @paran value The new floatNum property value to assign.
     * @return Chainable API.
     */
    public final Mutable assignFloatNum(float value) {
        setFloatNum(value);
        return this;
    }

    /**
     * Assign the new value of floatNum property.
     *
     * @paran value The floatNum property assigner which accepts the current value and returns new value.
     * @return Chainable API.
     */
    public final Mutable assignFloatNum(UnaryOperator<Float> value) {
        setFloatNum(value.apply(this.floatNum));
        return this;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of floatNum property.
     */
    @SuppressWarnings("unused")
    private final float getFloatNum() {
        return this.floatNum;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of floatNum property to assign.
     */
    private final void setFloatNum(float value) {
        try {
            floatNumUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the doubleNum property.
     *
     * @return A value of doubleNum property.
     */
    @Override
    public final double doubleNum() {
        return this.doubleNum;
    }

    /**
     * Assign the new value of doubleNum property.
     *
     * @paran value The new doubleNum property value to assign.
     * @return Chainable API.
     */
    public final Mutable assignDoubleNum(double value) {
        setDoubleNum(value);
        return this;
    }

    /**
     * Assign the new value of doubleNum property.
     *
     * @paran value The doubleNum property assigner which accepts the current value and returns new value.
     * @return Chainable API.
     */
    public final Mutable assignDoubleNum(DoubleUnaryOperator value) {
        setDoubleNum(value.applyAsDouble(this.doubleNum));
        return this;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of doubleNum property.
     */
    @SuppressWarnings("unused")
    private final double getDoubleNum() {
        return this.doubleNum;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of doubleNum property to assign.
     */
    private final void setDoubleNum(double value) {
        try {
            doubleNumUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("Mutable [");
        builder.append("value=").append(value).append(", ");
        builder.append("intNum=").append(intNum).append(", ");
        builder.append("longNum=").append(longNum).append(", ");
        builder.append("floatNum=").append(floatNum).append(", ");
        builder.append("doubleNum=").append(doubleNum).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, intNum, longNum, floatNum, doubleNum);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Mutable == false) {
            return false;
        }

        Mutable other = (Mutable) o;
        if (!Objects.equals(value, other.value)) return false;
        if (intNum != other.intNum) return false;
        if (longNum != other.longNum) return false;
        if (floatNum != other.floatNum) return false;
        if (doubleNum != other.doubleNum) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Mutable}  builder methods.
     */
    public static class Ìnstantiator<Self extends Mutable & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Mutable} with the specified value property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableIntNum<ÅssignableLongNum<ÅssignableFloatNum<ÅssignableDoubleNum<Self>>>> value(String value) {
            Åssignable o = new Åssignable();
            o.value(value);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableValue<Next> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(String value) {
            ((Mutable) this).setValue(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableIntNum<Next> {

        /**
         * Assign intNum property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next intNum(int value) {
            ((Mutable) this).setIntNum(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableLongNum<Next> {

        /**
         * Assign longNum property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next longNum(long value) {
            ((Mutable) this).setLongNum(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableFloatNum<Next> {

        /**
         * Assign floatNum property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next floatNum(float value) {
            ((Mutable) this).setFloatNum(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDoubleNum<Next> {

        /**
         * Assign doubleNum property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next doubleNum(double value) {
            ((Mutable) this).setDoubleNum(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Mutable> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableValue, ÅssignableIntNum, ÅssignableLongNum, ÅssignableFloatNum, ÅssignableDoubleNum {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Mutable implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Value = "value";
        static final String IntNum = "intNum";
        static final String LongNum = "longNum";
        static final String FloatNum = "floatNum";
        static final String DoubleNum = "doubleNum";
    }
}
