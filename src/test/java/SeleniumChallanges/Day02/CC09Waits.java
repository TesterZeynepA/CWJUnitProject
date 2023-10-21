package SeleniumChallanges.Day02;

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

public class CC09Waits {
    /*
1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
3)1 + 3
4) ... should be 4, wait for it
*/
    static WebDriver driver;//class seviyesinde tanımlamalıyız
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        driver.findElement(By.id("delay")).clear();
        driver.findElement(By.id("delay")).sendKeys("4");

        rakam(1);
        islem("+");
        rakam(3);
        islem("=");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='screen']"), "4"));
    }

    private void islem(String sembol) {

        driver.findElement(By.xpath("//span[text()='"+sembol+"']")).click();

    }

    private void rakam(int rakam) {

        driver.findElement(By.xpath("//span[text()='"+rakam+"']")).click();
    }
//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//
//    }
}
