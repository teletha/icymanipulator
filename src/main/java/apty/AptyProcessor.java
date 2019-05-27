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

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

import javax.annotation.processing.Completion;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;

public abstract class AptyProcessor implements Processor {

    /** The file manager. */
    protected Filer filer;

    /** The notifier. */
    protected Messager messager;

    /** The registered processors. */
    private final Map<Class, Consumer<Element>> processors = new HashMap();

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
     * Register your process by type.
     * 
     * @param <A>
     * @param annotation
     * @param yourOwnProcess
     */
    protected final <A extends Annotation> void process(Class<A> annotation, Consumer<Element> yourOwnProcess) {
        Objects.requireNonNull(annotation);
        Objects.requireNonNull(yourOwnProcess);

        processors.put(annotation, yourOwnProcess);
    }
}
