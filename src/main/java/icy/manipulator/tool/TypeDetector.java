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

import icy.manipulator.tool.IcyManipulator.FQCN;

/**
 * @version 2015/06/06 11:44:40
 */
class TypeDetector implements TypeVisitor<FQCN, Void> {

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visit(TypeMirror t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visit(TypeMirror t) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitPrimitive(PrimitiveType t, Void p) {
        return new FQCN(t.toString(), null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitNull(NullType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitArray(ArrayType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitDeclared(DeclaredType t, Void p) {
        return new FQCN(((TypeElement) t.asElement()).getQualifiedName().toString(), t.getTypeArguments());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitError(ErrorType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitTypeVariable(TypeVariable t, Void p) {
        return new FQCN(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitWildcard(WildcardType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitExecutable(ExecutableType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitNoType(NoType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitUnknown(TypeMirror t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitUnion(UnionType t, Void p) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FQCN visitIntersection(IntersectionType t, Void p) {
        return null;
    }
}
