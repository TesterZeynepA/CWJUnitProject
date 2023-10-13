package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Locate the username, password, login button using absolute xpath and relative xpath.
    //URL'ye gidin: https:opensource-demo.orangehrmlive.com Mutlak xpath ve göreceli xpath
    // kullanarak kullanıcı adını, şifreyi ve giriş düğmesini bulun.

        static WebDriver driver;

        @BeforeClass
        public static void setUp() throws InterruptedException {

            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");

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

        @Test
        public void xPathRelative() throws InterruptedException {

            WebElement userNameBoxForRelative = driver.findElement(By.xpath("//input[@name = 'username']"));

            userNameBoxForRelative.click();

            Thread.sleep(3000);


            WebElement passwordBoxForRelative = driver.findElement(By.xpath("//input[@name = 'password']"));

            passwordBoxForRelative.click();

            Thread.sleep(3000);

            WebElement loginButtonForRelative = driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

            loginButtonForRelative.click();

            Thread.sleep(3000);

        }

        @AfterClass
        public static void tearDown(){

            driver.close();
        }
    }
