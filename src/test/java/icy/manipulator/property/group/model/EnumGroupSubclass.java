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
            Method method = EnumGroupSubclassModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw quiet(e);
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
            throw quiet(e);
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
     * Namespace for {@link EnumGroupSubclass}  builder methods.
     */
    public static final class Ìnstantiator<Self extends EnumGroupSubclass & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link EnumGroupSubclass} with the specified color property.
         * 
         * @return The next assignable model.
         */
        public final Self color(Color color, int size) {
            Åssignable o = new Åssignable();
            o.color(color);
            o.size(size);
            return (Self) o;
        }

        /**
         * Create new {@link EnumGroupSubclass} with the specified color property.
         * 
         * @return The next assignable model.
         */
        public final Self red(int size) {
            Åssignable o = new Åssignable();
            o.red();
            o.size(size);
            return (Self) o;
        }

        /**
         * Create new {@link EnumGroupSubclass} with the specified color property.
         * 
         * @return The next assignable model.
         */
        public final Self blue(int size) {
            Åssignable o = new Åssignable();
            o.blue();
            o.size(size);
            return (Self) o;
        }

        /**
         * Create new {@link EnumGroupSubclass} with the specified color property.
         * 
         * @return The next assignable model.
         */
        public final Self green(int size) {
            Åssignable o = new Åssignable();
            o.green();
            o.size(size);
            return (Self) o;
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
    protected static interface ÅssignableAll extends EnumGroup.ÅssignableAll {
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
