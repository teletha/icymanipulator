package icy.manipulator.property.extend;

import icy.manipulator.property.object.Default;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link DefaultThenRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class DefaultThenRequired extends DefaultThenRequiredModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = DefaultThenRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle idUpdater = updater("id");

    /** The exposed property. */
    public final long id;

    /**
     * HIDE CONSTRUCTOR
     */
    protected DefaultThenRequired() {
        this.id = 0L;
    }

    /**
     * Retrieve id property.
     */
    @Override
    public final long id() {
        return this.id;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final long getId() {
        return this.id;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private final void setId(long value) {
        ((ÅssignableId) this).id(value);
    }

    /** The singleton builder. */
    public static final  ÌnstantiatorTyped<?> with = new ÌnstantiatorTyped();

    public static final class ÌnstantiatorTyped<Self extends DefaultThenRequired & ÅssignableÅrbitrary<Self>> extends Ìnstantiator<Self> {
    }

    /**
     * Builder namespace for {@link DefaultThenRequired}.
     */
    protected static class Ìnstantiator<Self> extends Default.Ìnstantiator<ÅssignableId<Self>> {

        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableId<Next> {

        /**
         * The setter.
         */
        default Next id(long value) {
            try {
                idUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends DefaultThenRequired> extends icy.manipulator.property.object.Default.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableId, Default.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends DefaultThenRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Id = "id";
    }
}
