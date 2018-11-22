import org.junit.Assert;
import org.junit.Test;

import ru.kpfu.testing.bases.TestBase;
import ru.kpfu.testing.helpers.BoardHelper;
import ru.kpfu.testing.helpers.LoginHelper;
import ru.kpfu.testing.helpers.NavigateHelper;

public class TestTest extends TestBase {

    @Test
    public void getLoginPageTest() throws Exception {
        getAppManager().getNavigateHelper().getLoginPage();
        getAppManager().getNavigateHelper().checkLoginPageUrl();
        Assert.assertEquals(NavigateHelper.loginPageUrl, "https://trello.com/home");
    }

    @Test
    public void doLoginTest() throws Exception {
        getLoginPageTest();
        getAppManager().getLoginHelper().doLogin(LoginHelper.USER);
        getAppManager().getLoginHelper().checkUsername();
        Assert.assertEquals(LoginHelper.USERNAME, "Li (lix373)");
    }

    @Test
    public void getBoardPageTest() throws Exception {
        getLoginPageTest();
        getAppManager().getLoginHelper().doLogin(LoginHelper.USER);
        getAppManager().getNavigateHelper().getBoardPage();
        getAppManager().getNavigateHelper().checkBoardPageUrl();
        Assert.assertEquals(NavigateHelper.boardPageUrl, "https://trello.com/lix373/boards");
    }

    @Test
    public void addBoardTest() throws Exception {
        getBoardPageTest();
        getAppManager().getBoardHelper().addBoard();
        Assert.assertTrue(BoardHelper.isAdded);
    }
}
