package SeleniumChallanges.Day01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CC03 {
     /*
//  go to https://erp.yosemiteint.com/dolibarr/index.php
//  enter username
//  enter password
//  click login button
    verify the title
    //        username.sendKeys("james");
//        password.sendKeys("james123");
     */

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

        driver.get("https://erp.yosemiteint.com/dolibarr/index.php");

        WebElement searchUsername = driver.findElement(By.id("username"));

        WebElement searchPassword = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));

     searchUsername.sendKeys("james");
     searchPassword.sendKeys("james123");
     loginButton.click();

     String actualTitle = driver.getTitle();
     String expectedTitle = "Home - Dolibarr 13.0.2";

     Assert.assertEquals(expectedTitle, actualTitle);


    }


    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}
