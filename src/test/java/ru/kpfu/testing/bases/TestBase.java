package ru.kpfu.testing.bases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import ru.kpfu.testing.AppManager;


public class TestBase {

    private static AppManager appManager = new AppManager();

    @BeforeClass
    public static void setUp() throws Exception {
        getAppManager();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        appManager.stop();
    }

    protected static AppManager getAppManager() {
        return appManager;
    }
}