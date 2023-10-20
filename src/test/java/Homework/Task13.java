package Homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task13 {
    //Go to URL: http://demo.automationtesting.in/Alerts.html
    //Click "Alert with OK" and click 'click the button to display an alert box:’
    //Accept Alert(I am an alert box!) and print alert on console.
    //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    //Cancel Alert (Press a Button !)
    //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    //And then sendKeys «Bootcamp» (Please enter your name)
    //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement alertOk= driver.findElement(By.xpath("//a[.='Alert with OK ']"));
        alertOk.click();

        WebElement alertBox= driver.findElement(By.xpath("//button[@onclick='alertbox()']"));

        alertBox.click();

        Thread.sleep(2000);

        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement alertCancel= driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        alertCancel.click();

        WebElement confirmBox= driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        confirmBox.click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        WebElement alertTextBox= driver.findElement(By.xpath("//a[@href='#Textbox']"));
        alertTextBox.click();

        WebElement promptBox= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        promptBox.click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Zeynep");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String expectedMessage = driver.findElement(By.xpath("//p[@id='demo1']")).getText();

        Assert.assertEquals(expectedMessage, "Hello Zeynep How are you today");


    }
}
