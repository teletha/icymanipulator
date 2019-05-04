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
@Retention(RetentionPolicy.RUNTIME)
public @interface Icy {

    @Documented
    @Target(ElementType.FIELD)
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
    @interface Companion {
    }
}
