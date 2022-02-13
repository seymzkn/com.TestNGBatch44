package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Odev1 extends TestBase {
    @Test
    public void test01(){
        //soru :ingilizce
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        //maximize the window
        //click on action dialog button
        //if need use explicitly wait
        //click on the ok button
        //accept the iframe message

        //1.soru :Turkce
        //web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        // pencereyi büyüt
        // eylem diyalog düğmesine tıklayın

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='action']"))).click();
        // kullanmanız gerekiyorsa açıkça bekleyin
        // tamam butonuna tıklayın
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dialog-mycodemyway-action']"))).click();

        // iframe mesajını kabul et
        driver.switchTo().alert().accept();

    }
}
