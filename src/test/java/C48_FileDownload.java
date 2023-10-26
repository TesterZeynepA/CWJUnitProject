import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C48_FileDownload extends TestBase {
    //    Go to URL: https://the-internet.herokuapp.com/download
    //    Download selenium-snapshot.png
    //    Verify if the file downloaded successfully.
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement seleniumSnapshot = driver.findElement(By.linkText("selenium-snapshot.png"));
        seleniumSnapshot.click();


    }
}
