package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_5 extends TestBase {

  /*  Test Case 5: Register User with existing email
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'New User Signup!' is visible
      6. Enter name and already registered email address
      7. Click 'Signup' button
      8. Verify error 'Email Address already exist!' is visible
*/

    @Test
    public void test(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement signUpPage = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpPage.click();

        WebElement signUpMessage= driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]"));

        Assert.assertTrue(signUpMessage.isDisplayed());

        WebElement signUpName= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        signUpName.sendKeys("Azes");

        WebElement signUpEmail= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        signUpEmail.sendKeys("azes1@gmail.com");

        WebElement signUpButton= driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();

        WebElement errorMessage= driver.findElement(By.xpath("//*[contains(text(),'Email Address already exist!')]"));

        Assert.assertTrue(errorMessage.isDisplayed());





    }


}
