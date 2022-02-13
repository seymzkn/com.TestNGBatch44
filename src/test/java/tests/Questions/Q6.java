package tests.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q6 {
    ///● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        ///● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText= driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        String expectedText="Opening a new window";

        Assert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";

        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        WebElement clickHereButton= driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButton.click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle1=driver.getTitle();
        String expectedTitle1="New Window";
        Assert.assertEquals(actualTitle1,expectedTitle1);

        Assert.assertEquals(actualTitle1,expectedTitle1);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualSayfaTexti= driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedSayfaTexti="New Window";

        Assert.assertEquals(actualSayfaTexti,expectedSayfaTexti);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.navigate().back();

        String actualNewWindowTitle=driver.getTitle();
        String expectedNewWindowTitle="The Internet";

        Assert.assertEquals(actualNewWindowTitle,expectedNewWindowTitle);



    }


    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
