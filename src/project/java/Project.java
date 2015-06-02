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
        product("icy.manipulator", "Icy Manipulator", "0.1");

        require("com.google.auto", "auto-common", "0.4").atProvided();
        require("com.squareup", "javapoet", "1.0.0").atProvided();
        require("com.google.testing.compile", "compile-testing", "0.6").atTest();
        require("com.google.truth", "truth", "0.25").atTest();
        require("junit", "junit", "4.11").atTest();
        require("com.sun", "tools", "1.8").atTest();
    }
}
