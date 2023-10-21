package SeleniumChallanges.Day02;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CC10Alerts {
    static WebDriver driver;
    /*
     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
     Launch alert buttonuna tıklayın
     Alert pop-up textin <Hello world!> olduğunu doğrulayın

    */
    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void testAlert() {
        //switchTo ile
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("my-alert")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Hello world!", alert.getText());

        alert.accept();
    }

    @Test
    public void testAlert2() {
        // wait until ile
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("my-alert")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Hello world!", alert.getText());
        alert.accept();
    }

//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}
