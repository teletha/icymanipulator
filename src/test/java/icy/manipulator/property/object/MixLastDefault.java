package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link MixLastDefaultModel}.
 */
@Generated("Icy Manipulator")
public abstract class MixLastDefault extends MixLastDefaultModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = MixLastDefault.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle ageUpdater = updater("age");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final int age;

    /**
     * HIDE CONSTRUCTOR
     */
    protected MixLastDefault() {
        this.name = null;
        this.age = super.age();
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
    private final void setName(String value) {
        ((ÅssignableName) this).name(value);
    }

    /**
     * Retrieve age property.
     */
    @Override
    public final int age() {
        return this.age;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getAge() {
        return this.age;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setAge(int value) {
        ((ÅssignableÅrbitrary) this).age(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link MixLastDefault}.
     */
    public static class Ìnstantiator<Self extends icy.manipulator.property.object.MixLastDefault & ÅssignableÅrbitrary<Self>> {

        /** Create Uninitialized {@link MixLastDefault}. */
        public final <T extends Self> T name(String value) {
            return (T) base().name(value);
        }
        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableName<Next> {

        /**
         * The setter.
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
    public static interface ÅssignableÅrbitrary<Next extends MixLastDefault> {

        /**
         * Property assignment API.
         */
        default Next age(int value) {
            try {
                ageUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Internal assignment API.
     */
    protected static interface ÅssignableAll extends ÅssignableName {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends MixLastDefault implements ÅssignableAll, ÅssignableÅrbitrary<Åssignable> {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Age = "age";
    }
}
