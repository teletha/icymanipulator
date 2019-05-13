package icy.manipulator.property.group.model;

import icy.manipulator.property.group.model.EnumGroupModel.Color;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link EnumGroupSubclassModel}.
 */
@Generated("Icy Manipulator")
public abstract class EnumGroupSubclass extends EnumGroupSubclassModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = EnumGroupSubclassModel.class.getDeclaredMethod(name, parameterTypes);
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
            Field field = EnumGroupSubclass.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /**
     * HIDE CONSTRUCTOR
     */
    protected EnumGroupSubclass() {
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link EnumGroupSubclass}.
     */
    public static final class Ìnstantiator<Self extends EnumGroupSubclass & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link EnumGroupSubclass}.
         */
        public final <T extends Self> T color(Color color, int $int) {
            Åssignable o = new Åssignable();
            o.color(color);
            o.size($int);
            return (T) o;
        }
        /**
         * Create uninitialized {@link EnumGroupSubclass}.
         */
        public final <T extends Self> T red(int $int) {
            Åssignable o = new Åssignable();
            o.red();
            o.size($int);
            return (T) o;
        }
        /**
         * Create uninitialized {@link EnumGroupSubclass}.
         */
        public final <T extends Self> T blue(int $int) {
            Åssignable o = new Åssignable();
            o.blue();
            o.size($int);
            return (T) o;
        }
        /**
         * Create uninitialized {@link EnumGroupSubclass}.
         */
        public final <T extends Self> T green(int $int) {
            Åssignable o = new Åssignable();
            o.green();
            o.size($int);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends EnumGroupSubclass> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends icy.manipulator.property.group.model.EnumGroup.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends EnumGroupSubclass implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
    }
}
