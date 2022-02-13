package tests.day08;

import org.testng.annotations.Test;

public class C01_Notations {

    @Test(priority = 9)
    public void youtubeTesti(){
        System.out.println("Youtube testi calisti");

    }

    @Test(priority = 0)
    public void amazonTesti(){  // priority atanmazsa priority=0 kabul eder
        System.out.println("Amazon testi calisti");

    }

    @Test
    public void bestbuyTesti(){ // once -9 calisir kalan ikisi harf sirasina gore siralanir
        System.out.println("Bestbuy testi calisti");

    }
}
