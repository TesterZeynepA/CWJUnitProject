package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_8 extends TestBase {

    /*
    Test Case 8: Verify All Products and product detail page
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Products' button
      5. Verify user is navigated to ALL PRODUCTS page successfully
      6. The products list is visible
      7. Click on 'View Product' of first product
      8. User is landed to product detail page
      9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement products= driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText().contains("ALL PRODUCTS"));

    }
}
