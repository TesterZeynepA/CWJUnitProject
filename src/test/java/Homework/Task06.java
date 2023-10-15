package Homework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task06 {

    /**http://the-internet.herokuapp.com/add_remove_elements/
     Click on the "Add Element" button 100 times.
     Write a function that takes a number, and clicks the "Delete" button.
     Given number of times, and then validates that given number of buttons was deleted.
     1. Method: createButtons(100)
     2. Method: DeleteButtonsAndValidate() */

    static WebDriver driver;

     @BeforeClass
     public static void setUp() throws InterruptedException {

          driver= new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("http://automationpractice.com/index.php");

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




     }
