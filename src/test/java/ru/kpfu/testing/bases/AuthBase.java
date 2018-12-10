package ru.kpfu.testing.bases;

import org.junit.AfterClass;
import org.junit.Before;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.entities.AccountData;
import ru.kpfu.testing.helpers.LoginHelper;

public class AuthBase extends TestBase {

    @Before
    public void login() throws InterruptedException {
        AccountData accountData = new AccountData(LoginHelper.VALID_USER.getLogin(), LoginHelper.VALID_USER.getPassword());
        getAppManager().getNavigateHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(accountData);
        Thread.sleep(1000);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        getAppManager().stop();
    }
}
