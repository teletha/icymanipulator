/*
 * Copyright (C) 2025 The ICYMANIPULATOR Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty.code;

/**
 * Code fragment.
 */
public interface Codable {

    /**
     * Write your code.
     * 
     * @param coder A coder.
     * @return A code fragment.
     */
    String write(Coder coder);
}