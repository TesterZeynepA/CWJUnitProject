package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase_10 extends TestBase {
    /*
    Test Case 10: Verify Subscription in home page
         1. Launch browser
         2. Navigate to url 'http://automationexercise.com'
         3. Verify that home page is visible successfully
         4. Scroll down to footer
         5. Verify text 'SUBSCRIPTION'
         6. Enter email address in input and click arrow button
         7. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).isDisplayed());

       WebElement subscription= driver.findElement(By.id("susbscribe_email"));
       subscription.sendKeys("azes1@gmail.com"+ Keys.ENTER);

       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-row']")).getText().contains("You have been successfully subscribed!"));

    }
}
