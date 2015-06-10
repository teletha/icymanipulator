/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.ast;

import static com.google.common.truth.Truth.*;
import static com.google.testing.compile.JavaSourceSubjectFactory.*;

import org.junit.Test;

import icy.manipulator.compiler.SourceFile;

/**
 * @version 2015/06/10 18:27:02
 */
public class ASTTest {

    @Test
    public void testname() throws Exception {
        testCodeGeneration(ASTUser.class, ASTUser.class);
    }

    /**
     * <p>
     * Test code generation.
     * </p>
     * 
     * @param sourceModel
     * @param expectedModel
     */
    private void testCodeGeneration(Class sourceModel, Class expectedModel) {
        SourceFile source = SourceFile.of(sourceModel);
        SourceFile expected = SourceFile.of(expectedModel);

        assert_().about(javaSource()).that(source).processedWith(new ASTManipulator()).compilesWithoutError();
    }
}
