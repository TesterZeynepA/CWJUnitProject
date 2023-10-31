package AutomationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
    public void test() throws InterruptedException {
        driver.get("http://automationexercise.com");

        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        WebElement signupLoginButton= driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signupLoginButton.click();
        Thread.sleep(2000);

        Assert.assertEquals("New User Signup!",driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]")).isDisplayed());

        WebElement nameInput= driver.findElement(By.xpath("//input[@name='name']"));
        nameInput.sendKeys("Zeynep");

        Thread.sleep(2000);

        WebElement emailInput= driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailInput.sendKeys("zeynooo@gmail.com");

        Thread.sleep(2000);

        Actions actions= new Actions(driver);

        WebElement signupButton= driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
       actions.click(signupButton)
               .perform();

        Thread.sleep(2000);

        Assert.assertEquals("ENTER ACCOUNT INFORMATION", driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());

        Thread.sleep(2000);

        WebElement titleMrs= driver.findElement(By.xpath("//input[@id='id_gender2']"));
        titleMrs.sendKeys(Keys.SPACE);

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("A123");

        Thread.sleep(2000);

        WebElement day = driver.findElement(By.id("days"));

        Select select = new Select(day);
        select.selectByValue("13");

        Thread.sleep(2000);

        WebElement month = driver.findElement(By.id("months"));

        Select select1 = new Select(month);
        select1.selectByValue("12");

        Thread.sleep(2000);

        WebElement year = driver.findElement(By.id("years"));

        Select select2 = new Select(year);
        select2.selectByValue("1985");

        Thread.sleep(2000);

        WebElement newsLetter = driver.findElement(By.id("newsletter"));
        newsLetter.sendKeys(Keys.SPACE);

        Thread.sleep(2000);

        WebElement receive= driver.findElement(By.id("optin"));
        receive.sendKeys(Keys.SPACE);

        Thread.sleep(2000);

        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.id("first_name"));

        firstName.sendKeys(faker.lordOfTheRings().character());

        Thread.sleep(2000);

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys(faker.lordOfTheRings().character());

        Thread.sleep(2000);

        WebElement company= driver.findElement(By.id("company"));
        company.sendKeys(faker.lordOfTheRings().location());

        Thread.sleep(2000);

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys(faker.address().fullAddress());

        Thread.sleep(2000);

        WebElement country = driver.findElement(By.id("country"));
        Select select3 = new Select(country);
        select3.selectByValue("India");

        Thread.sleep(2000);

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys(faker.address().state());

        Thread.sleep(2000);

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(faker.address().city());

        Thread.sleep(2000);

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys(faker.address().zipCode());

        Thread.sleep(2000);

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys(faker.phoneNumber().cellPhone());

        Thread.sleep(2000);

        WebElement createAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccount.click();

        Thread.sleep(2000);

        Assert.assertEquals("ACCOUNT CREATED!", driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());

        WebElement continueButton= driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();

        Thread.sleep(5000);

        driver.switchTo().frame("aswift_3");

        WebElement reklam= driver.findElement(By.xpath("//div[@style='cursor: pointer;']"));
        reklam.click();

        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        WebElement deleteAccountButton= driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
        deleteAccountButton.click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed());

        WebElement continueButton2 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton2.click();













    }
}
