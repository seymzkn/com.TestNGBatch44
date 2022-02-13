package tests.Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class Q9 extends TestBase {





    @Test
    public void test01(){
        //   1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        WebElement cookiesAcceptElementi = driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']"));
        cookiesAcceptElementi.click();

        //    2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.linkText("Neues Konto erstellen")).click();

        //    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adButonu=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions=new Actions(driver);

        actions.click(adButonu).sendKeys(Keys.SHIFT).sendKeys("S").keyUp(Keys.SHIFT).
                sendKeys("eyma").
                sendKeys(Keys.TAB).sendKeys(Keys.SHIFT).sendKeys("D").keyUp(Keys.SHIFT).sendKeys("oganalp").
                sendKeys(Keys.TAB).sendKeys("seymadoganalp@gmail.com").sendKeys(Keys.TAB).sendKeys("1234").
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).sendKeys("07").sendKeys(Keys.TAB).sendKeys("05").sendKeys(Keys.TAB).
                sendKeys("1993").sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();



    }

}
