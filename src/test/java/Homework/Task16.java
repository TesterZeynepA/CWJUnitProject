package Homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task16 {
    /**
     * Go to URL: https://opensource-demo.orangehrmlive.com/
     * Login with Username: Admin
     * Login with Password: admin123
     * Click login button
     * Click on PIM
     * Click on Employee List
     * Employee Name → Use Faker Class
     * Click search button
     * Verify text visible : "No Records Found"
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        Faker faker = new Faker();


        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));

        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        loginButton.click();

        WebElement PIM = driver.findElement(By.xpath("//span[.='PIM']"));
        PIM.click();

        WebElement employeeList = driver.findElement(By.xpath("//a[.='Employee List']"));
        employeeList.click();

        WebElement employeeName = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
        employeeName.sendKeys(faker.name().fullName());

        WebElement searchButton = driver.findElement(By.xpath("//button[.=' Search ']"));
        searchButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[.='No Records Found']")).getText(), "No Records Found");


    }

}