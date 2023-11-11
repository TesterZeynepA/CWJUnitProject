package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

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
    public  void test() throws InterruptedException {

        driver.get("http://automationexercise.com");

        Actions actions= new Actions(driver);

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement products= driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();

        driver.switchTo().frame("aswift_6");

        driver.switchTo().frame("ad_iframe");

        WebElement reklam= driver.findElement(By.id("dismiss-button"));

        reklam.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement firstProduct= driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[1]"));
        WebElement firstProductAddToCart= driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));

        actions.moveToElement(firstProduct).click(firstProductAddToCart).perform();



        WebElement continueShopping= driver.findElement(By.xpath("//button[@data-dismiss='modal']"));
        continueShopping.click();

        WebElement secondProduct= driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[2]"));

        WebElement secondProductAddToCart= driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"));

        actions.moveToElement(secondProduct).click(secondProductAddToCart).perform();

        WebElement viewCart= driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
        viewCart.click();

        List<WebElement> productList = driver.findElements(By.xpath("//table/tbody/tr"));

        System.out.println(productList.size());

        Assert.assertEquals(2,productList.size());

       // Assert.assertTrue(driver.findElement(By.xpath("//table/tbody/tr[@id='product-2']")).isDisplayed());

        WebElement firstProductPrice= driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]//p[contains(text(),'Rs. 500')]"));

        Assert.assertEquals("Rs. 500", firstProductPrice.getText());

        WebElement firstProductQuantity = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]//button[@class='disabled']"));

        Assert.assertEquals("1", firstProductQuantity.getText());

        WebElement firstProductTotal = driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//p[contains(text(),'Rs. 500')]"));

        Assert.assertEquals("Rs. 500", firstProductTotal.getText());



        WebElement secondProductPrice= driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]//p[contains(text(),'Rs. 400')]"));

        Assert.assertEquals("Rs. 400", secondProductPrice.getText());

        WebElement secondProductQuantity = driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]//button[@class='disabled']"));

        Assert.assertEquals("1", secondProductQuantity.getText());

        WebElement secondProductTotal = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]//p[contains(text(),'Rs. 400')]"));

        Assert.assertEquals("Rs. 400", secondProductTotal.getText());










    }
}
