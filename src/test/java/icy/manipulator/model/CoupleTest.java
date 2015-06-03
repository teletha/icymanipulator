/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import org.junit.Test;

/**
 * @version 2015/06/03 10:14:46
 */
public class CoupleTest {

    @Test
    public void nestedPropertyChangeIcy() throws Exception {
        Person AYA = Person.with().name("小路 綾").ice();
        Person YOUKO = Person.with().name("猪熊 陽子").ice();
        Couple melty = Couple.with().husband(YOUKO).wife(AYA).ice();
        Couple modified = Couple.Operator.husband().name().set(melty, "ようこ");

        assert melty != modified;
        assert melty.husband() == YOUKO;
        assert melty.wife() == AYA;
        assert modified.husband().name().equals("ようこ");
    }

    @Test
    public void nestedPropertyChangeMelty() throws Exception {
        Person AYA = Person.with().name("小路 綾");
        Person YOUKO = Person.with().name("猪熊 陽子");
        Couple melty = Couple.with().husband(YOUKO).wife(AYA);
        Couple modified = Couple.Operator.husband().name().set(melty, "ようこ");

        assert melty == modified;
        assert melty.husband().name().equals("ようこ");
    }
}
