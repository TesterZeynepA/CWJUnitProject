package AutomationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_3 extends TestBase {
    /*
    Test Case 3: Login User with incorrect email and password
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter incorrect email address and password
      7. Click 'login' button
      8. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test
    public void testLogin(){

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement loginPage = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        loginPage.click();

        WebElement loginMessage = driver.findElement(By.xpath("//*[contains(text(),'Login to your account')]"));

        Assert.assertTrue(loginMessage.isDisplayed());

        Faker faker = new Faker();

        WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmail.sendKeys(faker.internet().emailAddress());

        WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        loginPassword.sendKeys(faker.internet().password());

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        WebElement incorrectMessage = driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]"));

        Assert.assertTrue(incorrectMessage.isDisplayed());

    }
}
