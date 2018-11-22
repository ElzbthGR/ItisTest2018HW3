package ru.kpfu.testing.helpers;

import org.openqa.selenium.By;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;
import ru.kpfu.testing.entities.AccountData;

public class LoginHelper extends HelperBase {

    public static AccountData USER = new AccountData("login", "password");
    public static String USERNAME;

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void doLogin(AccountData data) {
        getAppManager().getDriver().findElement(By.linkText("Войти")).click();
        getAppManager().getDriver().findElement(By.id("user")).clear();
        getAppManager().getDriver().findElement(By.id("user")).sendKeys(data.getLogin());
        getAppManager().getDriver().findElement(By.id("password")).click();
        getAppManager().getDriver().findElement(By.id("password")).clear();
        getAppManager().getDriver().findElement(By.id("password")).sendKeys(data.getPassword());
        getAppManager().getDriver().findElement(By.id("login")).click();
        getAppManager().getDriver().findElement(By.linkText("Перейти к вашим доскам.")).click();
    }

    public void checkUsername() {
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[5]/a[4]/span/span[1]")).click();
        USERNAME = getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[1]/span")).getText();
    }

}
