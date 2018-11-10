package ru.kpfu.testing.bases;

import org.junit.After;
import org.junit.Before;
import ru.kpfu.testing.AppManager;


public class TestBase {

    private AppManager appManager;

    @Before
    public void setUp() throws Exception {
        setApp(new AppManager());
    }

    @After
    public void tearDown() throws Exception {
        appManager.stop();
    }

    protected void setApp(AppManager appManager) {
        this.appManager = appManager;
    }

    protected AppManager getAppManager() {
        return appManager;
    }
}