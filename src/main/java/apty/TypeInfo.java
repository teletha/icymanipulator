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

public abstract class TypeInfo {

    /**
     * Return the suitable notation for source code.
     * 
     * @return The suitable notation.
     */
    public abstract String notate();

    /**
     * Create new {@link TypeInfo} which replaces the target type-variable by the specified
     * replacement type.
     * 
     * @param target
     * @param replacement
     * @return
     */
    public abstract TypeInfo replaceVariable(TypeInfo target, TypeInfo replacement);

}
