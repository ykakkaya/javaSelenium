package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();

        //girilen url adresine gider. https:// girilmelidir.
        webDriver.get("https://www.amazon.com");

        //gidilen sayfanın başlığını döndürür
        System.out.println("sayfa başlığı: "+webDriver.getTitle());

        //gidilen sayfanın url sini geri döndürür.
        System.out.println("sayfa url adresi: "+webDriver.getCurrentUrl());

        //sayfanın kaynak kodlarını çevirir.
        String source=webDriver.getPageSource();

        //içinde bulunulan sayfanın uniq hash kodunu getirir.
        System.out.println("içinde bulunulan sayfanın hash kodu: "+webDriver.getWindowHandle());

        //driver çalışırken açılan tüm sayfaların uniq hash kodunu geri döndürür
        System.out.println("driver çalışırken açılan syfaların hash kodları:"+webDriver.getWindowHandles());




    }
}
