package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result

        static WebDriver driver;

        @BeforeClass
        public static void setUp(){

            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/styled/index.html");

        }

        @Test
        public void microApp() throws InterruptedException {

            WebElement calculator = driver.findElement(By.xpath("//a[@id='calculatetest']"));

           calculator.click();

            Thread.sleep(3000);

            WebElement searchbox1 = driver.findElement(By.xpath("//input[@id= 'number1']"));

            searchbox1.sendKeys("17");

            Thread.sleep(3000);

            WebElement searchbox2 = driver.findElement(By.xpath("//input[@id = 'number2']"));

            searchbox2.sendKeys("22");

            Thread.sleep(3000);

            WebElement calculateButton= driver.findElement(By.xpath("//input[@id = 'calculate']"));
            calculateButton.click();

        }

        @Test
        public void calculateResult(){

            WebElement answer = driver.findElement(By.xpath("//span[@id='answer']"));

            System.out.println("Answer = " + answer.getText());

        }

        @AfterClass
        public static void tearDown(){

            driver.close();
        }
    }
