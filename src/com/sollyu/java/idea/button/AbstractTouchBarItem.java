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

import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.common.Image;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import com.thizzer.jtouchbar.item.view.TouchBarView;
import com.thizzer.jtouchbar.item.view.action.TouchBarViewAction;

import java.io.IOException;

/**
 * @author sollyu
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractTouchBarItem extends TouchBarItem implements TouchBarViewAction {

    public static final Color DEFAULT = new Color(0.21176471f, 0.21176471f, 0.21176471f);

    private TouchBarButton touchBarButton = new TouchBarButton();
    private String         iconName       = null;

    AbstractTouchBarItem(String iconName) {
        super(iconName + "TouchBarItem");
        this.iconName = iconName;

        try {
            onInit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    protected void onInit() throws Throwable {
        getTouchBarButton().setImage(getIcon(getIconName()));
        getTouchBarButton().setAction(this);
        getTouchBarButton().setBezelColor(DEFAULT);
        this.setCustomizationAllowed(false);
        this.setView(getTouchBarButton());
    }

    private String getIconName() {
        return iconName;
    }

    private Image getIcon(String iconName) throws IOException {
        return new Image(this.getClass().getClassLoader().getResourceAsStream("resources/assets/image/" + iconName + ".png"));
    }

    @Override
    public abstract void onCall(TouchBarView touchBarView);

    public TouchBarButton getTouchBarButton() {
        return touchBarButton;
    }
}
