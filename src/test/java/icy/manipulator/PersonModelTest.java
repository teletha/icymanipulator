/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import static com.google.common.truth.Truth.*;
import static com.google.testing.compile.JavaSourceSubjectFactory.*;

import java.nio.file.Paths;

import org.junit.Test;

import com.google.testing.compile.JavaFileObjects;

/**
 * @version 2015/06/02 16:43:02
 */
public class PersonModelTest {

    @Test
    public void testProcess() throws Exception {
        // Compiler option coming soon.
        // https://github.com/google/compile-testing/pull/64

        assert_().about(javaSource())
                .that(JavaFileObjects.forResource(Paths.get("src/test/java/icy/manipulator/HelloWorld.java")
                        .toAbsolutePath()
                        .toUri()
                        .toURL()))
                .processedWith(new IcyManipulator())
                .compilesWithoutError()
                .and()
                .generatesSources(JavaFileObjects
                        .forSourceString("icy.manipulator.Blah", "package icy.manipulator;\n" + "\n" + "import java.lang.String;\n" + "import javax.annotation.Generated;\n" + "\n" + "@Generated({\"me.geso.sample.hello.MyProcessor\"})\n" + "public class Blah {\n" + "  public String hello() {\n" + "    return \"hello\";\n" + "  }\n" + "}"));
    }
}
