package AutomationExercise;

import org.checkerframework.checker.units.qual.A;
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
      9. Verify that detail detail is visible: product name, category, price,
       availability, condition, brand
     */

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement products= driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();

        driver.switchTo().frame("aswift_6");

        driver.switchTo().frame("ad_iframe");

        WebElement reklam= driver.findElement(By.id("dismiss-button"));

        reklam.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText().contains("ALL PRODUCTS"));

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked']")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        WebElement productName= driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]"));
        WebElement category= driver.findElement(By.xpath("//p[contains(text(),'Category: Women > Tops')]"));
        WebElement price = driver.findElement(By.xpath("//span[contains(text(),'Rs. 500')]"));
        WebElement availability= driver.findElement(By.xpath("//b[contains(text(),'Availability:')]"));
        WebElement condition = driver.findElement(By.xpath("//b[contains(text(),'Condition:')]"));
        WebElement brand = driver.findElement(By.xpath("//b[contains(text(),'Brand:')]"));

        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(category.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(availability.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());


    }
}
