/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty.code;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

import apty.Apty;

public class Coder {

    /** The line feed. */
    private static final String END = "\r\n";

    /** The indent. */
    private static final String indent = "    ";

    /** The fully qualified class name. */
    public final String fqcn;

    /** The base package name. */
    private final String basePackage;

    /** The base class name. */
    private final String baseClass;

    /** The imported classes. */
    private final ImportManager manager;

    /** The source code. */
    private final StringBuilder source = new StringBuilder();

    /** The indent depth. */
    private int depth = 0;

    /**
     * Code writer.
     * 
     * @param fqcn A fully qualified class name to write.
     */
    public Coder(String fqcn) {
        this.fqcn = fqcn;
        int index = fqcn.lastIndexOf(".");

        if (index == -1) {
            this.basePackage = "";
            this.baseClass = fqcn;
        } else {
            this.basePackage = fqcn.substring(0, index);
            this.baseClass = fqcn.substring(index + 1);
        }
        this.manager = new ImportManager(basePackage, baseClass);
    }

    /**
     * Copy javadoc from the specified {@link Element}.
     * 
     * @param e
     * @param defaultComment
     */
    public final void javadoc(Element e, Runnable defaultDocument) {
        javadoc(Apty.doc(e), defaultDocument);
    }

    /**
     * Copy javadoc from the specified {@link Element}.
     * 
     * @param e
     */
    public final void javadoc(String doc, Runnable defaultDocument) {
        doc = doc.trim();

        if (doc.isEmpty()) {
            defaultDocument.run();
        } else {
            String[] lines = doc.replaceAll("\r\n", "\n").split("\n");

            if (lines.length == 1) {
                write("/** ", lines[0], " */");
            } else {
                write("/**");
                for (String line : lines) {
                    write(" * ", line);
                }
                write(" */");
            }
        }
    }

    public final void writeTry(Runnable tryBlock, Class<? extends Throwable> errorType, Consumer<String> catchBlock) {
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
    public final void write(Runnable nest) {
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
    public final Coder write(Object code, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Object code8, Runnable nest) {
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
    public final Coder write(Object code1, Object code2, Object code3, Object code4, Object code5, Object code6, Object code7, Object code8, Object code9, Runnable nest) {
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
    public final void write(Object... codes) {
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
        } else if (code instanceof Type) {
            return manager.require((Type) code);
        } else if (code instanceof Codable) {
            return ((Codable) code).write(this);
        } else if (code instanceof Class) {
            Class clazz = (Class) code;
            return use(clazz);
        } else {
            return String.valueOf(code).replace('`', '"');
        }
    }

    public final String require(String fqcn) {
        return manager.require(fqcn);
    }

    /**
     * Import the specified class and return the suitable qualified class name.
     * 
     * @param clazz A target class.
     * @return A class name to write.
     */
    public final String use(Class imported) {
        return use(Type.of(imported));
    }

    /**
     * Import the specified class and return the suitable qualified class name.
     * 
     * @param clazz A target class.
     * @return A class name to write.
     */
    public final String use(Type imported) {
        return imported.write(this);
    }

    /**
     * Return the suitable notation for source code.
     * 
     * @return The suitable notation.
     * @param type
     * @return
     */
    public final String use(TypeMirror type) {
        return manager.require(type);
    }

    public final String classLiteral(Type clazz) {
        return use(clazz).replaceAll("<.+>", "").concat(".class");
    }

    /**
     * Make the latest expression or block to statement by inserting semicolon.
     */
    public final void asStatement() {
        int index = source.lastIndexOf(END);

        if (index + END.length() == source.length()) {
            source.insert(index, ";");
        } else {
            source.append(";");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        StringBuilder code = new StringBuilder();
        code.append("package ").append(basePackage).append(";").append(END);
        code.append(END);
        for (String fqnc : manager.imports) {
            code.append("import ").append(fqnc).append(";").append(END);
        }
        code.append(END);
        code.append(source);

        return code.toString();
    }
}
