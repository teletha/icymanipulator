/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

public final class Initializer {

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @return A initial 0 value.
     */
    public static int Int() {
        return 0;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @param value A initial value.
     * @return A initial value.
     */
    public static int Int(int value) {
        return value;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @return A initial 0 value.
     */
    public static long Long() {
        return 0;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @param value A initial value.
     * @return A initial value.
     */
    public static long Long(long value) {
        return value;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @return A initial 0 value.
     */
    public static float Float() {
        return 0;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @param value A initial value.
     * @return A initial value.
     */
    public static float Float(float value) {
        return value;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @return A initial 0 value.
     */
    public static double Double() {
        return 0;
    }

    /**
     * Specify initial value to avoid compiler inlining.
     * 
     * @param value A initial value.
     * @return A initial value.
     */
    public static double Double(double value) {
        return value;
    }
}
