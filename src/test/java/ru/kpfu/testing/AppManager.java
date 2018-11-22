package ru.kpfu.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kpfu.testing.helpers.BoardHelper;
import ru.kpfu.testing.helpers.LoginHelper;
import ru.kpfu.testing.helpers.NavigateHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AppManager {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    private BoardHelper boardHelper;
    private LoginHelper loginHelper;
    private NavigateHelper navigateHelper;

    private static ThreadLocal<AppManager> app = new ThreadLocal<AppManager>();

    public AppManager() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/ItisTest2018HW3/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        boardHelper = new BoardHelper(this);
        loginHelper = new LoginHelper(this);
        navigateHelper = new NavigateHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigateHelper getNavigateHelper() {
        return navigateHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }
}
