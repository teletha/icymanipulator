package icy.manipulator.property.intercept.model;

import icy.manipulator.property.intercept.model.MultiIntercepts;
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
import java.util.function.Consumer;

/**
 * Generated model for {@link MultiInterceptsModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class MultiIntercepts extends MultiInterceptsModel {

     /** Determines if the execution environment is a Native Image of GraalVM. */
    private static final boolean NATIVE = "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"));

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
            Method method = icy.manipulator.property.intercept.model.MultiInterceptsModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle checkLower$101354429= invoker("checkLower", int.class);

    /** The overload or intercept method invoker. */
    private static final MethodHandle stringlize$1978323892= invoker("stringlize", int.class, Consumer.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final Field updater(String name)  {
        try {
            Field field = MultiIntercepts.class.getDeclaredField(name);
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
    private static final Field sizeField = updater("size");

    /** The fast final property updater. */
    private static final MethodHandle sizeUpdater = handler(sizeField);

    /** The final property updater. */
    private static final Field valueField = updater("value");

    /** The fast final property updater. */
    private static final MethodHandle valueUpdater = handler(valueField);

    /** The exposed property. */
    public final int size;

    /** The exposed property. */
    public final String value;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MultiIntercepts() {
        this.size = 0;
        this.value = super.value();
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
            if (NATIVE) {
                sizeField.setInt(this, (int) stringlize$1978323892.invoke(this, checkLower$101354429.invoke(this, value), (Consumer<String>) this::setValue));
            } else {
                sizeUpdater.invoke(this, stringlize$1978323892.invoke(this, checkLower$101354429.invoke(this, value), (Consumer<String>) this::setValue));
            }
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
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
            value = super.value();
        }
        try {
            valueUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("MultiIntercepts [");
        builder.append("size=").append(size).append(", ");
        builder.append("value=").append(value).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, value);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MultiIntercepts == false) {
            return false;
        }

        MultiIntercepts other = (MultiIntercepts) o;
        if (size != other.size) return false;
        if (!Objects.equals(value, other.value)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link MultiIntercepts}  builder methods.
     */
    public static class Ìnstantiator<Self extends MultiIntercepts & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link MultiIntercepts} with the specified size property.
         * 
         * @return The next assignable model.
         */
        public Self size(int size) {
            Åssignable o = new Åssignable();
            o.size(size);
            return (Self)o;
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
            ((MultiIntercepts) this).setSize(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends MultiIntercepts> {

        /**
         * Assign value property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next value(String value) {
            ((MultiIntercepts) this).setValue(value);
            return (Next) this;
        }
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MultiIntercepts implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Value = "value";
    }
}
