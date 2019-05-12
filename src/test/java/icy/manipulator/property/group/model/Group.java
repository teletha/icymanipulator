/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.group.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link GroupModel}.
 */
@Generated("Icy Manipulator")
public abstract class Group extends GroupModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Group.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle xUpdater = updater("x");

    /** The final property updater. */
    private static final MethodHandle yUpdater = updater("y");

    /** The final property updater. */
    private static final MethodHandle zUpdater = updater("z");

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
     * Retrieve x property.
     */
    @Override
    public final int x() {
        return this.x;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getX() {
        return this.x;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setX(int value) {
        ((ÅssignableX) this).x(value);
    }

    /**
     * Retrieve y property.
     */
    @Override
    public final int y() {
        return this.y;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getY() {
        return this.y;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setY(int value) {
        ((ÅssignableY) this).y(value);
    }

    /**
     * Retrieve z property.
     */
    @Override
    public final int z() {
        return this.z;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final int getZ() {
        return this.z;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setZ(int value) {
        ((ÅssignableZ) this).z(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link Group}.
     */
    public static final class Ìnstantiator<Self extends Group & ÅssignableÅrbitrary<Self>> {
        /**
         * Create uninitialized {@link Group}.
         */
        public final <T extends ÅssignableZ<Self>> T x(int $int, int $int1) {
            Åssignable o = new Åssignable();
            o.x($int);
            o.y($int1);
            return (T) o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableX<Next> {
        /**
         * The base setter.
         */
        default Next x(int value) {
            try {
                xUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableY<Next> {
        /**
         * The base setter.
         */
        default Next y(int value) {
            try {
                yUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableZ<Next> {
        /**
         * The base setter.
         */
        default Next z(int value) {
            try {
                zUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
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
