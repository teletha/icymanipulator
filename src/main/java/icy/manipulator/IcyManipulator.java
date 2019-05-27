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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import apty.AptyProcessor;
import apty.Fail;
import icy.manipulator.model.ModelDefinition;

public class IcyManipulator extends AptyProcessor {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Icy.class.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
        if (annotations.isEmpty()) {
            return true;
        }

        for (Element element : round.getElementsAnnotatedWith(Icy.class)) {
            try {
                ModelDefinition model = new ModelDefinition(element);
                CodeGenerator generator = new CodeGenerator(model);

                JavaFileObject implementationFile = filer.createSourceFile(model.implType.toString());
                try (Writer writer = new OutputStreamWriter(implementationFile.openOutputStream(), StandardCharsets.UTF_8)) {
                    writer.write(generator.generate());
                }
            } catch (Fail fail) {
                messager.printMessage(Kind.ERROR, fail.getMessage(), fail.e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
