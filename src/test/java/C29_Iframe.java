import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    }

    @Test
    public void test() throws InterruptedException {

       // WebElement content = driver.findElement(By.tagName("p"));

        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

       //Verify the Bolded text contains "Editor"
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Editor"));

       //Locate the text box
        driver.switchTo().frame("mce_0_ifr");

       //Delete the text in the text box

        WebElement textBox= driver.findElement(By.cssSelector("#tinymce"));

       // textBox.clear();
       // textBox.sendKeys(Keys.BACK_SPACE);

        textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

        Thread.sleep(2000);

        //Type "Hi everyone"

        textBox.sendKeys("Hi everyone");

        //Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

        driver.close();


    }

}
