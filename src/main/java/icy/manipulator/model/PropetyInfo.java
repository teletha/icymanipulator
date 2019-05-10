/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PropetyInfo<T> {

    private HashMap<PropertyDefinition, List<T>> map = new HashMap();

    public void add(PropertyDefinition property, T item) {
        map.computeIfAbsent(property, p -> new LinkedList<T>()).add(item);
    }

    public List<T> get(PropertyDefinition property) {
        return map.computeIfAbsent(property, p -> new LinkedList());
    }
}
