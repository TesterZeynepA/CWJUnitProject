package SeleniumChallanges.Day01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CC05 {
    /*
1) Open the browser
2) Enter the URL "https://hava-durumu-apps.netlify.app/"
3) Enter Istanbul on ınput area
4) Verify result contains Istanbul
*/

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://hava-durumu-apps.netlify.app/");

      driver.findElement(By.xpath("//input[@id='input']")).sendKeys("Istanbul");

      Thread.sleep(5000);

        WebElement resultArea = driver.findElement(By.xpath("//h2[@class='text-2xl font-semibold mb-3']"));

        Assert.assertEquals("Istanbul", resultArea.getText());

    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}
