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
@Retention(RetentionPolicy.CLASS)
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

    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Property {
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
