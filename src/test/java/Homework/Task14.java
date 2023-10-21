package Homework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task14 {
    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    //Exit the iframe and return to the main page.

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/guru99home/");

     List<WebElement> numberOfIframe= driver.findElements(By.tagName("iframe"));
        System.out.println("numberOfIframe.size() = " + numberOfIframe.size());

        Thread.sleep(2000);

       WebElement jMeterIframe =driver.findElement(By.id("a077aa5e"));
       jMeterIframe.click();

       Thread.sleep(2000);

       driver.switchTo().defaultContent();

       Thread.sleep(2000);

       driver.close();




    }

}
