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
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Completion;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

import icy.manipulator.model.ModelDefinition;

public class IcyManipulator implements Processor {

    /** The utility. */
    static ClassImporter importer;

    /** The file manager. */
    private Filer filer;

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> getSupportedOptions() {
        return Set.of();
    }

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
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_12;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(ProcessingEnvironment process) {
        this.filer = process.getFiler();

        TypeUtil.types = process.getTypeUtils();
        TypeUtil.elements = process.getElementUtils();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return List.of();
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
            importer = new ClassImporter(element.toString());

            ModelDefinition model = new ModelDefinition(element);
            CodeGenerator generator = new CodeGenerator(model);

            try {
                JavaFileObject implementationFile = filer.createSourceFile(model.implType.toString());
                try (Writer writer = new OutputStreamWriter(implementationFile.openOutputStream(), StandardCharsets.UTF_8)) {
                    writer.write(generator.generate());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
