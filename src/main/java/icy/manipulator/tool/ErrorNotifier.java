/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.tool;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;

/**
 * @version 2015/06/06 9:10:36
 */
class ErrorNotifier {

    /** The error existence state. */
    private static boolean existError;

    /**
     * <p>
     * Notify error.
     * </p>
     * 
     * @param message
     * @param position
     */
    static void notify(String message, Element position) {
        if (message != null && position != null) {
            existError = true;
            IcyManipulator.messager.printMessage(Kind.ERROR, message, position);
        }
    }

    /**
     * <p>
     * Notify error.
     * </p>
     * 
     * @param message
     * @param position
     */
    static void notify(String message, TypeMirror position) {
        if (position != null) {
            notify(message, IcyManipulator.types.asElement(position));
        }
    }

    /**
     * <p>
     * Check whether some error exists in this processing context or not.
     * </p>
     * 
     * @return
     */
    static boolean hasNoError() {
        return existError;
    }
}
