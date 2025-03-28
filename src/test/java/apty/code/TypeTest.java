/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty.code;

import org.junit.jupiter.api.Test;

class TypeTest {

    @Test
    void resolve() throws ClassNotFoundException {
        assert Type.resolve("java.lang.String") == String.class;
        assert Type.resolve("int") == int.class;
        assert Type.resolve("long") == long.class;
        assert Type.resolve("float") == float.class;
        assert Type.resolve("double") == double.class;
        assert Type.resolve("char") == char.class;
        assert Type.resolve("byte") == byte.class;
        assert Type.resolve("short") == short.class;
        assert Type.resolve("boolean") == boolean.class;
        assert Type.resolve("void") == void.class;

        assert Type.resolve("java.lang.String[]") == String[].class;
        assert Type.resolve("int[]") == int[].class;
        assert Type.resolve("long[]") == long[].class;
        assert Type.resolve("float[]") == float[].class;
        assert Type.resolve("double[]") == double[].class;
        assert Type.resolve("char[]") == char[].class;
        assert Type.resolve("byte[]") == byte[].class;
        assert Type.resolve("short[]") == short[].class;
        assert Type.resolve("boolean[]") == boolean[].class;

        assert Type.resolve("java.lang.String[][]") == String[][].class;
        assert Type.resolve("int[][]") == int[][].class;
        assert Type.resolve("long[][]") == long[][].class;
        assert Type.resolve("float[][]") == float[][].class;
        assert Type.resolve("double[][]") == double[][].class;
        assert Type.resolve("char[][]") == char[][].class;
        assert Type.resolve("byte[][]") == byte[][].class;
        assert Type.resolve("short[][]") == short[][].class;
        assert Type.resolve("boolean[][]") == boolean[][].class;
    }
}