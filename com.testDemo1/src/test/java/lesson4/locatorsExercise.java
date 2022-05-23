package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class locatorsExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        //amazona git
        webDriver.get("https://www.amazon.com.tr");
        //sayfayı tam ekran yap
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sleep(3000);
        //cookies ekranını kabul et
        webDriver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        sleep(1000);
        //arama kutusuna nutella yaz ve enter la
        WebElement searchBox= webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella");
        searchBox.submit();
        //aramada çıkan sonuç sayısını yazdır
        WebElement info= webDriver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(info.getText());
        sleep(1000);
        //driver ı kapat
        webDriver.close();

    }
}
