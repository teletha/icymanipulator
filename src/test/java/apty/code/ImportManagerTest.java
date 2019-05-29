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

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.lang.model.type.DeclaredType;

import org.junit.jupiter.api.Test;

import net.florianschoppmann.java.reflect.ReflectionTypes;

class ImportManagerTest {

    ReflectionTypes types = ReflectionTypes.getInstance();

    @Test
    void base() {
        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(String.class).equals("String");
        assert manager.imports.contains("java.lang.String") == false;
    }

    @Test
    void some() {
        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(Map.class).equals("Map");
        assert manager.imports.contains("java.util.Map");
    }

    @Test
    void variable() {
        DeclaredType type = types.getDeclaredType(types.typeElement(List.class), types.typeMirror(LocalDate.class));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("List<LocalDate>");
        assert manager.imports.contains("java.util.List");
        assert manager.imports.contains("java.time.LocalDate");
    }

    @Test
    void variables() {
        DeclaredType type = types
                .getDeclaredType(types.typeElement(Map.class), types.typeMirror(String.class), types.typeMirror(LocalDate.class));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("Map<String, LocalDate>");
        assert manager.imports.contains("java.util.Map");
        assert manager.imports.contains("java.time.LocalDate");
    }

    @Test
    void variableNest() {
        DeclaredType type = types.getDeclaredType(types.typeElement(List.class), types
                .getDeclaredType(types.typeElement(Consumer.class), types.typeMirror(Method.class)));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("List<Consumer<Method>>");
        assert manager.imports.contains("java.util.List");
        assert manager.imports.contains("java.util.function.Consumer");
        assert manager.imports.contains("java.lang.reflect.Method");
    }

    @Test
    void wildcard() {
        DeclaredType type = types.getDeclaredType(types.typeElement(List.class), types.getWildcardType(null, null));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("List<?>");
        assert manager.imports.contains("java.util.List");
    }

    @Test
    void wildcardExtends() {
        DeclaredType type = types
                .getDeclaredType(types.typeElement(List.class), types.getWildcardType(types.typeMirror(CharSequence.class), null));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("List<? extends CharSequence>");
        assert manager.imports.contains("java.util.List");
    }

    @Test
    void wildcardSuper() {
        DeclaredType type = types
                .getDeclaredType(types.typeElement(List.class), types.getWildcardType(null, types.typeMirror(Function.class)));

        ImportManager manager = new ImportManager("base", "Base");
        assert manager.require(type).equals("List<? super Function>");
        assert manager.imports.contains("java.util.List");
        assert manager.imports.contains("java.util.function.Function");
    }
}
