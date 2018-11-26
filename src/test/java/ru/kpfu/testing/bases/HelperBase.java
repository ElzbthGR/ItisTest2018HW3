package ru.kpfu.testing.bases;

import org.openqa.selenium.*;
import ru.kpfu.testing.AppManager;

public class HelperBase {

    private boolean acceptNextAlert = true;

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

    public boolean isElementPresent(By by) {
        try {
            appManager.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            appManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = appManager.getDriver().switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
