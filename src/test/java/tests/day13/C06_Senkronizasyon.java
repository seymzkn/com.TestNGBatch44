package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
        */

        /*
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//yt-formatted-string[text()='Ich stimme zu']")).click();


        driver.get("https://www.techproeducation.com/");

        driver.findElement(By.xpath("(//li[@class='nav-item'])[1]")).click();
        */

         //https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //enable butonuna basin
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //enabled yazisinin ciktigini test edin

        WebElement enabledYaziElementi=driver.findElement(By.xpath("//p[.=\"It's enabled!\"]"));
        Assert.assertTrue(enabledYaziElementi.isDisplayed());


    }
}
