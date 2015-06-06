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

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;

/**
 * @version 2015/06/06 11:44:40
 */
class TypeDetector implements TypeVisitor<Type, Void> {

    /**
     * @param asType
     * @return
     */
    static final Type detect(TypeMirror type) {
        return type.accept(new TypeDetector(), null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visit(TypeMirror t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visit(TypeMirror t) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitPrimitive(PrimitiveType t, Void p) {
        return new Type(t.toString(), null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitNull(NullType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitArray(ArrayType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitDeclared(DeclaredType t, Void p) {
        return new Type(((TypeElement) t.asElement()).getQualifiedName().toString(), t.getTypeArguments());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitError(ErrorType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitTypeVariable(TypeVariable t, Void p) {
        return new Type("", t.toString(), "", true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitWildcard(WildcardType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitExecutable(ExecutableType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitNoType(NoType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitUnknown(TypeMirror t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitUnion(UnionType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type visitIntersection(IntersectionType t, Void p) {
        return null;
    }
}
