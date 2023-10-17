package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task06 {

    /** Google arama sayfasını ziyaret edin,
     * arama kutusunu bulmak için xpath locator
     * kullanın ve "Hidden Figures" filmini arayın.
     * */

    static WebDriver driver;

     @BeforeClass
     public static void setUp() throws InterruptedException {

          driver= new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          driver.get("https://www.google.com/");

          Thread.sleep(3000);

     }

     @Test
     public void test01() throws InterruptedException {

          WebElement searchboxRelative = driver.findElement(By.xpath("//textarea[@id = 'APjFqb']"));
          WebElement searchboxAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
          WebElement searchboxDynamic = driver.findElement(By.xpath("//textarea[contains(@id, 'AP')]"));

          searchboxDynamic.sendKeys("Hidden Figures");
          searchboxDynamic.click();

          Thread.sleep(3000);

     }


    @AfterClass
    public static void tearDown(){

        driver.close();
    }

}
