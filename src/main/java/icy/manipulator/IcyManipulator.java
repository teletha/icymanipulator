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

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedSourceVersion(SourceVersion.RELEASE_13)
@SupportedAnnotationTypes("icy.manipulator.Icy")
public class IcyManipulator extends AbstractProcessor {

    /** The suffix of model definition. */
    static final String ModelDefinitionSuffix = "Model";

    /** The utility. */
    static ClassImporter importer;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations.isEmpty()) {
            return true;
        }

        Utility.types = processingEnv.getTypeUtils();
        Utility.elements = processingEnv.getElementUtils();

        for (Element element : env.getElementsAnnotatedWith(Icy.class)) {
            importer = new ClassImporter(element.toString());
            CodeAnalyzer analyzer = element.accept(new CodeAnalyzer(element, processingEnv.getMessager()), null);

            analyzer.prepare();

            if (analyzer.hasError == false) {
                try {
                    String code = analyzer.defineCode();

                    JavaFileObject generated = processingEnv.getFiler().createSourceFile(analyzer.clazz.toString());
                    Writer writer = generated.openWriter();
                    writer.write(code);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }
}
