package ru.kpfu.testing.helpers;

import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;

public class NavigateHelper extends HelperBase {

    public static String loginPageUrl;
    public static String boardPageUrl;

    public NavigateHelper(AppManager appManager) {
        super(appManager);
    }

    public void getLoginPage() {
        getAppManager().getDriver().get("https://trello.com/home");
    }

    public void checkLoginPageUrl() {
        loginPageUrl = getAppManager().getDriver().getCurrentUrl();
    }

    public void getBoardPage() {
        getAppManager().getDriver().get("https://trello.com/lix373/boards");
    }

    public void checkBoardPageUrl() {
        boardPageUrl = getAppManager().getDriver().getCurrentUrl();
    }
}
