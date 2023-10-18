package Homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Task09 {
    /**homework2
     Go to URL: https://demoqa.com/
     Click on Elements. // elementse tıklayın
     Click on Checkbox. // checkbox'ı tıklayın
     Verify if Home checkbox is selected. // Home checkbox'ın seçili olduğunu doğrulayın
     Verify that "You have selected" is visible. //"You have selected" mesajının görüldüğünü doğrulayın
     */


    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }//Close driver.

    @Test
    public void helloTest() throws InterruptedException {

        WebElement popUp = driver.findElement(By.xpath("//div[@id='adplus-anchor']"));


        WebElement elements = driver.findElement(RelativeLocator.with(By.tagName("div")).above(popUp));

        elements.click();
        Thread.sleep(2000);

        WebElement elements2= driver.findElement(By.xpath("(//div[@class='header-text'])[1]"));
        elements2.click();

        WebElement checkbox = driver.findElement(By.xpath("//span[contains(text(),'Check')]"));

        checkbox.click();
        Thread.sleep(2000);

        WebElement homeCheckbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));

        Assert.assertTrue(homeCheckbox.isEnabled());

       homeCheckbox.click();

        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//span[.='You have selected :']"));

        Assert.assertTrue(message.isDisplayed());


    }

}
