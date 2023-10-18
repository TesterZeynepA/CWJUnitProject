import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C22_DropDown2 {

    /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
    Select 'Opel' using the index and deselect the same using index.
    Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        WebElement dropDown2 = driver.findElement(By.id("cars"));

        Select select1 = new Select(dropDown2);

        Select select2 =new Select(driver.findElement(By.id("cars")));

        Assert.assertTrue(select1.isMultiple());

        select2.selectByIndex(2);

        Thread.sleep(2000);

        select2.deselectByIndex(2);

        Thread.sleep(2000);

        select2.selectByValue("saab");

        Thread.sleep(2000);

        select2.deselectByValue("saab");

        Thread.sleep(2000);

        select1.deselectAll();

        Thread.sleep(2000);








    }
}
