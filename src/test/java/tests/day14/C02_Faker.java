package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void facebookKayitTesti() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']")).click();

        //“create new account”  butonuna basin
        driver.findElement(By.linkText("Neues Konto erstellen")).click();

        //“firstName” giris kutusuna bir isim yazin
        WebElement firstNameButonu=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        actions.click(firstNameButonu).
                sendKeys(faker.name().name())

        //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName())

        //“email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB).
                sendKeys(email)
        //“email” onay kutusuna emaili tekrar yazin
                    .sendKeys(Keys.TAB).
                    sendKeys(email)
        //Bir sifre girin
                .sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
        //Tarih icin gun secin
        sendKeys(Keys.TAB).sendKeys("15").

        //Tarih icin ay secin
       sendKeys(Keys.TAB).sendKeys("Jan.").
        //Tarih icin yil secin
                sendKeys(Keys.TAB).sendKeys("1993")
        //Cinsiyeti secin
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .perform();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement kadinSecimElementi=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement erkekSecimElementi=driver.findElement(By.xpath("//input[@value='1']"));

        Assert.assertTrue(kadinSecimElementi.isSelected());
        Assert.assertFalse(erkekSecimElementi.isSelected());
        //Sayfayi kapatin

        Thread.sleep(5000);
    }

}
