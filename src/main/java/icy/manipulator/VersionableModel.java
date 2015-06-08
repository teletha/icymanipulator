/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 2015/06/08 13:05:01
 */
public class VersionableModel {

    private List<Diff<VersionableModel>> executed = new ArrayList();

    private List<Diff<VersionableModel>> unexecuted = new ArrayList();

    public String name;

    public String name() {
        return name;
    }

    public VersionableModel name(String name) {
        NameDiff diff = new NameDiff(this.name, name);
        executed.add(diff);
        diff.redo(this);

        return this;
    }

    public void undo() {
        Diff<VersionableModel> diff = executed.remove(executed.size() - 1);
        diff.undo(this);
        unexecuted.add(diff);
    }

    public void redo() {
        Diff<VersionableModel> diff = unexecuted.remove(unexecuted.size() - 1);
        diff.redo(this);
        executed.add(diff);
    }

    public void transact(Consumer<VersionableModel> transactor) {
        List<Diff<VersionableModel>> store = executed;
        List<Diff<VersionableModel>> buffer = new ArrayList();

        executed = buffer;
        transactor.accept(this);
        executed = store;

        executed.add(new Diff<VersionableModel>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void redo(VersionableModel model) {
                for (Diff<VersionableModel> diff : buffer) {
                    diff.redo(model);
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void undo(VersionableModel model) {
                for (int i = buffer.size() - 1; 0 <= i; i--) {
                    buffer.get(i).undo(model);
                }
            }
        });
    }

    private static interface Diff<M> {

        void redo(M model);

        void undo(M model);
    }

    /**
     * @version 2015/06/08 13:16:34
     */
    private static class NameDiff implements Diff<VersionableModel> {

        private String prev;

        private String next;

        /**
         * @param prev
         * @param next
         */
        private NameDiff(String prev, String next) {
            this.prev = prev;
            this.next = next;
        }

        @Override
        public void redo(VersionableModel model) {
            model.name = next;
        }

        @Override
        public void undo(VersionableModel model) {
            model.name = prev;
        }
    }
}
