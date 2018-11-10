package ru.kpfu.testing.bases;

import org.openqa.selenium.*;
import ru.kpfu.testing.AppManager;

public class HelperBase {

    private AppManager appManager;

    public HelperBase(AppManager appManager) {
        this.appManager = appManager;
    }

    public String getBaseUrl() {
        return appManager.getBaseUrl();
    }

    public AppManager getAppManager() {
        return appManager;
    }
}
