package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_7 extends TestBase {
/*
      Test Case 7: Verify Test Cases Page
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Test Cases' button
      5. Verify user is navigated to test cases page successfully
 */

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement testCases= driver.findElement(By.xpath("//*[contains(text(),' Test Cases')]"));
        testCases.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']")).getText().contains("TEST CASES"));









    }

}
