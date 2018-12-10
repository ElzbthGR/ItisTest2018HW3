package ru.kpfu.testing;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.testing.bases.TestBase;
import ru.kpfu.testing.helpers.LoginHelper;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() throws Exception {
        getAppManager().getNavigateHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(LoginHelper.VALID_USER);
        boolean isLoggedIn = getAppManager().getLoginHelper().isLoggedIn(LoginHelper.VALID_USER);
        Assert.assertTrue(isLoggedIn);
    }

    @Test
    public void loginWithInvalidData() throws Exception {
        getAppManager().getNavigateHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(LoginHelper.INVALID_USER);
        boolean isLoggedIn = getAppManager().getLoginHelper().isLoggedIn(LoginHelper.INVALID_USER);
        Assert.assertFalse(isLoggedIn);
    }

}
