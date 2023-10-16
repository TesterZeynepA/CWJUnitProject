import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_LocatorPractise2 {

//Navigate to website  https://testpages.herokuapp.com/styled/index.html
//Under the Examples
//Click on Locators - Find By Playground Test Page
//Print the URL
//Navigate back
//Print the URL
//Click on WebDriver Example Page
//Print the URL
//Enter value  20 and Enter to "Enter Some Numbers inputBox"
//And then verify 'two, zero' message is displayed
//Close driver.

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

    }

    @Test
    public void webElementMethods1() throws InterruptedException {

        driver.findElement(By.xpath("//a[@id = 'findbytest']")).click();

        // full xpath :  /html/body/div[1]/ul[1]/li[3]/a

        Thread.sleep(2000);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.navigate().back();

        Thread.sleep(2000);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@id='webdriverexamplepage']")).click();

        Thread.sleep(2000);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//input[@id='numentry']")).sendKeys("20" + Keys.ENTER);

        Thread.sleep(2000);

        boolean verify1 = driver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        boolean verify2 = driver.findElement(By.xpath("//*[text()='two, zero']")).isDisplayed();
        Assert.assertTrue(verify1);
        Assert.assertTrue(verify2);

    }


    @AfterClass
    public static void tearDown(){

        driver.close();
    }




}
