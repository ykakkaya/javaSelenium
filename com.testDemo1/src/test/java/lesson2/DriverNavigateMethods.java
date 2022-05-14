package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        // verilen url ye gider
        webDriver.get("https://www.amazon.com");

        // get() metodunyla aynı işlemi yapar ama back forward yapılmasına imkan sağlar
        webDriver.navigate().to("https://wwww.facebook.com");

        //bir önceki sayfaya dönüş yapar.
        webDriver.navigate().back();

        //tekrar ileri sayfaya gitme imkanı verir
        webDriver.navigate().forward();

        //syfayı yenileme işlemi yapar.
        webDriver.navigate().refresh();

        //açılan browser e kapatır
        webDriver.close();

        //close tuşundan farkı içinde bulunulan tab veya pencereyi kapatır. close veya quit sadece biri çalışır.
        webDriver.quit();
    }
}
