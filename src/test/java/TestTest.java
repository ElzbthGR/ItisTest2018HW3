import org.junit.Test;

import ru.kpfu.testing.bases.TestBase;
import ru.kpfu.testing.helpers.LoginHelper;

public class TestTest extends TestBase {

    @Test
    public void getLoginPageTest() throws Exception {
        getAppManager().getNavigateHelper().getLoginPage();
    }

    @Test
    public void doLoginTest() throws Exception {
        getLoginPageTest();
        getAppManager().getLoginHelper().doLogin(LoginHelper.USER);
    }

    @Test
    public void getBoardPageTest() throws Exception {
        doLoginTest();
        getAppManager().getNavigateHelper().getBoardPage();
    }

    @Test
    public void addBoardTest() throws Exception {
        getBoardPageTest();
        //doLoginTest();
        getAppManager().getBoardHelper().addBoard();
    }
}
