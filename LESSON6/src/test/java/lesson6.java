import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.SocketOption;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class lesson6 {
    WebDriver webDriver;
    @Before
    public void startTest(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void endTest(){
        webDriver.close();
    }
    @Test
    public void Test1() throws InterruptedException {
        webDriver.get("https://www.hepsiburada.com");
        WebElement searchBox=webDriver.findElement(By.xpath("//input[@type='text']"));
        searchBox.click();
        searchBox.sendKeys("nutella");
        sleep(3000);
        WebElement araButton= webDriver.findElement(By.xpath("//div[@class='SearchBoxOld-buttonContainer']"));
        araButton.click();
        sleep(2000);
        WebElement nutellaBox= webDriver.findElement(By.xpath("//h3[@type='comfort'][1]"));
        nutellaBox.click();


    }
}
