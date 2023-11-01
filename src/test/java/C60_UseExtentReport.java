import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseReport;

public class C60_UseExtentReport extends TestBaseReport {
    //go to url google.com
    //search baklava

    @Test
    public void useExtentReport() {
        extentTest = extentReports.createTest("ilk testimiz","google search baklava");

        extentTest.info("go to url google.com");
        driver.get("https://www.google.com/");

        extentTest.info("baklava aratıyoruz");
        driver.findElement(By.id("APjFqb")).sendKeys("baklava"+ Keys.ENTER);

        //logged as passed
        extentTest.pass("baklava arandı");

        //logged as failed
        extentTest.fail("baklava aranamadı");

        //logged as skipped
        extentTest.skip("test ignore edildi");

    }
}
