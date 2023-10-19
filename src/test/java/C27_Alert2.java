import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C27_Alert2 {
    /*
    https://the-internet.herokuapp.com/javascript_alerts
     */

    //Click for JS Alert butonuna tikla
//I am a JS Alert alertini kabul et
//JS Confirm butonuna tikla
//I am a JS Confirm alertini iptal et
//JS Prompt butonuna tikla
//I am a JS prompt alertine text yolla ve kabul et

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void alert() throws InterruptedException {

        WebElement alertJs= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertJs.click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement comfirmJs= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        comfirmJs.click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);


        WebElement promptJs= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptJs.click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Hello");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("hello");
        alert.getText();







    }
}
