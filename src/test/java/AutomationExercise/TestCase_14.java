package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase_14 extends TestBase {
    /*
    Test Case 14: Place Order: Register while Checkout
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click Proceed To Checkout
    8. Click 'Register / Login' button
    9. Fill all details in Signup and create account
    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    11. Verify ' Logged in as username' at top
    12.Click 'Cart' button
    13. Click 'Proceed To Checkout' button
    14. Verify Address Details and Review Your Order
    15. Enter description in comment text area and click 'Place Order'
    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    17. Click 'Pay and Confirm Order' button
    18. Verify success message 'Your order has been placed successfully!'
    19. Click 'Delete Account' button
    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void test(){
        driver.get("http://automationexercise.com");

        Actions actions = new Actions(driver);

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement addToCartProduct = driver.findElement(By.xpath("(//*[contains(text(),'Add to cart')])[1]"));
        actions.moveToElement(addToCartProduct).click(addToCartProduct).perform();

        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

        actions.sendKeys(Keys.PAGE_UP).perform();

        driver.findElement(By.xpath("(//*[contains(text(),'Cart')])[1]")).click();



    }
}
