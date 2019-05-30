/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.junit.jupiter.api.extension.RegisterExtension;

import antibug.CleanRoom;
import apty.code.Coder;
import bee.Bee;
import bee.util.JavaCompiler;
import icy.manipulator.IcyManipulator;
import kiss.I;
import psychopath.File;
import psychopath.Locator;

public class AnnotationProcessor {

    static {
        I.load(Bee.class);
    }

    @RegisterExtension
    static CleanRoom room = new CleanRoom();

    /** Annotation processor. */
    private final Class<? extends AptyProcessor> processor;

    /**
     * @param processor
     * @param room
     */
    public AnnotationProcessor(Class<? extends AptyProcessor> processor, Class... classes) {
        this.processor = processor;

        for (Class clazz : classes) {
            requireCompiling(clazz);
        }
    }

    /**
     * Compile target class.
     * 
     * @param source A target source class.
     */
    public void requireCompiling(Class source) {
        compile(source.getName(), source.getName().replace("Model", ""));
    }

    /**
     * Try to capture APT error.
     * 
     * @param source
     */
    public String captureError(Class source) {
        List<String> errors = new ArrayList();

        String compilingClass = source.isMemberClass() ? source.getEnclosingClass().getName() : source.getName();
        File compilingSource = Locator.directory("src/test/java").file(computeSourceFileName(compilingClass));
        Filter filter = new Filter(processor, source);

        JavaCompiler compiler = new JavaCompiler();
        compiler.addCurrentClassPath();
        compiler.addProcessor(filter);
        compiler.addSource(compilingClass, compilingSource.text());
        compiler.setOutput(room.root);
        compiler.setErrorListener(new DiagnosticListener<>() {

            @Override
            public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
                switch (diagnostic.getKind()) {
                case ERROR:
                    errors.add(diagnostic.getMessage(Locale.getDefault()));
                    break;

                default:
                    break;
                }
            }
        });

        try {
            compiler.compile();

            throw new AssertionError("No Error");
        } catch (Throwable e) {
            return e.getMessage();
        }
    }

    private static class Filter implements Processor {

        private final AptyProcessor delegate;

        private final Class target;

        private Filter(Class<? extends AptyProcessor> delegation, Class target) {
            this.delegate = I.make(delegation);
            this.target = target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Set<String> getSupportedOptions() {
            return delegate.getSupportedOptions();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return delegate.getSupportedAnnotationTypes();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SourceVersion getSupportedSourceVersion() {
            return delegate.getSupportedSourceVersion();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void init(ProcessingEnvironment processingEnv) {
            delegate.init(processingEnv);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            for (TypeElement annotation : annotations) {
                for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                    if (element.toString().equals(target.getCanonicalName())) {
                        for (AnnotationProcessing<Element> p : delegate.processors.values()) {
                            try {
                                p.process(element);
                            } catch (Exception e) {
                                throw I.quiet(e);
                            }
                        }
                    }
                }
            }
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
            return delegate.getCompletions(element, annotation, member, userText);
        }
    }

    private void compile(String compilingClass, String generatedClass) {
        File compilingSource = Locator.directory("src/test/java").file(computeSourceFileName(compilingClass));
        File generatedSource = Locator.directory("src/test/java").file(computeSourceFileName(generatedClass));
        File annotaionProcessorSource = Locator.directory("src/main/java").file(computeSourceFileName(processor.getName()));
        File generator = Locator.directory("src/main/java").file(computeSourceFileName(IcyManipulator.class.getName()));
        File depend1 = Locator.directory("src/main/java").file(computeSourceFileName(Coder.class.getName()));
        File temporaryGeneratedSource = Locator.directory(room.root).file(computeSourceFileName(generatedClass));
        long date = generatedSource.lastModified();

        if (compilingSource.lastModified() < date && annotaionProcessorSource.lastModified() < date && generator
                .lastModified() < date && depend1.lastModified() < date) {
            return; // generated source file is up to date
        }

        Errors errors = new Errors();

        // compile class and generate source by annotation processor
        JavaCompiler compiler = new JavaCompiler();
        compiler.addCurrentClassPath();
        compiler.addProcessor(processor);
        compiler.addSource(compilingClass, compilingSource.text());
        compiler.setOutput(room.root);
        compiler.setErrorListener(errors);

        try {
            compiler.compile();
        } catch (Error e) {
            System.out.println(errors.errors);
            System.out.println(temporaryGeneratedSource.text());
            throw I.quiet(e);
        }

        // copy generated file to test source directory
        temporaryGeneratedSource.copyTo(generatedSource);

        throw new AssertionError(compilingClass + " was compiled. Please retry to run test.");
    }

    /**
     * Compute class file name.
     * 
     * @param className
     * @return
     */
    private String computeSourceFileName(String className) {
        return className.replace('.', '/') + ".java";
    }

    /**
     * 
     */
    private static class Errors implements DiagnosticListener<JavaFileObject> {

        List<Diagnostic> errors = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
            if (diagnostic.getKind() == Kind.ERROR) {
                errors.add(diagnostic);
            }
        }
    }
}
