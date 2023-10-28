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
    //PIM,Configuration
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

        WebElement PIM= driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]"));

        PIM.click();

        WebElement configuration= driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[1]"));
        configuration.click();

        WebElement dataImport = driver.findElement(By.xpath("//a[.='Data Import']"));
        dataImport.click();

        WebElement download=driver.findElement(By.xpath("//a[@class='download-link']"));
        download.click();

        Thread.sleep(2000);

        String path = System.getProperty("user.home")+System.getProperty("file.separator")+"Downloads"+
                System.getProperty("file.separator")+"importData.csv";

        Assert.assertTrue(Files.exists(Paths.get(path)));






    }
}
