package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_4 extends TestBase {
    /*
    Test Case 4: Logout User
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter correct email address and password
      7. Click 'login' button
      8. Verify that 'Logged in as username' is visible
      9. Click 'Logout' button
      10. Verify that user is navigated to login page
     */

    @Test
    public void test(){
        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement loginPage = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        loginPage.click();

        WebElement loginMessage = driver.findElement(By.xpath("//*[contains(text(),'Login to your account')]"));

        Assert.assertTrue(loginMessage.isDisplayed());

        WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmail.sendKeys("azes1@gmail.com");

        WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        loginPassword.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        WebElement loginInAsUsername = driver.findElement(By.xpath("//i[@class='fa fa-user']"));

        Assert.assertTrue(loginInAsUsername.isDisplayed());

        WebElement logOut= driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        logOut.click();

        WebElement loginPage2 = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));

        Assert.assertTrue(loginPage2.isDisplayed());



    }
}
