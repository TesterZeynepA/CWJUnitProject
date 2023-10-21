package SeleniumChallanges.Day02;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CC06Xpath_AxesLocators {

     /*
    (//li[@id='boston']) locate'ine ait parent ul tag'ına ulaş daha sonra tüm li elementlerinin id value'larını yazdır
https://demo.guru99.com/test/selenium-xpath.html
//*[@type='text']//following::input[1]
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        List<WebElement> list=driver.findElements(By.xpath("(//li[@id='boston']/parent::ul)//li"));
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i+1+" "+list.get(i).getAttribute("id"));
         }

        driver.close();

    }

    @Test
    public void test02(){
        driver.get("https://demo.guru99.com/test/selenium-xpath.html");

        String text = driver.findElement(By.xpath("//input[@name='uid']//following::label[1]")).getText();
        Assert.assertEquals("User-ID must not be blank", text);

        driver.close();
    }
}
