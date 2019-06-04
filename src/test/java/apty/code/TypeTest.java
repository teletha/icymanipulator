/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty.code;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TypeTest {

    Coder coder = new Coder("test");

    @Test
    void variable() {
        Type type = Type.literal("K");
        assert type.write(coder).equals("K");
    }

    @Test
    void variableExtend() {
        Type Char = Type.of(CharSequence.class);
        Type type = Type.literal("K extends ", Char);
        assert type.write(coder).equals("K extends CharSequence");
    }

    @Test
    void genericType() {
        Type list = Type.of(List.class);
        Type string = Type.of(String.class);
        Type type = Type.literal(list, "<", string, ">");
        assert type.write(coder).equals("List<String>");
    }

    @Test
    void genericTypes() {
        Type map = Type.of(Map.class);
        Type string = Type.of(String.class);
        Type type = Type.literal(map, "<", string, ",", string, ">");
        assert type.write(coder).equals("Map<String, String>");
    }

    @Test
    void genericTypeVariable() {
        Type list = Type.of(List.class);
        Type type = Type.literal(list, "<T>");
        assert type.write(coder).equals("List<T>");
    }

    @Test
    void genericTypeVariableExtend() {
        Type list = Type.of(List.class);
        Type Char = Type.of(CharSequence.class);
        Type type = Type.literal(list, "<T extends ", Char, ">");
        assert type.write(coder).equals("List<T extends CharSequence>");
    }

    @Test
    void genericTypesVariableExtend() {
        Type map = Type.of(Map.class);
        Type Char = Type.of(CharSequence.class);
        Type type = Type.literal(map, "<T extends ", Char, ", S extends", Char, ">");
        assert type.write(coder).equals("List<T extends CharSequence, S extends CharSequence>");
    }
}
