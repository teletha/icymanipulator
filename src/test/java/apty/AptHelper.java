/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package apty;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import bee.Bee;
import bee.util.JavaCompiler;
import kiss.I;

public class AptHelper implements BeforeAllCallback {

    static {
        I.load(Bee.class);
    }

    public Elements elements;

    public Types types;

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        JavaCompiler compiler = new JavaCompiler();
        compiler.addProcessor(new Extractor());
        compiler.addSource("Dummy", "class Dummy {}");
        compiler.compile();
    }

    /**
     * 
     */
    final class Extractor extends AbstractProcessor {

        @Override
        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.latest();
        }

        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return Set.of("*");
        }

        @Override
        public void init(ProcessingEnvironment processingEnv) {
            elements = processingEnv.getElementUtils();
            types = processingEnv.getTypeUtils();
        }

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            return false;
        }
    }
}
