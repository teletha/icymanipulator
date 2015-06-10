/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.ast;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeElement;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreeScanner;
import com.sun.source.util.Trees;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;

/**
 * @version 2015/06/10 18:28:08
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("icy.manipulator.ast.AST")
public class ASTManipulator extends AbstractProcessor {

    private Trees trees;

    private TreeMaker maker;

    private JavacElements elements;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(ProcessingEnvironment procEnv) {
        trees = Trees.instance(procEnv);

        JavacProcessingEnvironment env = (JavacProcessingEnvironment) procEnv;

        maker = TreeMaker.instance(env.getContext());
        elements = JavacElements.instance(env.getContext());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // コンパイル対象の全ソースを処理
        roundEnv.getRootElements().stream().map(this::toUnit).forEach(e -> {
            processUnit(e);
            System.out.println(e);
        });

        return false;
    }

    /**
     * @param el
     * @return
     */
    // AST の取得
    private CompilationUnitTree toUnit(Element el) {
        TreePath path = trees.getPath(el);
        return path.getCompilationUnit();
    }

    private void processUnit(CompilationUnitTree cu) {
        // Visitor パターンで AST を処理
        cu.accept(new VarVisitor(), null);
    }

    /**
     * @version 2015/06/10 18:37:44
     */
    private class VarVisitor extends TreeScanner<Void, Void> {

        // 変数定義の処理
        @Override
        public Void visitVariable(VariableTree node, Void p) {
            System.out.println("visitVariable: " + node);

            if (node instanceof JCVariableDecl) {
                JCVariableDecl vd = (JCVariableDecl) node;

                JCExpression ex = maker.Ident(elements.getName("java"));
                ex = maker.Select(ex, elements.getName("lang"));
                ex = maker.Select(ex, elements.getName("Object"));
                // 型を java.lang.Object へ変更
                vd.vartype = ex;
            }
            return null;
        }
    }
}
