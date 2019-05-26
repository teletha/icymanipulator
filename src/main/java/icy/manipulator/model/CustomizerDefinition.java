/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

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
import javax.lang.model.type.TypeVariable;

import icy.manipulator.Abyss;
import icy.manipulator.Fail;
import icy.manipulator.Type;

public class CustomizerDefinition {

    private TypeElement e;

    /** The property type variable on customizer. */
    private TypeMirror variable;

    private PropertyDefinition property;

    public boolean requireSetter;

    public List<MethodDefinition> methods;

    /**
     * @param property
     * @param customizer
     */
    public CustomizerDefinition(PropertyDefinition property, TypeElement customizer) {
        // search generic type of supplier
        this.variable = Abyss.variables(customizer, Supplier.class).get(0);
        System.out.println(this.variable + "        @@@   " + searchSupplierVariable(customizer));

        this.e = customizer;
        this.property = property;
        this.requireSetter = Abyss.implement(customizer, Consumer.class);
        this.methods = Abyss.methodsInHierarchy(customizer, m -> m.getSimpleName().toString().contains("$")).stream().map(m -> {
            List<Type> types = ((ExecutableType) m.asType()).getParameterTypes()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toUnmodifiableList());
            List<String> names = m.getParameters()
                    .stream()
                    .map(element -> element.getSimpleName().toString())
                    .collect(Collectors.toUnmodifiableList());

            return new MethodDefinition(name(m, property), convert(m.getReturnType()), types, names, Abyss.doc(m));
        }).collect(Collectors.toUnmodifiableList());
    }

    private TypeVariable searchSupplierVariable(TypeElement e) {
        while (e != null) {
            for (TypeMirror interfaceType : e.getInterfaces()) {
                if (Abyss.same(interfaceType, Supplier.class)) {
                    return (TypeVariable) ((DeclaredType) interfaceType).getTypeArguments().get(0);
                }
            }
            e = Abyss.parent(e);
        }
        throw new Fail(e, e + " doesn't implement Supplier interface.");
    }

    private String name(ExecutableElement method, PropertyDefinition p) {
        String name = method.getSimpleName().toString();

        if (name.startsWith("$")) {
            return name.replace("$", p.name);
        } else {
            return name.replace("$", p.capitalizeName());
        }
    }

    private Type convert(TypeMirror type) {
        // check base
        System.out.println(type + "   " + (type.equals(variable)) + "     " + Abyss.same(type, variable) + "       " + variable);
        if (Abyss.same(type, variable)) {
            return property.type;
        }

        // check parameters
        System.out.println(Abyss.cast(type, DeclaredType.class));
        DeclaredType declaredType = (DeclaredType) type;
        List<Type> variables = new ArrayList();

        for (TypeMirror argType : declaredType.getTypeArguments()) {
            if (Abyss.same(argType, variable)) {
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
