package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static java.lang.Thread.sleep;

public class locatorExercise2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        //facebook sayfasına git
        webDriver.get("https://www.facebook.com");
        //sayfayı tam ekran yap
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //email bölümünü doldur
        WebElement emailBox= webDriver.findElement(By.xpath("//input[@id='email']"));
        emailBox.sendKeys("alivelideli.com");
        //password bölümünü doldur
        WebElement passwordBox= webDriver.findElement(By.xpath("//input[@id='pass']"));
        passwordBox.sendKeys("123456");
        //giriş butonuna bas
        webDriver.findElement(By.xpath("//button[@name='login']")).click();
        //çıkan uyarı mesajını al
        WebElement resultMessage= webDriver.findElement(By.xpath("//div[@class='_9ay7']"));
        String actualMessage= resultMessage.getText();
        String expectedMessage="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        //çıkan ve beklenen mesajları karşılaştır
        if(actualMessage.equals(expectedMessage)){
            System.out.println("failed test ok");
        }else{
            System.out.println("failed test not ok");

        }
        sleep(2000);
        //driver i kapat
        webDriver.close();
    }
}
