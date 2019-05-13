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

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;

import icy.manipulator.model.MethodDefinition;

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
    public Coder write(Object code, Runnable nest) {
        write(code, " {");
        write(nest);
        write("}");
        return this;
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param nest A nested code.
     */
    public Coder write(Object code1, Object code2, Runnable nest) {
        write(code1, code2, " {");
        write(nest);
        write("}");
        return this;
    }

    /**
     * Write nested code.
     * 
     * @param code A code1 fragment.
     * @param code A code2 fragment.
     * @param code A code3 fragment.
     * @param nest A nested code.
     */
    public Coder write(Object code1, Object code2, Object code3, Runnable nest) {
        write(code1, code2, code3, " {");
        write(nest);
        write("}");
        return this;
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
    public Coder write(Object code1, Object code2, Object code3, Object code4, Runnable nest) {
        write(code1, code2, code3, code4, " {");
        write(nest);
        write("}");
        return this;
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
    public Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Runnable nest) {
        write(code1, code2, code3, code4, code5, " {");
        write(nest);
        write("}");
        return this;
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
    public Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, " {");
        write(nest);
        write("}");
        return this;
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
    public Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, code7, " {");
        write(nest);
        write("}");
        return this;
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
     * @param code A code8 fragment.
     * @param nest A nested code.
     */
    public Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Object code8, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, code7, code8, " {");
        write(nest);
        write("}");
        return this;
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
     * @param code A code8 fragment.
     * @param code A code9 fragment.
     * @param nest A nested code.
     */
    public Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Object code8, Object code9, Runnable nest) {
        write(code1, code2, code3, code4, code5, code6, code7, code8, code9, " {");
        write(nest);
        write("}");
        return this;
    }

    /**
     * Write code.
     * 
     * @param codes
     */
    public void write(Object... codes) {
        if (codes.length != 0) source.append(indent.repeat(depth));

        for (Object code : codes) {
            source.append(code(code));
        }
        source.append(END);
    }

    private String code(Object code) {
        if (code instanceof Optional) {
            return ((Optional<?>) code).map(v -> String.valueOf(v)).orElse("");
        } else if (code instanceof List) {
            List list = (List) code;
            StringJoiner joiner = new StringJoiner(", ");
            for (Object object : list) {
                joiner.add(code(object));
            }
            return joiner.toString();
        } else if (code instanceof MethodDefinition) {
            MethodDefinition e = (MethodDefinition) code;
            StringJoiner params = new StringJoiner(", ", "(", ")");
            for (int i = 0; i < e.paramTypes.size(); i++) {
                params.add(importer.use(e.paramTypes.get(i)) + " " + e.paramNames.get(i));
            }
            return e.name.concat(params.toString());
        } else if (code instanceof Class) {
            Class clazz = (Class) code;
            return importer.use(clazz);
        } else if (code instanceof Type) {
            Type clazz = (Type) code;
            return importer.use(clazz);
        } else {
            return String.valueOf(code).replace('`', '"');
        }
    }

    public String use(Type clazz) {
        return importer.use(clazz);
    }

    public String classLiteral(Type clazz) {
        return importer.use(clazz).replaceAll("<.+>", "").concat(".class");
    }

    /**
     * Make the latest expression or block to statement by inserting semicolon.
     */
    public void asStatement() {
        int index = source.lastIndexOf(END);

        if (index + END.length() == source.length()) {
            source.insert(index, ";");
        } else {
            source.append(";");
        }
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
