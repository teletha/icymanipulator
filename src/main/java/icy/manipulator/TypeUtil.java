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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class TypeUtil {

    /** The getter pattern. */
    private static final Predicate<ExecutableElement> getter = m -> {
        return m.getParameters().size() == 0 && m.getReturnType().getKind() != TypeKind.VOID;
    };

    /** The setter pattern. */
    private static final Predicate<ExecutableElement> setter = m -> {
        return m.getParameters().size() == 1;
    };

    /** The type utility. */
    static Types types;

    /** The element utility. */
    static Elements elements;

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
     * Find parent {@link TypeElement}.
     * 
     * @param e
     * @return
     */
    public static TypeElement parent(TypeElement e) {
        return (TypeElement) types.asElement(e.getSuperclass());
    }

    /**
     * Cast to {@link TypeElement} if you can.
     * 
     * @param type
     * @return
     */
    public static TypeElement type(TypeMirror type) {
        switch (type.getKind()) {
        case DECLARED:
            return (TypeElement) ((DeclaredType) type).asElement();

        default:
            throw new Fail(e(type), "Need DeclaredType.");
        }
    }

    /**
     * Compute the simple type name.
     * 
     * @param type A target.
     * @return A simple name of type.
     */
    public static String simpleName(TypeMirror type) {
        return type(type).getSimpleName().toString();
    }

    /**
     * Find all declared getter-like methods.
     * 
     * @param e A target type.
     */
    public static List<ExecutableElement> getters(TypeElement e) {
        return methods(e, getter);
    }

    /**
     * Find all declared setter-like methods.
     * 
     * @param e A target type.
     */
    public static List<ExecutableElement> setters(TypeElement e) {
        return methods(e, setter);
    }

    /**
     * Find all declared methods.
     * 
     * @param e A target type.
     * @return
     */
    public static List<ExecutableElement> methods(TypeMirror e) {
        return methods(type(e));
    }

    /**
     * Find all declared methods.
     * 
     * @param e A target type.
     * @return
     */
    public static List<ExecutableElement> methods(TypeElement e) {
        return methods(e, x -> true);
    }

    /**
     * Find the matching declared methods.
     * 
     * @param e A target type.
     * @param filter A including filer.
     * @return
     */
    public static List<ExecutableElement> methods(TypeElement e, Predicate<ExecutableElement> filter) {
        List<ExecutableElement> methods = new ArrayList();
        List<? extends Element> child = e.getEnclosedElements();

        for (Element element : child) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement executable = (ExecutableElement) element;

                if (filter.test(executable)) {
                    methods.add(executable);
                }
            }
        }
        return methods;
    }

    /**
     * Check type equality.
     * 
     * @param type
     * @param element
     * @return
     */
    public static boolean same(TypeMirror type, Element element) {
        return types.isSameType(type, element.asType());
    }

    /**
     * Check type equality.
     * 
     * @param type
     * @param element
     * @return
     */
    public static boolean diff(TypeMirror type, Element element) {
        return !types.isSameType(type, element.asType());
    }

    /**
     * Check whether the specified type is enum or not.
     * 
     * @param enumType A target type.
     * @return A result.
     */
    public static boolean isEnum(TypeMirror enumType) {
        Element e = types.asElement(enumType);

        if (e == null) {
            return false;
        }
        return e.getKind() == ElementKind.ENUM;
    }

    /**
     * Check whether the specified type is enum or not.
     * 
     * @param enumType A target type.
     * @return A result.
     */
    public static List<String> enumConstantNames(TypeMirror enumType) {
        List<String> names = new ArrayList();
        Element e = types.asElement(enumType);

        if (e == null) {
            return names;
        }

        for (Element element : e.getEnclosedElements()) {
            if (element.getKind() == ElementKind.ENUM_CONSTANT) {
                names.add(element.getSimpleName().toString());
            }
        }
        return names;
    }

    /**
     * Retrieve the documentation comment from the specified {@link Element}.
     * 
     * @param e The target element.
     * @return A documentation comment
     */
    public static String doc(Element e) {
        String doc = elements.getDocComment(e);
        return doc == null ? "" : doc;
    }

    /**
     * Helper.
     * 
     * @param mirror
     * @return
     */
    private static Element e(TypeMirror mirror) {
        return types.asElement(mirror);
    }
}
