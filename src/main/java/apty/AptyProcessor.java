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

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.Completion;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import apty.code.Coder;

public abstract class AptyProcessor implements Processor {

    /** The file manager. */
    protected Filer filer;

    /** The notifier. */
    protected Messager messager;

    /** The registered processors. */
    private final Map<Class<? extends Annotation>, AnnotationProcessing<Element>> processors = new HashMap();

    /**
     * {@inheritDoc}
     */
    @Override
    public final Set<String> getSupportedAnnotationTypes() {
        return processors.keySet().stream().map(Class::getCanonicalName).collect(Collectors.toUnmodifiableSet());
    }

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
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
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
    public final void init(ProcessingEnvironment process) {
        this.filer = process.getFiler();
        this.messager = process.getMessager();

        Apty.initialize(process);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
        if (annotations.isEmpty()) {
            return true;
        }

        processors.forEach((type, processor) -> {
            round.getElementsAnnotatedWith(type).forEach(element -> {
                try {
                    processor.process(element);
                } catch (Fail fail) {
                    messager.printMessage(Kind.ERROR, fail.getMessage(), fail.e);
                    throw fail;
                } catch (Exception e) {
                    messager.printMessage(Kind.ERROR, String.valueOf(e.getMessage()), element);
                    throw new Error(e);
                }
            });
        });
        return true;
    }

    /**
     * Register your process by type.
     * 
     * @param <A>
     * @param annotation
     * @param yourOwnProcess
     */
    protected final <A extends Annotation> void process(Class<A> annotation, AnnotationProcessing<Element> yourOwnProcess) {
        Objects.requireNonNull(annotation);
        Objects.requireNonNull(yourOwnProcess);

        processors.put(annotation, yourOwnProcess);
    }

    /**
     * Write new source file.
     * 
     * @param fqcn A fully qualified class name to write.
     * @param coder Write your code.
     * @throws Exception
     */
    protected final void writeSourceFile(String fqcn, AnnotationProcessing<Coder> coding) throws Exception {
        Coder coder = new Coder(fqcn);
        coding.process(coder);

        writeSourceFileBy(coder);
    }

    /**
     * Write new source file.
     * 
     * @param coder Write your code.
     * @throws Exception
     */
    protected final void writeSourceFileBy(Coder coding) throws Exception {
        JavaFileObject implementationFile = filer.createSourceFile(coding.fqcn);
        try (Writer writer = new OutputStreamWriter(implementationFile.openOutputStream(), StandardCharsets.UTF_8)) {
            writer.write(coding.toString());
        }
    }
}
