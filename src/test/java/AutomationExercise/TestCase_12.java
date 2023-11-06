package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_12 extends TestBase {
    /*
    Test Case 12: Add Products in Cart
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click 'Products' button
     5. Hover over first product and click 'Add to cart'
     6. Click 'Continue Shopping' button
     7. Hover over second product and click 'Add to cart'
     8. Click 'View Cart' button
     9. Verify both products are added to Cart
     10. Verify their prices, quantity and total price
     */

    @Test
    public  void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());




    }
}
