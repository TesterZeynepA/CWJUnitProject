package Homework;

import org.checkerframework.checker.units.qual.A;
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

public class Task10 {
    /**Homework3
     Go to URL: https://demoqa.com/radio-button
     Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
     Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement yesRadio = driver.findElement(By.xpath("//input[@id='yesRadio']"));

        Thread.sleep(2000);

        Assert.assertTrue(yesRadio.isEnabled());

        yesRadio.sendKeys(Keys.SPACE);

        WebElement text1 = driver.findElement(By.xpath("//p[@class='mt-3']"));

        text1.getText();

        Assert.assertTrue(yesRadio.isSelected());

        Thread.sleep(2000);


        WebElement impressiveRadio = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        Thread.sleep(2000);

        impressiveRadio.sendKeys(Keys.SPACE);;

        WebElement text2 = driver.findElement(By.xpath("//p[@class='mt-3']"));

        text2.getText();

        Assert.assertTrue(impressiveRadio.isSelected());

        Thread.sleep(2000);


        WebElement noRadio = driver.findElement(By.xpath("//input[@id='noRadio']"));

        Thread.sleep(2000);

        if (noRadio.isEnabled()) {

            noRadio.sendKeys(Keys.SPACE);

        }


        Assert.assertFalse(noRadio.isEnabled());

        Thread.sleep(2000);



}
}
