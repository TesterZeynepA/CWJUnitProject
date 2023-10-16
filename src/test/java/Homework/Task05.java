package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task05 {
   /** //Navigate to website  https://testpages.herokuapp.com/styled/index.html
    //Under the Examples
    //Click on Locators - Find By Playground Test Page
    //Print the URL
    //Navigate back
    //Print the URL
    //Click on WebDriver Example Page
    //Print the URL
    //Enter value  20 and Enter to "Enter Some Numbers inputBox"
    //And then verify 'two, zero' message is displayed
    //Close driver. */

   static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        Thread.sleep(3000);

    }

    @Test
    public void xPathAbsolute() throws InterruptedException {

        WebElement userNameBoxForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));

        userNameBoxForAbsolute.click();

        Thread.sleep(3000);


        WebElement passwordBoxForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        passwordBoxForAbsolute.click();

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
