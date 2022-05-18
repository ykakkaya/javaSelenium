package lesson3Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class FirstProject {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver= new ChromeDriver();

        //google adresine gidiyorum
        webDriver.navigate().to("https://www.google.com");
        //sayfayı tam ekran yapıyorum
        webDriver.manage().window().maximize();
        //elementlerin tam yüklenmesi için 10 sn bekle yüklendiyse bekleme komutunu veriyorum
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //google arama locator unun xpath ile tesbit edip tanımlıyorum
        WebElement searhBox= webDriver.findElement(By.xpath("//input[@name='q']"));
        //arama kutusuna gireceğim metni yazdım
        searhBox.sendKeys("software test selenium");
        //ara butonunu xpath ile tanımladım ve click() komutunu verdim
        WebElement searchButton= webDriver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        searchButton.click();

        //arama sonuçları geldi hangi sonuca gideceğimi xpath ile tanımladım ve click() ile tıkladım
        WebElement firstSearch=webDriver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[6]"));
        System.out.println("sonuçlardan gidilecek sayfanın text i : "+firstSearch.getText());
        firstSearch.click();

        //son olarak gidilen sayfa doğru mu diye yazdırıp kontrol ettim
        System.out.println("gidilen sayfa: "+ webDriver.getCurrentUrl());

        //5 sn bekle ve daha sonra sayfayı kapat dedim
        sleep(5000);
        webDriver.quit();
    }


}
