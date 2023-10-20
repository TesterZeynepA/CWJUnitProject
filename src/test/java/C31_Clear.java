import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C31_Clear {
    static WebDriver driver;

     //element.clear() ile texti silmedigi zaman sendKeys methodundan faydalanabilriz
    //bu durumda javanin dongulerinden yararlanilanarak text alani bosalana kadar BACKSPACE e tiklayabilirz

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

       //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);//1. iframe e geçiş yaptık

        //Contenti siliyoruz(web element textini siliyoruz)
        //driver.findElement(By.cssSelector("#tinymce")).clear();

        driver.findElement(By.cssSelector("#tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);//clean code

        int times = driver.findElement(By.cssSelector("#tinymce")).getText().length();

        for (int i = 0; i < times; i++) {

            driver.findElement(By.cssSelector("#tinymce")).sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);

        }

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Hello world from cohort3");

        Thread.sleep(3000);

        driver.close();

    }
}
