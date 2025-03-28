/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.generic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import icy.manipulator.Icy;

@Icy
public abstract class WildcardModel {

    @Icy.Property
    public Class<? extends Collection> extendType() {
        return List.class;
    }

    @Icy.Property
    public List<? super Integer> superType() {
        return new ArrayList();
    }

    @Icy.Property
    public Supplier<?> wildcard() {
        return () -> 1;
    }

    @Icy.Property
    public Map<? extends CharSequence, List<Class<? extends Number>>> combine() {
        return new HashMap();
    }

    @Icy.Property
    public Class<? extends Member> memberType() {
        return Member.class;
    }

    public static abstract class Member {
    }
}