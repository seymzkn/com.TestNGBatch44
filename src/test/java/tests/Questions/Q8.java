package tests.Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import sun.nio.ch.SelChImpl;
import utilities.TestBase;

import java.util.List;

public class Q8 extends TestBase {

    // // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    //        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    //        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    //        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    //        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    @Test
    public void test01() throws InterruptedException {
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN

        driver.get("https://www.facebook.com/");
        WebElement cookiesAcceptElementi = driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']"));
        cookiesAcceptElementi.click();

        Thread.sleep(5000);
        WebElement hesapOlusturButonu=driver.findElement(By.linkText("Neues Konto erstellen"));
        hesapOlusturButonu.click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement dropdownGunlerElementi=driver.findElement(By.xpath("//select[@id='day']"));
        Select select=new Select(dropdownGunlerElementi);

        List<WebElement> optionList=select.getOptions();

        for (WebElement each :optionList
             ) {
            System.out.println("DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESi : " + each.getText());

        }

        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement dropdownAylarElementi=driver.findElement(By.id("month"));

        Select select1=new Select(dropdownAylarElementi);

        List<WebElement>optionList1=select1.getOptions();

        for (WebElement each:optionList1
             ) {
            System.out.println("DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESi : " + each.getText());

        }

        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

        WebElement dropdownYillarElementi=driver.findElement(By.id("year"));

        Select select2=new Select(dropdownYillarElementi);
        List<WebElement>optionList2=select2.getOptions();

        for (WebElement each: optionList2
             ) {
            System.out.println("DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESi : " + each.getText());

        }


    }


}
