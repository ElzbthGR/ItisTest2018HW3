package ru.kpfu.testing.bases;

import org.junit.BeforeClass;
import ru.kpfu.testing.AppManager;


public class TestBase {

    private static AppManager appManager = new AppManager();

    @BeforeClass
    public static void setUp() {
        TestBase.getAppManager();
    }

    protected static AppManager getAppManager() {
        return appManager;
    }
}