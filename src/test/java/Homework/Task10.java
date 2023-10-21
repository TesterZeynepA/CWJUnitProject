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
import java.util.List;

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

        impressiveRadio.sendKeys(Keys.SPACE);

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
//2. yol
    @Test
    public void test2() {

        driver.get("https://demoqa.com/radio-button");

        List<WebElement> rButtons = driver.findElements(By.xpath("//input[@name='like']"));
        for (WebElement rButton : rButtons) {
            String selectedId = rButton.getAttribute("id");
            if (!rButton.isEnabled()) {
                System.out.println(selectedId + " is not enabled");
                continue;
            }
            rButton.sendKeys(Keys.SPACE);
            if (rButton.isSelected()) {
                System.out.println("Selected Text : " + selectedId);
            }
            Assert.assertTrue(selectedId + " is selected", rButton.isSelected());
        }
    }

    //3.yol
    @Test
    public void testRadioButton() {
        // Go to URL: https://demoqa.com/radio-button
        driver.get("https://demoqa.com/radio-button");
        WebElement yes = driver.findElement(By.xpath("//label[contains(text(), 'Yes')]"));
        WebElement impressive = driver.findElement(By.xpath("//label[contains(text(), 'Impressive')]"));
        WebElement no = driver.findElement(By.xpath("//label[contains(text(), 'No')]"));
        yes.click();
        WebElement text = driver.findElement(By.xpath("//*[text()='You have selected ']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println("text = " + text.getText());
        impressive.click();
        System.out.println("text = " + text.getText());
        no.click();
        System.out.println("text = " + text.getText());
    }
}

        // getAttribute() : Belirtilen bir Web Element’in attribute değerini alır.
// Parametre olarak String kullanır ve sonucu olarak bir String değeri döndürür.


