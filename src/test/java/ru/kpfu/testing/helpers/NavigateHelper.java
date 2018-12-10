package ru.kpfu.testing.helpers;

import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;
import ru.kpfu.testing.util.Settings;

public class NavigateHelper extends HelperBase {

//    public static String loginPageUrl;
    public static String boardPageUrl;

    private String boardUrl = Settings.getBoardUrl();
    private String baseUrl = Settings.getBaseUrl();

    public NavigateHelper(AppManager appManager) {
        super(appManager);
    }

    public void getLoginPage() {
        getAppManager().getDriver().get(baseUrl);
    }

    public void getBoardPage() {
        getAppManager().getDriver().get(boardUrl);
    }

    public void checkBoardPageUrl() {
        boardPageUrl = getAppManager().getDriver().getCurrentUrl();
    }
}
