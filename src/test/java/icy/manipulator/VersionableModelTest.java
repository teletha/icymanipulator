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

/**
 * @version 2015/06/08 13:06:52
 */
public class VersionableModelTest {

    @Test
    public void testname() {
        VersionableModel model = new VersionableModel();
        assert model.name() == null;

        model.name("1");
        assert model.name() == "1";
        model.name("2");
        assert model.name() == "2";

        model.undo();
        assert model.name() == "1";
        model.redo();
        assert model.name() == "2";

        model.transact(m -> {
            m.name("3");
            m.name("4");
        });
        assert model.name() == "4";
        model.undo();
        assert model.name() == "2";
        model.redo();
        assert model.name() == "4";
    }
}
