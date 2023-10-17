package Homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
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
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement createAccountButton = driver.findElement(By.xpath("//a[starts-with(@id, 'u_')]"));

        createAccountButton.click();

        Thread.sleep(2000);
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//label[.='Erkek']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

        if(!female.isSelected()){
            female.click();
        }
        Thread.sleep(3000);

        Assert.assertTrue(female.isSelected());
        Assert.assertFalse(male.isSelected());
        Assert.assertTrue(!custom.isSelected());



}
