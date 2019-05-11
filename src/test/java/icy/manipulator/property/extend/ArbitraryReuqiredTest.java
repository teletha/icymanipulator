/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.extend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.extend.model.ArbitraryRequired;
import icy.manipulator.property.extend.model.ArbitraryRequiredModel;

class ArbitraryReuqiredTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, ArbitraryRequiredModel.class);

    @Test
    void defaults() {
        ArbitraryRequired o = ArbitraryRequired.with.id(10);
        assert o.id == 10;
        assert o.optionNum == 10;
        assert o.optionComment.isEmpty();
    }

    // @Test
    // void property() {
    // DefaultThenRequired.with.
    // Default instance = DefaultThenRequired.with.create().id(10).name("Guido
    // Mista").stand("Sex Pistols");
    // assert instance.name.equals("Guido Mista");
    // assert instance.name().equals("Guido Mista");
    // assert instance.stand.equals("Sex Pistols");
    // assert instance.stand().equals("Sex Pistols");
    // }
}
