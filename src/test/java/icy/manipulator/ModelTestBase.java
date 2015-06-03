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

import icy.manipulator.compiler.SourceFile;

/**
 * @version 2015/06/03 11:02:49
 */
public abstract class ModelTestBase {

    /**
     * <p>
     * Test code generation.
     * </p>
     * 
     * @param sourceModel
     * @param expectedModel
     */
    protected void testCodeGeneration(Class sourceModel, Class expectedModel) {
        SourceFile source = SourceFile.of(sourceModel);
        SourceFile expected = SourceFile.of(expectedModel);

        assert_().about(javaSource())
                .that(source)
                .processedWith(new IcyManipulator())
                .compilesWithoutError()
                .and()
                .generatesSources(expected);
    }
}
