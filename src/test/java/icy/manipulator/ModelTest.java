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

import org.junit.Test;

import icy.manipulator.model.Couple;
import icy.manipulator.model.CoupleModel;
import icy.manipulator.model.Person;
import icy.manipulator.model.PersonModel;

/**
 * @version 2015/06/02 16:43:02
 */
public class ModelTest extends ModelTestBase {

    @Test
    public void person() {
        testCodeGeneration(PersonModel.class, Person.class);
    }

    @Test
    public void couple() {
        testCodeGeneration(CoupleModel.class, Couple.class);
    }
}
