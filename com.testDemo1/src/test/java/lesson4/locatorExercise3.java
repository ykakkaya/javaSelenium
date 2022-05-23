package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class locatorExercise3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver= new ChromeDriver();
        //bestbuy isimli siteye git
        webDriver.get("https://www.bestbuy.com");
        //sayfayı tam ekran yap.elementler gelene kadar bekle.
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //sayfada bulunan butonların listesini list yapısına at
        List<WebElement>elementList=webDriver.findElements(By.tagName("button"));
        //buton sayısını ve üzerinde yazanları yazdır
        System.out.println("button sayısı: "+elementList.size());
        System.out.println("butonlarda yazan text ler: ");
        for (WebElement item: elementList) {
            System.out.println(item.getText());
        }
        //driver ı kapat.
        webDriver.close();


    }
}
