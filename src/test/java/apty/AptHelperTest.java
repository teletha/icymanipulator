/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty;

import javax.lang.model.element.TypeElement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class AptHelperTest {

    @RegisterExtension
    static AptHelper apt = new AptHelper();

    @Test
    void testName() {
        TypeElement e = apt.elements.getTypeElement(AptHelperTest.class.getCanonicalName());
        System.out.println(e);
    }
}
