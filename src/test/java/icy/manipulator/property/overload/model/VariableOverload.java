package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.VariableOverload;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kiss.Variable;

/**
 * Generated model for {@link VariableOverloadModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class VariableOverload extends VariableOverloadModel {

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
            Method method = icy.manipulator.property.overload.model.VariableOverloadModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle one$1= invoker("one");

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final Field updater(String name)  {
        try {
            Field field = VariableOverload.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Create fast property updater.
     *
     * @param field A target field.
     * @return A fast property updater.
     */
    private static final MethodHandle handler(Field field)  {
        try {
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final Field numField = updater("num");

    /** The fast final property updater. */
    private static final MethodHandle numUpdater = handler(numField);

    /** The exposed property. */
    public final Variable<String> num;

    /**
     * HIDE CONSTRUCTOR
     */
    protected VariableOverload() {
        this.num = Variable.empty();
    }

    /**
     * Return the num property.
     *
     * @return A value of num property.
     */
    @Override
    public final Variable<String> num() {
        return this.num;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of num property.
     */
    @SuppressWarnings("unused")
    private final Variable<String> getNum() {
        return this.num;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of num property to assign.
     */
    private final void setNum(Variable<String> value) {
        if (value == null) {
            value = Variable.empty();
        }
        try {
            numUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("VariableOverload [");
        builder.append("num=").append(num).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof VariableOverload == false) {
            return false;
        }

        VariableOverload other = (VariableOverload) o;
        if (!Objects.equals(num, other.num)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link VariableOverload}  builder methods.
     */
    public static class Ìnstantiator<Self extends VariableOverload & ÅssignableÅrbitrary<Self>> {

        /**
         * Create initialized {@link VariableOverload}.
         *
         * @return A initialized model.
         */
        public Self create() {
            return (Self) new Åssignable();
        }

        /**
         * Create initialized {@link VariableOverload} with num property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self num(Variable<String> value) {
            return create().num(value);
        }

        /**
         * Create initialized {@link VariableOverload} with num property.
         *
         * @param value A value to assign.
         * @return A initialized model.
         */
        public Self num(String value) {
            return num(Variable.of(value));
        }

        /**
         * Create initialized {@link VariableOverload} with num property.
         *
         * @return A initialized model.
         */
        public Self one() {
            try {
                return num((Variable<String>) one$1.invoke(this));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends VariableOverload> {

        /**
         * Assign num property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next num(Variable<? extends String> value) {
            ((VariableOverload) this).setNum((kiss.Variable)value);
            return (Next) this;
        }

        /**
         * Assign num property.
         * 
         * @return The next assignable model.
         */
        default Next num(String value) {
            return num(Variable.of(value));
        }

        /**
         * Assign num property.
         * 
         * @return The next assignable model.
         */
        default Next one() {
            try {
                return num((Variable<String>) one$1.invoke(this));
            } catch (Throwable e) {
                throw quiet(e);
            }
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends VariableOverload implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Num = "num";
    }
}
