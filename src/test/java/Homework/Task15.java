package Homework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Task15 {
    //https://demoqa.com/frames
    //Bu sayfadaki bütün iframeleri 3 yöntemi de kullanarak driver'ı gezdirip anasayfada çıkış yapınız.

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }

    @Test
    public void firstIframe() throws InterruptedException {

        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(0);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame1");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement firstIframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(firstIframe);

        driver.switchTo().defaultContent();
        driver.close();
    }

    @Test
    public void secondIframe() throws InterruptedException {

        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(1);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement firstIframe = driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(firstIframe);

        driver.switchTo().defaultContent();
        driver.close();
    }

    }
