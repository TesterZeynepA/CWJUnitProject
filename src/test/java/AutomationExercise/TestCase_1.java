package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_1 extends TestBase {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void test(){
        driver.get("http://automationexercise.com");

        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        WebElement signupLoginButton= driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signupLoginButton.click();

        Assert.assertEquals("New User Signup!",driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]")).getText());

        WebElement nameInput= driver.findElement(By.xpath("//input[@name='name']"));
        nameInput.sendKeys("Zeynep");

        WebElement emailInput= driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailInput.sendKeys("zeyno@gmail.com");

        WebElement signupButton= driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        Assert.assertEquals("ENTER ACCOUNT INFORMATION", driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText());



    }
}
