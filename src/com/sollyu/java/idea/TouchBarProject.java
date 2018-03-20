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

package com.sollyu.java.idea;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.wm.WindowManager;
import com.sollyu.java.idea.button.*;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Image;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.IOException;

/**
 * @author sollyu
 */
public class TouchBarProject implements ProjectManagerListener {

    private JTouchBar jTouchBar = new JTouchBar();

    @Override
    public void projectOpened(Project project) {
        System.out.println("工程被打开了");

        try {
            Notifications.Bus.notify(new Notification("dummy", "TouchBarSupport", "Hi", NotificationType.INFORMATION));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            JFrame barJFrame = WindowManager.getInstance().getFrame(project);
            jTouchBar.setCustomizationIdentifier("JTouchBarTestUtils");
            jTouchBar.getItems().add(new RenameTouchBarItem());
            jTouchBar.getItems().add(new CommentByLineTouchBarItem());
            jTouchBar.getItems().add(new ReformatCodeTouchBarItem());
            jTouchBar.getItems().add(new OptimizeImportsTouchBarItem());
            jTouchBar.getItems().add(new SurroundWithTouchBarItem());
            jTouchBar.show(barJFrame);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void projectClosed(Project project) {
        System.out.println("工程被关闭了");
    }

    private Image getIcon(String iconName) throws IOException {
        return new Image(this.getClass().getClassLoader().getResourceAsStream("resources/assets/image/" + iconName));
    }
}
