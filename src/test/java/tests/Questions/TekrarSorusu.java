package tests.Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class TekrarSorusu extends TestBase{
    //Test01
    //1-amazona gidin
    //2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
    //3- dropdown menude 40 eleman oldugunu dogrulayin

    static WebElement dropdownElementi;
    static Select select;

    @BeforeMethod
    public void baslamaMethodu(){
        driver.get("https://www.amazon.com/");
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);
    }

    @Test
    public void test01(){
        //1-amazona gidin

        //2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
        Select select=new Select(dropdownElementi);

        List<WebElement>optionList= select.getOptions();
        int count=0;
        for (WebElement each: optionList
             ) {

            System.out.println(each.getText());

        }

        //3- dropdown menude 40 eleman oldugunu dogrulayin
        int actualDropDownElementSayisi=optionList.size();
        int expectedDropDownElementSayisi=40;
        Assert.assertEquals(actualDropDownElementSayisi,expectedDropDownElementSayisi,"Dropdown eleman sayisi bekleneni karsilamadi");


    }

    @Test
    public void test02(){
        //1-dropdown menuden elektronik bolumunu secin
        select.selectByVisibleText("Elektronik");

        //2-arama kutusuna iphone yazip aratin ve bulunan sonuc sayisini yazdirin
        WebElement aramaKutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("iphone" + Keys.ENTER);

        //3-sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="iphone";

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

        //4-ikinci urune relative locater kullanarak tiklayin
        WebElement birinciUrunElementi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        WebElement ikinciUrunElementi=driver.findElement(RelativeLocator.with(By.tagName("a")).below(birinciUrunElementi));
        ikinciUrunElementi.click();

        //5-urunun title'ini ve fiyatini variable'a assign edip urunu sepete ekleyelim



    }

    @Test
    public void test03(){
        //Test03
        //1-yeni bir sekme acarak amazon anasayfaya gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select1=new Select(dropdownElementi);



        //2-dropdown'dan bebek bolumunu seciniz
        select1.selectByIndex(2);

        //3- bebek puset aratip bulunan sonuc sayisini yazdirin
        WebElement aramaKutusuButonu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuButonu.sendKeys("kinderwagen" + Keys.ENTER);

        //4-sonuc yazisinin puset icerdigini test edin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucSayisi=sonucSayisiElementi.getText();
        String expectedSonucSayisi="kinderwagen";

        Assert.assertTrue(actualSonucSayisi.contains(expectedSonucSayisi));

        //5-ucuncu urune relative locater kullanarak tiklayin
        WebElement dorduncuUrunElementi = driver.findElement(By.xpath("//img[@data-image-index='4']"));
        WebElement ucuncuUrunElementi = driver.findElement(RelativeLocator.with(By.tagName("img")).below(dorduncuUrunElementi));
        ucuncuUrunElementi.click();

        //6- title ve fiyat bilgilerini assign edelim ve urunu sepete ekleyin
        String  title=driver.getTitle();
        String urunFiyatElementi=driver.findElement(By.xpath("//span[@id='price_inside_buybox']")).getText();

    }



}
