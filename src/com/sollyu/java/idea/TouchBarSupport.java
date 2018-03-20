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

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.ProjectManager;

/**
 * @author sollyu
 */
public class TouchBarSupport implements ApplicationComponent {

    private TouchBarProject touchBarProject = new TouchBarProject();

    @Override
    public void initComponent() {
        System.out.println("IntelliJ IDEA 打开了");
        ProjectManager.getInstance().addProjectManagerListener(getTouchBarProject());
    }

    @Override
    public void disposeComponent() {
        System.out.println("IntelliJ IDEA 关闭了");
        ProjectManager.getInstance().removeProjectManagerListener(getTouchBarProject());
    }

    public TouchBarProject getTouchBarProject() {
        return touchBarProject;
    }
}
