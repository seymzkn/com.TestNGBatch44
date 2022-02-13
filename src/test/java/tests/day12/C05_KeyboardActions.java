package tests.day12;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("Samsung A71");

        Actions actions=new Actions(driver);

        actions.click(aramaKutusu).sendKeys(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("A").
                keyUp(Keys.SHIFT).sendKeys("71").
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);

    }
}
