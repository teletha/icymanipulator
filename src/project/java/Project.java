/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
public class Project extends bee.api.Project {

    {
        product("com.github.teletha", "icymanipulator", "0.8.7");

        require("com.github.teletha", "antibug").atTest();
        require("com.github.teletha", "bee", "0.5").atTest();
        require("com.google.guava", "guava").atTest();

        versionControlSystem("https://github.com/Teletha/IcyManipulator");
    }
}
