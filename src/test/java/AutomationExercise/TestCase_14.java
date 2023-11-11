package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

        WebElement shoppingCart = driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]"));
        Assert.assertTrue(shoppingCart.isDisplayed());

        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Azes");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("azes@gmail.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Azra");

        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Aytop");

        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("yedigöze Köyü");

        Select select= new Select(driver.findElement(By.id("country")));

        select.selectByValue("India");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("available");

        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Istanbul");

        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("34000");

        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("54232651");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();

        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Azes')]")).isDisplayed());

        driver.findElement(By.xpath("(//*[contains(text(),' Cart')])[1]")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed());

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Bu ürün çok güzel");

        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

        driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("AZRA AYTOP");

        driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("122365478");

        driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("123");

        driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("11");

        driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2026");

        driver.findElement(By.xpath("//button[@data-qa='pay-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).isDisplayed());

        driver.findElement(By.xpath("//*[contains(text(),' Delete Account')]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();








    }
}
