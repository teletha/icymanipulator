package icy.manipulator.property.custom;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link ImplementationVisibilityModel}.
 */
@Generated("Icy Manipulator")
class ImplementationVisibility extends ImplementationVisibilityModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle updater(String name, Class... parameterTypes)  {
        try {
            Method method = ImplementationVisibilityModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = ImplementationVisibility.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The exposed property. */
    public final String name;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ImplementationVisibility(String name) {
        this.name = name;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Builder namespace for {@link ImplementationVisibility}.
     */
    public static final class with {

        /**
         * Create uninitialized {@link ImplementationVisibility}.
         */
        public static final <T extends ImplementationVisibility> T name(String value) {
            return (T) new Åssignable(value);
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends ImplementationVisibility implements ÅssignableName {
        private Åssignable(String name) {
            super(name);
        }

        /**
         * Modify name property.
         */
        @Override
        public final <T extends ImplementationVisibility> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * .
     */
    public static interface ÅssignableName {
        <T extends ImplementationVisibility> T name(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
    }
}
