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
 * @version 2015/06/05 16:51:29
 */
public class PrimitiveTest {

    @Test
    public void Int() {
        Primitive icy = Primitive.with().intValue(10).ice();
        Primitive modified = icy.intValue(20);
        assert icy != modified;
        assert icy.intValue() == 10;
        assert modified.intValue() == 20;
    }

    @Test
    public void Long() {
        Primitive icy = Primitive.with().longValue(10).ice();
        Primitive modified = icy.longValue(20);
        assert icy != modified;
        assert icy.longValue() == 10;
        assert modified.longValue() == 20;
    }

    @Test
    public void Float() {
        Primitive icy = Primitive.with().floatValue(10).ice();
        Primitive modified = icy.floatValue(20);
        assert icy != modified;
        assert icy.floatValue() == 10;
        assert modified.floatValue() == 20;
    }

    @Test
    public void Double() {
        Primitive icy = Primitive.with().doubleValue(10).ice();
        Primitive modified = icy.doubleValue(20);
        assert icy != modified;
        assert icy.doubleValue() == 10;
        assert modified.doubleValue() == 20;
    }

    @Test
    public void Byte() {
        Primitive icy = Primitive.with().byteValue((byte) 10).ice();
        Primitive modified = icy.byteValue((byte) 20);
        assert icy != modified;
        assert icy.byteValue() == 10;
        assert modified.byteValue() == 20;
    }

    @Test
    public void Char() {
        Primitive icy = Primitive.with().charValue('A').ice();
        Primitive modified = icy.charValue('Q');
        assert icy != modified;
        assert icy.charValue() == 'A';
        assert modified.charValue() == 'Q';
    }

    @Test
    public void Boolean() {
        Primitive icy = Primitive.with().booleanValue(false).ice();
        Primitive modified = icy.booleanValue(true);
        assert icy != modified;
        assert icy.booleanValue() == false;
        assert modified.booleanValue() == true;
    }
}
