/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.tool.coder;

import java.util.StringJoiner;

public class ParameterVariable {

    /** The actual variable holder. */
    private final StringJoiner joiner = new StringJoiner(", ", "<", ">").setEmptyValue("");

    /**
     * Add variable.
     * 
     * @param variable
     * @return
     */
    public ParameterVariable add(String variable) {
        if (variable != null && !variable.isBlank()) {
            joiner.add(variable);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return joiner.toString();
    }
}
