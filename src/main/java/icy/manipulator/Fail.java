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

import javax.lang.model.element.Element;

@SuppressWarnings("serial")
public class Fail extends RuntimeException {

    /** The source code location. */
    public final Element e;

    /**
     * Throw failure with message.
     * 
     * @param e
     * @param message
     */
    public Fail(Element e, String message) {
        super(message);
        this.e = e;
    }
}
