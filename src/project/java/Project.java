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
        product("com.github.teletha", "icymanipulator", "0.4.2");

        require("com.github.teletha", "antibug").atTest();
        require("com.github.teletha", "bee", "0.5").atTest();
        require("com.google.testing.compile", "compile-testing").atTest();
        require("com.google.truth", "truth").atTest();
        require("io.github.classgraph", "classgraph").atTest();

        versionControlSystem("https://github.com/Teletha/IcyManipulator");
    }
}
