package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_9 extends TestBase {
    /*
    Test Case 9: Search Product
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Products' button
     5. Verify user is navigated to ALL PRODUCTS page successfully
     6. Enter product name in search input and click search button
     7. Verify 'SEARCHED PRODUCTS' is visible
     8. Verify all the products related to search are visible
     */

    @Test
    public void testSearchProduct(){
        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement products= driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();

      //  driver.switchTo().frame("aswift_6");
//
      //  driver.switchTo().frame("ad_iframe");
//
      //  WebElement reklam= driver.findElement(By.id("dismiss-button"));
//
      //  reklam.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText().contains("ALL PRODUCTS"));

        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='productinfo text-center']")).getText().contains("Men Tshirt"));







    }
}
