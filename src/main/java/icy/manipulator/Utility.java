/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class Utility {

    /** The type utility. */
    public static Types types;

    /** The element utility. */
    public static Elements elements;

    /**
     * List up class hierarchy.
     * 
     * @param e
     * @return
     */
    public static final List<TypeElement> hierarchy(Element e) {
        ElementKind kind = e.getKind();

        if (kind != ElementKind.CLASS) {
            return List.of();
        }

        TypeElement type = (TypeElement) e;
        LinkedList<TypeElement> list = new LinkedList();

        while (!type.getQualifiedName().contentEquals("java.lang.Object")) {
            list.addLast(type);
            type = (TypeElement) types.asElement(type.getSuperclass());
        }
        return list;
    }

    /**
     * Decapitalize text.
     * 
     * @param value
     * @return
     */
    public static String capitalize(String value) {
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

    /**
     * Decapitalize text.
     * 
     * @param value
     * @return
     */
    public static String decapitalize(String value) {
        return Character.toLowerCase(value.charAt(0)) + value.substring(1);
    }
}
