/*
 * Copyright (C) 2015 Icy Manipulator Development Team
 * 
 * Licensed under the BSD License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *          http://opensource.org/licenses/BSD-2-Clause
 */
public class Project extends bee.api.Project {

    {
        product("icy.manipulator", "IcyManipulator", "0.3");

        require("com.github.teletha", "antibug").atTest();
        require("com.google.testing.compile", "compile-testing").atTest();
        require("com.google.truth", "truth").atTest();
    }
}
