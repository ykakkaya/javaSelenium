package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();

        System.out.println("=====window mtodları=====");

        //içerisinde olunan sayfanın ölçülerini döndürür
        System.out.println("ilk size: "+webDriver.manage().window().getSize());

        //açılan pencerenin konumunu döndürür sol alt köseden
        System.out.println("ilk position: "+webDriver.manage().window().getPosition());

        //sayfa ölçülerini değiştirmemzi sağlar. new ile dimension nesnesi oluştur
        webDriver.manage().window().setSize(new Dimension(600,600));

        //sayfanın konumunu değiştirmemizi sağlar.new ile point nesnesi oluştur.
        webDriver.manage().window().setPosition(new Point(15,15));

        System.out.println("yeni atanan pozisyon: "+webDriver.manage().window().getPosition());
        System.out.println("yeni atanan size: "+ webDriver.manage().window().getSize());

        //sayfayı tam size yapar.
        webDriver.manage().window().maximize();
        System.out.println("maximize sonrası :"+webDriver.manage().window().getPosition());
        System.out.println("maximize sonrası size: "+ webDriver.manage().window().getSize());

        //sayfayı fullscreen size yapar
        webDriver.manage().window().fullscreen();
        System.out.println("fullscreen sonrası position: "+ webDriver.manage().window().getPosition());
        System.out.println("fullscreen sonrası size: "+ webDriver.manage().window().getSize());

        //sayfayı simge durumunda küçültür.
        webDriver.manage().window().minimize();


        System.out.println("=====timeout metodları=====");
        // selenium çalışmasını duration cinsinden bekletir
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        webDriver.quit();

        /*
           implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz webelementlerin bulunmasi icin
           bekleyecegi maximum sureyi belirtir.
           driver bu sure icerisinde sayfa yuklenir/web element bulunursa
           beklemeden calismaya devam eder.
           bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
           exception vererek calismayi durdurur
                Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                         Yani driver'a ne kadar bekleyecegini soyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
         */

        /* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
                    driver.manage() method'larindan
                    maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
                    FAYDALI OLACAKTIR
         */


    }
}
