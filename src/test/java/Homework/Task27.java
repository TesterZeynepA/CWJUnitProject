package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Task27 extends TestBase {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login page valid credentials.
    //Download sample CSV file.
    //Verify if the file downloaded successfully.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username= driver.findElement(By.xpath("//input[@name='username']"));

        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys("admin123");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));

        loginButton.click();

        WebElement myInfo= driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[6]"));

        myInfo.click();

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);

        WebElement download= driver.findElement(By.xpath("//i [@class='oxd-icon bi-download']"));
        download.click();

        String path = System.getProperty("user.home")+System.getProperty("file.separator")+"Downloads"+
                System.getProperty("file.separator")+"dcadhocimport.txt";

        Assert.assertTrue(Files.exists(Paths.get(path)));






    }
}
