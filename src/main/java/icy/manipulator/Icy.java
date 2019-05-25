/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Icy {

    /**
     * Configure whether the generated class is package private or not. (default is false, the
     * generated class has public visibility)
     * 
     * @return false means public (default), true means package-private.
     */
    boolean packagePrivate()

    default false;

    /**
     * Configure the name of model builder. (default is "with").
     * 
     * @return
     */
    String builder()

    default "with";

    /**
     * Configure the regular expression for model class naming. The first back reference ($1) will
     * be used.
     * 
     * @return A default pattern is "(.+)Model".
     */
    String modelNamePattern()

    default "(.+)Model";

    /**
     * Configure the modifier of classic style getter method.
     * 
     * @return "private"
     */
    String getterModifier()

    default "private final";

    /**
     * Configure the modifier of classic style setter method.
     * 
     * @return "private"
     */
    String setterModifier()

    default "private final";

    /**
     * Configure the grouping size of first required properties.
     * 
     * @return
     */
    int grouping()

    default 1;

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Property {

        /**
         * Configure whther this property accepts null value or not.
         * 
         * @return false
         */
        boolean nullable() default false;

        /**
         * Configure the mutability of property.
         * 
         * @return false
         */
        boolean mutable() default false;

        /**
         * Configure whether enum values are overloaded automatically.
         * 
         * @return true
         */
        boolean overloadEnum() default true;

        /**
         * Configure the modifier of classic style setter method.
         * 
         * @return {@link Icy#setterModifier()}
         */
        String getterModifier() default "cascade";

        /**
         * Configure the modifier of classic style setter method.
         * 
         * @return {@link Icy#setterModifier()}
         */
        String setterModifier() default "cascade";

        /**
         * Customize property.
         * 
         * @return
         */
        Class<? extends Supplier> custom() default Supplier.class;
    }

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Intercept {
        /**
         * The target property name to intercept the invokation of setter.
         * 
         * @return
         */
        String value();
    }

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Overload {
        /**
         * The target property name to define overload setter.
         * 
         * @return
         */
        String value();
    }
}
