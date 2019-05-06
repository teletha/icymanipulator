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

import java.util.function.Consumer;

public class Coder {

    /** The line feed. */
    private static final String END = "\r\n";

    /** The indent. */
    private static final String indent = "    ";

    /** The source code. */
    private final StringBuilder source = new StringBuilder();

    /** The import manager. */
    private final ClassImporter importer;

    /** The indent depth. */
    private int depth = 0;

    /**
     * @param importer
     */
    public Coder(ClassImporter importer) {
        this.importer = importer;
    }

    public void writeTry(Runnable tryBlock, Class<? extends Throwable> errorType, Consumer<String> catchBlock) {
        write("try {");
        write(tryBlock);
        write("} catch (", errorType, " e) {");
        write(() -> catchBlock.accept("e"));
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param nest A nested code.
     */
    public void write(Runnable nest) {
        depth++;
        nest.run();
        depth--;
    }

    /**
     * Write nested code.
     * 
     * @param code A code fragment.
     * @param nest A nested code.
     */
    public void write(Object code, Runnable nest) {
        write(code, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Runnable nest) {
        write(code1, code2, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Object code3, Runnable nest) {
        write(code1, code2, code3, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param code A code4 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Object code3, Object code4, Runnable nest) {
        write(code1, code2, code3, code4, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param code A code4 fragment.
     * @param code A code5 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Object code3, Object code4, Object code5, Runnable nest) {
        write(code1, code2, code3, code4, code5, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param code A code4 fragment.
     * @param code A code5 fragment.
     * @param code A code6 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, " {");
        write(nest);
        write("}");
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param code A code4 fragment.
     * @param code A code5 fragment.
     * @param code A code6 fragment.
     * @param code A code7 fragment.
     * @param nest A nested code.
     */
    public void write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, code7, " {");
        write(nest);
        write("}");
    }

    /**
     * Write code.
     * 
     * @param codes
     */
    public void write(Object... codes) {
        if (codes.length != 0) source.append(indent.repeat(depth));

        for (Object code : codes) {
            if (code instanceof Class) {
                Class clazz = (Class) code;
                source.append(importer.use(clazz));
            } else if (code instanceof Type) {
                Type clazz = (Type) code;
                source.append(importer.use(clazz));
            } else {
                source.append(code.toString());
            }
        }
        source.append(END);
    }

    public String toCode() {
        StringBuilder code = new StringBuilder();
        code.append("package ").append(importer.basePackage).append(";").append(END);
        code.append(END);
        for (String fqnc : importer.imports) {
            code.append("import ").append(fqnc).append(";").append(END);
        }
        code.append(END);
        code.append(source);

        return code.toString();
    }
}
