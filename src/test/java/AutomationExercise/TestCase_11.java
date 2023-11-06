package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase_11 extends TestBase {
    /*
    Test Case 11: Verify Subscription in Cart page
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click 'Cart' button
      5. Scroll down to footer
      6. Verify text 'SUBSCRIPTION'
      7. Enter email address in input and click arrow button
      8. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        Actions actions = new Actions(driver);

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
