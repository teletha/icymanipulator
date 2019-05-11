/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
    boolean packagePrivate() default false;

    /**
     * Configure the name of model builder. (default is "with").
     * 
     * @return
     */
    String builder() default "with";

    /**
     * Configure the regular expression for model class naming. The first back reference ($1) will
     * be used.
     * 
     * @return A default pattern is "(.+)Model".
     */
    String modelNamePattern() default "(.+)Model";

    /**
     * Configure the modifier of classic style setter method.
     * 
     * @return "private"
     */
    String classicSetterModifier() default "private";

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Property {

        /**
         * Configure the mutability of property.
         * 
         * @return false
         */
        boolean mutable() default false;
    }

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Derive {
        String[] by();

        String[] to();
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
        String value() default "";
    }
}
