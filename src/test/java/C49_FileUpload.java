import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C49_FileUpload extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/upload
    //Find the path of the file that you want to upload.
    //Click on Upload button.
    //Verify the upload message.
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        //C:\Users\zeyne\IdeaProjects\CWJUnitProject\FileExist
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"FileExist";
        dosyaSec.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();

        WebElement successMessage= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(successMessage.isDisplayed());
    }
}
