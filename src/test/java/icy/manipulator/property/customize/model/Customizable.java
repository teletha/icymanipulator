package icy.manipulator.property.customize.model;

import icy.manipulator.property.customize.model.CustomizableModel.Customizer;
import icy.manipulator.property.customize.model.CustomizableModel.SubCustomizer;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.function.Supplier;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link CustomizableModel}.
 */
@Generated("Icy Manipulator")
public abstract class Customizable extends CustomizableModel {

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
            Field field = Customizable.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle valueUpdater = updater("value");

    /** The exposed property. */
    public final String name;

    /** The property customizer. */
    private final Customizer<String> nameCustomizer = new Customizer<String>() {

        @Override
        public String get() {
            return name;
        }
    };

    /** The exposed property. */
    public final String value;

    /** The property customizer. */
    private final SubCustomizer valueCustomizer = new SubCustomizer() {

        @Override
        public String get() {
            return value;
        }
    };

    /**
     * HIDE CONSTRUCTOR
     */
    protected Customizable() {
        this.name = null;
        this.value = null;
    }

    /**
     * Return name.
     *  
     *  @return A name.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of name property.
     */
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of name property to assign.
     */
    private final void setName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The name property requires non-null value.");
        }
        try {
            nameUpdater.invoke(this, value);
            nameCustomizer.accept(this.name);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Get value by getter.
     *  
     *  @return
     */
    public final String nameByGetter() {
        return nameCustomizer.$ByGetter();
    }

    /**
     * Get value by setter.
     *  
     *  @return
     */
    public final String nameBySetter() {
        return nameCustomizer.$BySetter();
    }

    /**
     * Get value as {@link Supplier}.
     *  
     *  @return
     */
    public final Supplier<String> nameByGetterAsSupplier() {
        return nameCustomizer.$ByGetterAsSupplier();
    }

    /**
     * Return name.
     *  
     *  @return A name.
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
            throw new IllegalArgumentException("The value property requires non-null value.");
        }
        try {
            valueUpdater.invoke(this, value);
            valueCustomizer.accept(this.value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Get value on sub.
     *  
     *  @return
     */
    public final String valueFromSub() {
        return valueCustomizer.$FromSub();
    }

    /**
     * Get value by getter.
     *  
     *  @return
     */
    public final String valueByGetter() {
        return valueCustomizer.$ByGetter();
    }

    /**
     * Get value by setter.
     *  
     *  @return
     */
    public final String valueBySetter() {
        return valueCustomizer.$BySetter();
    }

    /**
     * Get value as {@link Supplier}.
     *  
     *  @return
     */
    public final Supplier<String> valueByGetterAsSupplier() {
        return valueCustomizer.$ByGetterAsSupplier();
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Customizable}  builder methods.
     */
    public static final class Ìnstantiator<Self extends Customizable & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Customizable} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final <T extends ÅssignableValue<Self>> T name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /**
         * Assign name property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next name(String value) {
            ((Customizable) this).setName(value);
            return (Next) this;
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
            ((Customizable) this).setValue(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Customizable> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableValue {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Customizable implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Value = "value";
    }
}
