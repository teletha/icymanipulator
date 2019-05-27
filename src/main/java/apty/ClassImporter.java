/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty;

import java.util.Set;
import java.util.TreeSet;

public class ClassImporter {

    /** The base package name. */
    public final String basePackage;

    /** The base class name. */
    public final String baseClass;

    /** The imported classes. */
    public final Set<String> imports = new TreeSet();

    /**
     * @param basePackage
     */
    public ClassImporter(String baseClass) {
        int index = baseClass.lastIndexOf(".");

        if (index == -1) {
            this.basePackage = "";
            this.baseClass = baseClass;
        } else {
            this.basePackage = baseClass.substring(0, index);
            this.baseClass = baseClass.substring(index + 1);
        }
    }

    /**
     * <p>
     * Import class.
     * </p>
     */
    public String use(Class imported) {
        return use(new Type(imported));
    }

    /**
     * <p>
     * Import class.
     * </p>
     */
    public String use(Type imported) {
        if (!imported.isDefault() && !imported.isPrimitive() && !imported.generic) {
            if (!imported.packageName.equals(basePackage) && !imported.toString().startsWith(basePackage + "." + baseClass + ".")) {
                imports.add(imported.toString());
            }
        }
        return imported.className.concat(imported.variable.toString());
    }
}
