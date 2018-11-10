package ru.kpfu.testing.helpers;

import org.openqa.selenium.By;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;

public class NavigateHelper extends HelperBase {

    public NavigateHelper(AppManager appManager) {
        super(appManager);
    }

    public void getLoginPage() {
        getAppManager().getDriver().get("https://trello.com/home");
    }

    public void getBoardPage() {
        getAppManager().getDriver().get("https://trello.com/lix373/boards");
    }
}
