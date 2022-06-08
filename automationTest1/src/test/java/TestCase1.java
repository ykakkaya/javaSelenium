import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestCase1 {
    WebDriver webDriver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void finishTestCase(){
        webDriver.close();
    }
    @Test
    public void Test1() throws InterruptedException {

        //http://automationexercise.com sayfasına giriş
        webDriver.get("http://automationexercise.com");
        WebElement logoTest= webDriver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        //logonun görünüp görünmediğini denetliyoruz
        Assert.assertTrue(logoTest.isDisplayed());
        sleep(2000);
        //login bölümüne giriş
        WebElement loginButton= webDriver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        loginButton.click();
        sleep(2000);
        //Login to your account yazısını gördüğümüzü onaylıyoruz.
        WebElement loginPageTest= webDriver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginPageTest.isDisplayed());
        //new user bölümü name girişi
        WebElement newName= webDriver.findElement(By.xpath("//input[@type='text']"));
        newName.sendKeys("testCase");
        sleep(1000);
        //new user bölümü email girişi
        WebElement emailButton= webDriver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailButton.sendKeys("abc@abc.com");
        sleep(1000);
        //sign up butonuna tıkla
        WebElement submitButton= webDriver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        submitButton.click();
        sleep(1000);
        WebElement textonay= webDriver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(textonay.isDisplayed());



    }


}
