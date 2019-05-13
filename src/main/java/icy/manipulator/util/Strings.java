/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.util;

import javax.lang.model.SourceVersion;

public class Strings {

    /**
     * Decapitalize text.
     * 
     * @param value
     * @return
     */
    public static String capitalize(String value) {
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

    /**
     * Decapitalize text.
     * 
     * @param value
     * @return
     */
    public static String decapitalize(String value) {
        if (value.toUpperCase().equals(value)) {
            return value.toLowerCase();
        }
        return Character.toLowerCase(value.charAt(0)) + value.substring(1);
    }

    /**
     * Sanitize java keyword.
     * 
     * @param value
     * @return
     */
    public static String sanitize(String value) {
        if (SourceVersion.isKeyword(value)) {
            return "$" + value;
        } else {
            return value;
        }
    }

}