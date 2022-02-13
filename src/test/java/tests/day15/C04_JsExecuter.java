package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuter extends TestBase {

    //amazon.com anasayfaya gidip
    // sell linkine JSExecuter ile tiklayalim
    // ilgili sayfaya gittigimizi test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //1. adim JSExecutor objesi olusturalim ve driver i cast edelim

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        //2. adim ilgili web elementi locate edelim
        WebElement sellelementi= driver.findElement(By.xpath("//a[text()='Verkaufen bei Amazon']"));

        //3. adim ilgili script ve argument(bizim web elementimiz) ile objemiz uzerinden
        //  executeScript methodunu calistiralim

        jse.executeScript("arguments[0].click()",sellelementi);

        Thread.sleep(5000);
    }
}
