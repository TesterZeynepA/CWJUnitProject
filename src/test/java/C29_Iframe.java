import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C29_Iframe {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void basicAuthentication() throws InterruptedException {
        WebElement content = driver.findElement(By.tagName("p"));

        driver.switchTo().frame(content);

    }

}
