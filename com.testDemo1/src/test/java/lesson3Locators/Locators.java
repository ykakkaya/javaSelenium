package lesson3Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        webDriver.navigate().to("https://www.amazon.com");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //id ile element bulur
        WebElement searchbox= webDriver.findElement(By.id("desktop-grid-2"));
        //link adı ile element bulur
        WebElement adresslinl= webDriver.findElement(By.linkText("Teslimat adresini seçin"));
        //link adının bir parçası ile element bulur
        WebElement adresslink= webDriver.findElement(By.partialLinkText("at adresini seçin"));

        //EN GÜÇLÜ LOCATOR xpath() DİR.//tagname[@element attribute='attribute value'] şeklinde yazılır
        //en çok kullanılan locator dür.
        WebElement amazonSearchBox=webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //cssSelector xpath de kullanılan // ve @ işaretleri kullanılmaz
        WebElement gununFirsatı= webDriver.findElement(By.cssSelector("div[id='nav-cover']"));
    }
}
