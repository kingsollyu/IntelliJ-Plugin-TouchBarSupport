/*
 * Copyright 2018 Sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sollyu.java.idea.button;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.application.ApplicationManager;
import com.thizzer.jtouchbar.item.view.TouchBarView;

/**
 * @author sollyu
 */
public class CommentByLineTouchBarItem extends AbstractTouchBarItem implements Runnable {
    public CommentByLineTouchBarItem() {
        super("CommentByLine");
    }

    @Override
    public void onCall(TouchBarView touchBarView) {
        ApplicationManager.getApplication().invokeLater(this);
    }

    @Override
    public void run() {
        ActionManager.getInstance().getAction("CommentByLineComment").actionPerformed(
                new AnActionEvent(null, DataManager.getInstance().getDataContext(), "unknown", new Presentation(), ActionManager.getInstance(), 0)
        );
    }
}
