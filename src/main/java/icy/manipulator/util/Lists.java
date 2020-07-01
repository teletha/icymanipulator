/*
 * Copyright (C) 2020 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.util;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    /**
     * Helper.
     * 
     * @param one
     * @param other
     * @return
     */
    public static <T> List<T> merge(List<T> one, List<T> other) {
        List merged = new ArrayList(one.size() + other.size());
        merged.addAll(one);
        merged.addAll(other);

        return merged;
    }
}