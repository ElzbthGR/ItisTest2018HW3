package ru.kpfu.testing;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import ru.kpfu.testing.bases.AuthBase;
import ru.kpfu.testing.entities.Board;
import ru.kpfu.testing.helpers.BoardHelper;
import ru.kpfu.testing.helpers.NavigateHelper;
import ru.kpfu.testing.util.Settings;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(DataProviderRunner.class)
public class BoardTests extends AuthBase {

    private static final String FILE_PATH = "src/test/resources/json/board.txt";

    @DataProvider
    public static Object[][] boardDataProvider() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(FILE_PATH));
        JSONObject jsonObject = (JSONObject) obj;
        Board board = new Board((String)jsonObject.get("title"));
        Object[][] objs = new Object[1][1];
        objs[0][0] = board;
        return objs;
    }

    @Test
    public void getBoardPageTest() throws Exception {
        getAppManager().getNavigateHelper().getBoardPage();
        getAppManager().getNavigateHelper().checkBoardPageUrl();
        Assert.assertEquals(NavigateHelper.boardPageUrl, Settings.getBoardUrl());
    }

    @Test
    @UseDataProvider("boardDataProvider")
    public void addBoardTest(Board board) throws Exception {
//        getAppManager().getNavigateHelper().getBoardPage();
        getAppManager().getBoardHelper().addBoard(board);
        Assert.assertTrue(BoardHelper.isAdded);
    }
}
