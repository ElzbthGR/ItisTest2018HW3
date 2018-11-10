package ru.kpfu.testing.helpers;

import org.openqa.selenium.By;
import ru.kpfu.testing.AppManager;
import ru.kpfu.testing.bases.HelperBase;

public class BoardHelper extends HelperBase {

    public BoardHelper(AppManager appManager) {
        super(appManager);
    }

    public void addBoard() {
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[5]/a[1]/span")).click();
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/ul/li[1]/a")).click();
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input")).clear();
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input")).sendKeys("test");
        getAppManager().getDriver().findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/button")).click();
    }
}
