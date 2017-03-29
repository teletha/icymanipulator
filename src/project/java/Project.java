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
        product("icy.manipulator", "IcyManipulator", "0.1");

        require("com.google.testing.compile", "compile-testing", "0.8").atTest();
        require("com.google.truth", "truth", "0.30").atTest();
        require("com.github.teletha", "antibug", "0.3").atTest();
        require("sun.jdk", "tools", "8.0").atTest();
    }
}
