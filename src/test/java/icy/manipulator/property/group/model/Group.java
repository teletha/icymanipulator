package icy.manipulator.property.group.model;

import icy.manipulator.property.group.model.Group;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Generated model for {@link GroupModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class Group extends GroupModel {

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
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final Field updater(String name)  {
        try {
            Field field = Group.class.getDeclaredField(name);
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
    private static final Field xField = updater("x");

    /** The fast final property updater. */
    private static final MethodHandle xUpdater = handler(xField);

    /** The final property updater. */
    private static final Field yField = updater("y");

    /** The fast final property updater. */
    private static final MethodHandle yUpdater = handler(yField);

    /** The final property updater. */
    private static final Field zField = updater("z");

    /** The fast final property updater. */
    private static final MethodHandle zUpdater = handler(zField);

    /** The exposed property. */
    public final int x;

    /** The exposed property. */
    public final int y;

    /** The exposed property. */
    public final int z;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Group() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Return the x property.
     *
     * @return A value of x property.
     */
    @Override
    public final int x() {
        return this.x;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of x property.
     */
    @SuppressWarnings("unused")
    private final int getX() {
        return this.x;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of x property to assign.
     */
    private final void setX(int value) {
        try {
            if (NATIVE) {
                xField.setInt(this, (int) value);
            } else {
                xUpdater.invoke(this, value);
            }
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the y property.
     *
     * @return A value of y property.
     */
    @Override
    public final int y() {
        return this.y;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of y property.
     */
    @SuppressWarnings("unused")
    private final int getY() {
        return this.y;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of y property to assign.
     */
    private final void setY(int value) {
        try {
            if (NATIVE) {
                yField.setInt(this, (int) value);
            } else {
                yUpdater.invoke(this, value);
            }
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the z property.
     *
     * @return A value of z property.
     */
    @Override
    public final int z() {
        return this.z;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of z property.
     */
    @SuppressWarnings("unused")
    private final int getZ() {
        return this.z;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of z property to assign.
     */
    private final void setZ(int value) {
        try {
            if (NATIVE) {
                zField.setInt(this, (int) value);
            } else {
                zUpdater.invoke(this, value);
            }
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
        StringBuilder builder = new StringBuilder("Group [");
        builder.append("x=").append(x).append(", ");
        builder.append("y=").append(y).append(", ");
        builder.append("z=").append(z).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Group == false) {
            return false;
        }

        Group other = (Group) o;
        if (x != other.x) return false;
        if (y != other.y) return false;
        if (z != other.z) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link Group}  builder methods.
     */
    public static class Ìnstantiator<Self extends Group & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link Group} with the specified x property.
         * 
         * @return The next assignable model.
         */
        public ÅssignableZ<Self> x(int x, int y) {
            Åssignable o = new Åssignable();
            o.x(x);
            o.y(y);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableX<Next> {

        /**
         * Assign x property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next x(int value) {
            ((Group) this).setX(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableY<Next> {

        /**
         * Assign y property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next y(int value) {
            ((Group) this).setY(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableZ<Next> {

        /**
         * Assign z property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next z(int value) {
            ((Group) this).setZ(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Group> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableX, ÅssignableY, ÅssignableZ {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Group implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String X = "x";
        static final String Y = "y";
        static final String Z = "z";
    }
}
