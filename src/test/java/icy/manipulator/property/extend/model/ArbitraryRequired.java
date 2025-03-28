/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.extend.model;

import icy.manipulator.property.base.model.Arbitrary;
import icy.manipulator.property.extend.model.ArbitraryRequired;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Generated model for {@link ArbitraryRequiredModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class ArbitraryRequired extends ArbitraryRequiredModel {

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
            Field field = ArbitraryRequired.class.getDeclaredField(name);
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
    private static final Field idField = updater("id");

    /** The fast final property updater. */
    private static final MethodHandle idUpdater = handler(idField);

    /** The exposed property. */
    public final long id;

    /**
     * HIDE CONSTRUCTOR
     */
    protected ArbitraryRequired() {
        this.id = 0L;
    }

    /**
     * Return the id property.
     *
     * @return A value of id property.
     */
    @Override
    public final long id() {
        return this.id;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of id property.
     */
    @SuppressWarnings("unused")
    private final long getId() {
        return this.id;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of id property to assign.
     */
    private final void setId(long value) {
        try {
            if (NATIVE) {
                idField.setLong(this, (long) value);
            } else {
                idUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("ArbitraryRequired [");
        builder.append("id=").append(id).append(", ");
        builder.append("optionNum=").append(optionNum).append(", ");
        builder.append("optionComment=").append(optionComment).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, optionNum, optionComment);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ArbitraryRequired == false) {
            return false;
        }

        ArbitraryRequired other = (ArbitraryRequired) o;
        if (id != other.id) return false;
        if (optionNum != other.optionNum) return false;
        if (!Objects.equals(optionComment, other.optionComment)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link ArbitraryRequired}  builder methods.
     */
    public static class Ìnstantiator<Self extends ArbitraryRequired & ÅssignableÅrbitrary<Self>> extends icy.manipulator.property.base.model.Arbitrary.Ìnstantiator {

        /**
         * Create new {@link ArbitraryRequired} with the specified id property.
         * 
         * @return The next assignable model.
         */
        public Self id(long id) {
            Åssignable o = new Åssignable();
            o.id(id);
            return (Self)o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableId<Next> {

        /**
         * Assign id property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next id(long value) {
            ((ArbitraryRequired) this).setId(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends ArbitraryRequired> extends Arbitrary.ÅssignableÅrbitrary<Next> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableId, Arbitrary.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends ArbitraryRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Id = "id";
    }
}