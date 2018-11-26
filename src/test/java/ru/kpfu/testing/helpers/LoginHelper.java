package ru.kpfu.testing.helpers;

import org.openqa.selenium.By;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;
import ru.kpfu.testing.entities.AccountData;

public class LoginHelper extends HelperBase {

    public static AccountData VALID_USER = new AccountData("login", "password");
    public static AccountData INVALID_USER = new AccountData("login", "password1");
    public static String USERNAME;

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void doLogin(AccountData data) throws InterruptedException {
        if (isLoggedIn()) {
            if (isLoggedIn(data)) {
                return;
            }
            doLogout();
        }
        getAppManager().getDriver().findElement(By.linkText("Войти")).click();
        getAppManager().getDriver().findElement(By.id("user")).clear();
        getAppManager().getDriver().findElement(By.id("user")).sendKeys(data.getLogin());
        getAppManager().getDriver().findElement(By.id("password")).click();
        getAppManager().getDriver().findElement(By.id("password")).clear();
        getAppManager().getDriver().findElement(By.id("password")).sendKeys(data.getPassword());
        getAppManager().getDriver().findElement(By.id("login")).click();
        if (!isElementPresent(By.id("errors"))) {
            getAppManager().getDriver().findElement(By.linkText("Перейти к вашим доскам.")).click();
        }
    }

    public void doLogout() {
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[5]/a[4]/span/span[1]")).click();
        getAppManager().getDriver().findElement(By.linkText("Выйти")).click();
    }

//    public void checkUsername() {
//        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[5]/a[4]/span/span[1]")).click();
//        USERNAME = getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[1]/span")).getText();
//    }

    public boolean isLoggedIn() {
        return !isElementPresent(By.linkText("Войти"));
    }

    public boolean isLoggedIn(AccountData accountData) {
        boolean isLoggedin = isLoggedIn();
        return isLoggedin && accountData.getLogin().equals(getLoggedUserName());
    }

    public String getLoggedUserName() {
        getAppManager().getDriver().get("https://trello.com/lix373/account");
        String email;
        if (isElementPresent(By.xpath("//*[@id=\"content\"]/div/div[3]/div[2]/div[2]/div[2]/div/div/p[1]"))) {
            email = getAppManager().getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div[2]/div[2]/div[2]/div/div/p[1]")).getText();
            getAppManager().getNavigateHelper().getBoardPage();
            return email;
        } else {
            email = null;
            getAppManager().getNavigateHelper().getBoardPage();
            return email;
        }
    }
}
