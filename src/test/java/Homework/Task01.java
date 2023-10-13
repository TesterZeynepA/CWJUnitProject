package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {

   /** ders sunusundaki webelementleri https://www.linkedin.com/ sayfasinda locate alma
    //id, name, className, linkTest, PLinkTest
    LinkedInLinkedIn*/

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/");

    }

    @Test
    public void locatorId(){
        WebElement searchBox = driver.findElement(By.id("session_key"));
        searchBox.click();

    }

    @Test
    public void locatorName() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.name("session_key"));
        searchBox.click();
        Thread.sleep(3000);
    }

    @Test
    public void locatorClass() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.className("text-color-text"));
        searchBox.click();
        Thread.sleep(3000);

    }

    @Test
    public void locatorTag() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.tagName("input"));
         // searchBox.click();
        Thread.sleep(3000);

    }

    @Test
    public void locatorLinkText() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.linkText("LinkedIn‘de yeni misiniz? Hemen katılın"));
        Thread.sleep(3000);

    }

    @Test
    public void locatorPartialLinkText() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.partialLinkText("Hemen katılın"));
        Thread.sleep(3000);

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }


}
