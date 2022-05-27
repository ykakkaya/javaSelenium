import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Lesson5

{
    WebDriver webDriver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void finish() throws InterruptedException {
        sleep(2000);
        webDriver.close();
    }

    @Test
    public void amazon()
    {
            webDriver.get("https://www.amazon.com.tr");
            webDriver.findElement(By.xpath("//input[@id='sp-cc-accept']")).submit();
            WebElement searchBox=webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            searchBox.sendKeys("nutella");
            searchBox.submit();

        }
    @Test
    public void youtube()
    {
        webDriver.get("https://www.youtube.com");
        WebElement searchBox2=webDriver.findElement(By.xpath("//input[@id='search']"));
        searchBox2.sendKeys("ahmet bulutluoz");
        webDriver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();


    }


}
