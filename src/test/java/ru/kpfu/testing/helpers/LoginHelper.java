package ru.kpfu.testing.helpers;

import org.openqa.selenium.By;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;
import ru.kpfu.testing.entities.AccountData;

public class LoginHelper extends HelperBase {

    public static AccountData USER = new AccountData("login", "password");

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

}
