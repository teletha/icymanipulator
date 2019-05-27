/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import apty.AptyProcessor;
import icy.manipulator.model.ModelDefinition;

public class IcyManipulator extends AptyProcessor {

    /**
    * 
    */
    public IcyManipulator() {
        process(Icy.class, element -> {
            ModelDefinition model = new ModelDefinition(element);
            CodeGenerator generator = new CodeGenerator(model);

            createSourceFile(model.implType.toString(), writer -> {
                writer.write(generator.generate());
            });
        });
    }
}
