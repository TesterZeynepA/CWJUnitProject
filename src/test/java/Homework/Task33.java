package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseReport;

public class Task33 extends TestBaseReport {

    // Go to https://www.amazon.com/
    // Click Accounts & Lists
    // Verify you are on the sign in page

    @Test
    public void test(){

        extentTest = extentReports.createTest("Amazon testi","google search baklava");

        extentTest.info("go to url amazon.com");
        driver.get("https://www.amazon.com/");

        extentTest.info("Click Account & Lists");

        WebElement accountList= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        accountList.click();

        extentTest.info("Verify you are on the sign in page");

        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).isDisplayed());


        //logged as passed
        extentTest.pass("sign in page verifyed");

        //logged as failed
        extentTest.fail("sign in page verify failed");

        //logged as skipped
        extentTest.skip("test ignored");

    }
}
