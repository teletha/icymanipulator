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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import apty.Apty;
import apty.Type;
import icy.manipulator.util.Strings;

public class Synthesizer {

    /** The synthesized methods. */
    public final List<MethodInfo> methods = new ArrayList();

    /**
     * @param m
     * @param p
     */
    public Synthesizer(ModelInfo m, PropertyInfo p) {
        // basic setter
        add(new MethodInfo(p.name, m.implType).withLast(p.type, p.name));

        if (m.firstRequiredProperty().equals(Optional.of(p))) {
            // first property will accept all overload methods unconditionally

            // overload setter
            for (MethodInfo overload : m.findOverloadsFor(p)) {
                add(overload);
            }

            // auto-expanded overload
            if (p.autoExpandable) {
                for (String name : Apty.enumConstantNames(p.element.getReturnType())) {
                    add(new MethodInfo(Strings.decapitalize(name), Type.generic("Next"), List.of(), List
                            .of(), "Set " + p.name + " property with " + name + "."));
                }
            }
        } else {
            // rest propreties will accept pattern-matched overload methods only

            // overload setter
            for (MethodInfo overload : m.findOverloadsFor(p)) {
                // check name
                if (!overload.name.equals(p.name)) {
                    continue;
                }

                // check overload method parameter size
                if (overload.paramTypes.size() != 1) {
                    continue;
                }

                // overload method parmeter type must NOT be the same type of property
                if (overload.paramTypes.get(0).equals(p.type)) {
                    continue;
                }
                add(overload);
            }
        }
    }

    /**
     * @param methods
     */
    Synthesizer(MethodInfo... definitions) {
        for (MethodInfo method : definitions) {
            add(method);
        }
    }

    private void add(MethodInfo definition) {
        if (!methods.contains(definition)) {
            methods.add(definition);
        }
    }

    /**
     * Synthesize method.
     * 
     * @param other
     * @return
     */
    public Synthesizer synthesize(Synthesizer other) {
        Synthesizer synthesized = new Synthesizer();

        for (MethodInfo method : methods) {
            for (MethodInfo otherMethod : other.methods) {
                String otherName = otherMethod.paramNames.get(0);

                // check name duplication
                int randomize = 0;
                String randomized = otherName;
                while (method.paramNames.contains(randomized)) {
                    randomized = otherName + ++randomize;
                }

                synthesized.methods.add(method.withLast(otherMethod.paramTypes.get(0), randomized));
            }
        }
        return synthesized;
    }
}