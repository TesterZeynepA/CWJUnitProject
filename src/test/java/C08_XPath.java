import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_XPath {
    // format: //tagName[@attribute = 'value']

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void byXPath() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='field-keywords']"));

        searchbox.sendKeys("iphone15" + Keys.ENTER);

        Thread.sleep(3000);

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}
