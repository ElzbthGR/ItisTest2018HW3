import org.junit.Assert;
import org.junit.Test;

import ru.kpfu.testing.bases.AuthBase;
import ru.kpfu.testing.helpers.BoardHelper;
import ru.kpfu.testing.helpers.NavigateHelper;

public class TestTest extends AuthBase {

    @Test
    public void getBoardPageTest() throws Exception {
        getAppManager().getNavigateHelper().getBoardPage();
        getAppManager().getNavigateHelper().checkBoardPageUrl();
        Assert.assertEquals(NavigateHelper.boardPageUrl, "https://trello.com/lix373/boards");
    }

    @Test
    public void addBoardTest() throws Exception {
        getAppManager().getNavigateHelper().getBoardPage();
        getAppManager().getBoardHelper().addBoard();
        Assert.assertTrue(BoardHelper.isAdded);
    }
}
