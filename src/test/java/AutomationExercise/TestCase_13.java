package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase_13 extends TestBase {
 /*
    Test Case 13: Verify Product quantity in Cart
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity

  */

    @Test
    public void test(){
        driver.get("http://automationexercise.com");

        Actions actions =new Actions(driver);

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement viewProduct =driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]"));
        actions.moveToElement(viewProduct).click(viewProduct).perform();

        driver.switchTo().frame("aswift_6");
        driver.switchTo().frame("ad_iframe");

        WebElement reklam = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
        reklam.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));

        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        quantity.sendKeys("4");

        WebElement addToCart= driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
        addToCart.click();

        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

        WebElement cartQuantity= driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]//button[@class='disabled']"));

        Assert.assertEquals("4", cartQuantity.getText());












    }
}
