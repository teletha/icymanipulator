package icy.manipulator.property.group.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OverloadGroupModel}.
 */
@Generated("Icy Manipulator")
public abstract class OverloadGroup extends OverloadGroupModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = OverloadGroupModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload or intercept method invoker. */
    private static final MethodHandle sizeString= invoker("size", String.class);

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = OverloadGroup.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final int size;

    /**
     * HIDE CONSTRUCTOR
     */
    protected OverloadGroup() {
        this.name = null;
        this.size = 0;
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setName(String value) {
        ((ÅssignableName) this).name(value);
    }

    /**
     * Retrieve size property.
     */
    @Override
    public final int size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setSize(int value) {
        ((ÅssignableSize) this).size(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link OverloadGroup}.
     */
    public static final class Ìnstantiator<Self extends OverloadGroup & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link OverloadGroup}.
         */
        public final <T extends Self> T name(String string, int $int) {
            Åssignable o = new Åssignable();
            o.name(string);
            o.size($int);
            return (T) o;
        }
        /**
         * Create uninitialized {@link OverloadGroup}.
         */
        public final <T extends Self> T name(String string, String value) {
            Åssignable o = new Åssignable();
            o.name(string);
            o.size(value);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {
        /**
         * The base setter.
         */
        default Next name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {
        /**
         * The base setter.
         */
        default Next size(int value) {
            try {
                sizeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * The overload setter.
         */
        default Next size(String value) {
            try {
                return size((int) sizeString.invoke(this, value));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends OverloadGroup> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableName, ÅssignableSize {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends OverloadGroup implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Size = "size";
    }
}
