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

import org.junit.Test;

import icy.manipulator.compiler.SourceFile;
import icy.manipulator.model.Person;
import icy.manipulator.model.PersonModel;

/**
 * @version 2015/06/02 16:43:02
 */
public class PersonModelTest {

    @Test
    public void testProcess() throws Exception {
        SourceFile source = SourceFile.of(PersonModel.class);
        SourceFile expected = SourceFile.of(Person.class);

        assert_().about(javaSource())
                .that(source)
                .processedWith(new IcyManipulator())
                .compilesWithoutError()
                .and()
                .generatesSources(expected);
    }
}
