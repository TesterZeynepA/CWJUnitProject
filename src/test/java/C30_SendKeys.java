import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C30_SendKeys {

    // https://www.amazon.com/ a git
    // Arama kismina herhangi bir kelime yaz
    // Aramayi enter a tiklayarak yap


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
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nikon Camera"+ Keys.ENTER);
        //searchBox.sendKeys("Nikon camera");
        //searchBox.submit();

        driver.close();
    }

    }
