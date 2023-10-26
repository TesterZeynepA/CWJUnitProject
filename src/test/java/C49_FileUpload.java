import org.junit.Test;
import utilities.TestBase;

public class C49_FileUpload extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/upload
    //Find the path of the file that you want to upload.
    //Click on Upload button.
    //Verify the upload message.
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/upload");



    }
}
