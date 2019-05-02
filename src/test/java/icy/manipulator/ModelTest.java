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

import static com.google.common.truth.Truth.assert_;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

import org.junit.jupiter.api.Test;

import icy.manipulator.compiler.SourceFile;
import icy.manipulator.model.Couple;
import icy.manipulator.model.CoupleModel;
import icy.manipulator.model.GenericVariable;
import icy.manipulator.model.GenericVariableModel;
import icy.manipulator.model.IgnorablePropertyModel;
import icy.manipulator.model.NoPropertyModel;
import icy.manipulator.model.Person;
import icy.manipulator.model.PersonModel;
import icy.manipulator.model.Primitive;
import icy.manipulator.model.PrimitiveModel;
import icy.manipulator.model.UserDefinedDefaultValue;
import icy.manipulator.model.UserDefinedDefaultValueModel;
import icy.manipulator.model.WithInnerClass;
import icy.manipulator.model.WithInnerClassModel;
import icy.manipulator.model.WithMethod;
import icy.manipulator.model.WithMethodModel;
import icy.manipulator.tool.IcyManipulator;

/**
 * @version 2015/06/02 16:43:02
 */
public class ModelTest {

    @Test
    public void person() {
        testCodeGeneration(PersonModel.class, Person.class);
    }

    @Test
    public void couple() {
        testCodeGeneration(CoupleModel.class, Couple.class);
    }

    @Test
    public void primitive() {
        testCodeGeneration(PrimitiveModel.class, Primitive.class);
    }

    @Test
    public void genericVariable() {
        testCodeGeneration(GenericVariableModel.class, GenericVariable.class);
    }

    @Test
    public void userDefiendDefaultValue() {
        testCodeGeneration(UserDefinedDefaultValueModel.class, UserDefinedDefaultValue.class);
    }

    @Test
    public void withMethod() {
        testCodeGeneration(WithMethodModel.class, WithMethod.class);
    }

    @Test
    public void withInnerClass() {
        testCodeGeneration(WithInnerClassModel.class, WithInnerClass.class);
    }

    @Test
    public void ignorable() {
        testInvalidCodeGeneration(IgnorablePropertyModel.class, "No property.");
    }

    @Test
    public void noProperty() {
        testInvalidCodeGeneration(NoPropertyModel.class, "No property.");
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

        assert_().about(javaSource())
                .that(source)
                .processedWith(new IcyManipulator())
                .compilesWithoutError()
                .and()
                .generatesSources(expected);
    }

    /**
     * <p>
     * Test code generation.
     * </p>
     * 
     * @param sourceModel
     * @param expectedModel
     */
    private void testInvalidCodeGeneration(Class sourceModel, String message) {
        SourceFile source = SourceFile.of(sourceModel);

        assert_().about(javaSource()).that(source).processedWith(new IcyManipulator()).failsToCompile().withErrorContaining(message);
    }
}
