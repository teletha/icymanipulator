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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class PropetyInfo<T> {

    private HashMap<Property, List<T>> map = new HashMap();

    void add(Property property, T item) {
        map.computeIfAbsent(property, p -> new LinkedList<T>()).add(item);
    }

    List<T> get(Property property) {
        return map.computeIfAbsent(property, p -> new LinkedList());
    }
}
