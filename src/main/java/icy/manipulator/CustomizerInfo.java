/*
 * Copyright (C) 2020 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;

import apty.Apty;
import apty.MethodLike;
import apty.code.Type;

public class CustomizerInfo {

    private TypeElement e;

    /** The property type variable on customizer. */
    private TypeMirror variable;

    private PropertyInfo property;

    public boolean requireSetter;

    public List<MethodLike> methods;

    /**
     * @param property
     * @param customizer
     */
    public CustomizerInfo(PropertyInfo property, TypeElement customizer) {
        this.variable = Apty.typeParameter(customizer, Supplier.class).get(0);
        this.e = customizer;
        this.property = property;
        this.requireSetter = Type.of(customizer).isAssignableFrom(Consumer.class);
        this.methods = Apty.methodsInHierarchy(customizer, m -> m.getSimpleName().toString().contains("$")).stream().map(m -> {
            List<Type> types = ((ExecutableType) m.asType()).getParameterTypes()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toUnmodifiableList());
            List<String> names = m.getParameters()
                    .stream()
                    .map(element -> element.getSimpleName().toString())
                    .collect(Collectors.toUnmodifiableList());

            return new MethodLike(name(m, property), convert(m.getReturnType()), types, names, Apty.doc(m));
        }).collect(Collectors.toUnmodifiableList());
    }

    private String name(ExecutableElement method, PropertyInfo p) {
        String name = method.getSimpleName().toString();

        if (name.startsWith("$")) {
            return name.replace("$", p.name);
        } else {
            return name.replace("$", p.capitalizeName());
        }
    }

    private Type convert(TypeMirror type) {
        // check base
        if (Apty.same(type, variable)) {
            return property.type;
        }

        // check parameters
        DeclaredType declaredType = (DeclaredType) type;
        List<Type> variables = new ArrayList();

        for (TypeMirror argType : declaredType.getTypeArguments()) {
            if (Apty.same(argType, variable)) {
                variables.add(property.type);
            } else {
                variables.add(Type.of(argType));
            }
        }
        return Type.of(declaredType, variables);
    }

    public Type type() {
        return convert(e.asType());
    }
}