package Homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Task07 {

  /**  Go to http://www.bestbuy.com
    Verify that the page title contains " Hello" Also, using Relative Locator.
            LogoTest → Verify if the BestBuy logo is displayed.
            CanadaLinkTest → Verify if the link is displayed. */

  static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");

        Thread.sleep(3000);

    }

    @Test
    public void xPathAbsolute() throws InterruptedException {

        WebElement textRelative = driver.findElement(By.xpath("//div[text()='Hello!']"));

        Thread.sleep(3000);


        Assert.assertTrue(driver.findElement(RelativeLocator.with(By.tagName("img")).above(textRelative)).isDisplayed());

        Thread.sleep(3000);

        WebElement loginButtonForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        loginButtonForAbsolute.click();

        Thread.sleep(3000);


    }


    @AfterClass
    public static void tearDown(){

        driver.close();
    }



}
