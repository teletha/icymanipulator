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

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

public class Modifiers {

    /**
     * Check modifier.
     * 
     * @param e
     * @return
     */
    public static boolean isPublic(Element e) {
        return e.getModifiers().contains(Modifier.PUBLIC);
    }

    /**
     * Check modifier.
     * 
     * @param e
     * @return
     */
    public static boolean isPrivate(Element e) {
        return e.getModifiers().contains(Modifier.PRIVATE);
    }
}
