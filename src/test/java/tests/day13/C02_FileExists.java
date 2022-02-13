package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));

        // masaustundeki Deneme klasörünün Path'ini istesem
        //"C:\Users\admin\Desktop\Deneme\"


        //Yani dinamik olarak masaustumdeki Deneme klasorunun Path'ini yazmak istersem

        String path=System.getProperty("user.home")+"\\Desktop\\Deneme\\";

        System.out.println(path);

        System.out.println("user.dir" + System.getProperty("user.dir"));

        // Masaustunde Deneme klasörü icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // *********** masaustunde Deneme klasörü ve icinde selenium.xlsx olmazsa CALISMAZ***************
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        //projemizde pom.xml oldugunu test edin
        //C:\Users\admin\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); //Projemin yolunu verir

        String pomPath=System.getProperty("user.dir") + "\\pom.xml"; //pomxml in dinamigi

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));


    }
}
