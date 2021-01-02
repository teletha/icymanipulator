/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

public interface AnnotationProcessing<T> {

    /**
     * Process the annotated element.
     * 
     * @param element
     * @throws Exception
     */
    void process(T element) throws Exception;
}