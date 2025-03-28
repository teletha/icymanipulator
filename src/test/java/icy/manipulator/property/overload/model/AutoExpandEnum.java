/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.overload.model;

import icy.manipulator.property.overload.model.AutoExpandEnum;
import java.lang.Override;
import java.lang.StringBuilder;
import java.lang.Throwable;
import java.lang.UnsupportedOperationException;
import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Generated model for {@link AutoExpandEnumModel}.
 * 
 * @see <a href="https://github.com/teletha/icymanipulator">Icy Manipulator (Code Generator)</a>
 */
public class AutoExpandEnum extends AutoExpandEnumModel {

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
            Field field = AutoExpandEnum.class.getDeclaredField(name);
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
    private static final Field answerField = updater("answer");

    /** The fast final property updater. */
    private static final MethodHandle answerUpdater = handler(answerField);

    /** The final property updater. */
    private static final Field policyField = updater("policy");

    /** The fast final property updater. */
    private static final MethodHandle policyUpdater = handler(policyField);

    /** The exposed property. */
    public final Answer answer;

    /** The exposed property. */
    public final RetentionPolicy policy;

    /**
     * HIDE CONSTRUCTOR
     */
    protected AutoExpandEnum() {
        this.answer = null;
        this.policy = null;
    }

    /**
     * Return the answer property.
     *
     * @return A value of answer property.
     */
    @Override
    public final icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer answer() {
        return this.answer;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of answer property.
     */
    @SuppressWarnings("unused")
    private final icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer getAnswer() {
        return this.answer;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of answer property to assign.
     */
    private final void setAnswer(icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer value) {
        if (value == null) {
            throw new IllegalArgumentException("The answer property requires non-null value.");
        }
        try {
            answerUpdater.invoke(this, value);
        } catch (UnsupportedOperationException e) {
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Return the policy property.
     *
     * @return A value of policy property.
     */
    @Override
    public final RetentionPolicy policy() {
        return this.policy;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of policy property.
     */
    @SuppressWarnings("unused")
    private final RetentionPolicy getPolicy() {
        return this.policy;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of policy property to assign.
     */
    private final void setPolicy(RetentionPolicy value) {
        if (value == null) {
            throw new IllegalArgumentException("The policy property requires non-null value.");
        }
        try {
            policyUpdater.invoke(this, value);
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
        StringBuilder builder = new StringBuilder("AutoExpandEnum [");
        builder.append("answer=").append(answer).append(", ");
        builder.append("policy=").append(policy).append("]");
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(answer, policy);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof AutoExpandEnum == false) {
            return false;
        }

        AutoExpandEnum other = (AutoExpandEnum) o;
        if (!Objects.equals(answer, other.answer)) return false;
        if (!Objects.equals(policy, other.policy)) return false;
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link AutoExpandEnum}  builder methods.
     */
    public static class Ìnstantiator<Self extends AutoExpandEnum & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignablePolicy<Self> answer(icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer answer) {
            Åssignable o = new Åssignable();
            o.answer(answer);
            return o;
        }

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignablePolicy<Self> yes() {
            Åssignable o = new Åssignable();
            o.yes();
            return o;
        }

        /**
         * Create new {@link AutoExpandEnum} with the specified answer property.
         * 
         * @return The next assignable model.
         */
        public ÅssignablePolicy<Self> no() {
            Åssignable o = new Åssignable();
            o.no();
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableAnswer<Next> {

        /**
         * Assign answer property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next answer(icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer value) {
            ((AutoExpandEnum) this).setAnswer(value);
            return (Next) this;
        }

        /**
         * Assign answer property.
         * 
         * @return The next assignable model.
         */
        default Next yes() {
            return answer(icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer.Yes);
        }

        /**
         * Assign answer property.
         * 
         * @return The next assignable model.
         */
        default Next no() {
            return answer(icy.manipulator.property.overload.model.AutoExpandEnumModel.Answer.No);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignablePolicy<Next> {

        /**
         * Assign policy property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next policy(RetentionPolicy value) {
            ((AutoExpandEnum) this).setPolicy(value);
            return (Next) this;
        }

        /**
         * Assign policy property.
         * 
         * @return The next assignable model.
         */
        default Next source() {
            return policy(RetentionPolicy.SOURCE);
        }

        /**
         * Assign policy property.
         * 
         * @return The next assignable model.
         */
        default Next CLASS() {
            return policy(RetentionPolicy.CLASS);
        }

        /**
         * Assign policy property.
         * 
         * @return The next assignable model.
         */
        default Next runtime() {
            return policy(RetentionPolicy.RUNTIME);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends AutoExpandEnum> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableAnswer, ÅssignablePolicy {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends AutoExpandEnum implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Answer = "answer";
        static final String Policy = "policy";
    }
}