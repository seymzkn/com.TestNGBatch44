package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q04 {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high (fiyati aydan coga sirala)
     *     T2 : Verify item prices are sorted from low to high with soft Assert(fiyatin azdan coga oldugunu soft assert yapin)
     */

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
        //* Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        //     * Enter the user name  as standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //     * Enter the password as   secret_sauce
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //     * Click on login button
        driver.findElement(By.id("login-button")).click();

        //     *     T1 : Choose price low to high (fiyati aydan coga sirala)
        WebElement dropDownElementi=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropDownElementi);
        select.selectByIndex(2);

        //     *     T2 : Verify item prices are sorted from low to high with soft Assert(fiyatin azdan coga oldugunu soft assert yapin)
            String actual=driver.findElement(By.className("active_option")).getText();
            String expected="PRICE(LOW TO HIGH)";

        Assert.assertEquals(actual,expected);


    }

    @AfterClass
    public void teardown(){
        //driver.close();
    }


}
