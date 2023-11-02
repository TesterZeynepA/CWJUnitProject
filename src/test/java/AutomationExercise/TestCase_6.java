package AutomationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_6 extends TestBase {
    /*
    Test Case 6: Contact Us Form
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Contact Us' button
     5. Verify 'GET IN TOUCH' is visible
     6. Enter name, email, subject and message
     7. Upload file
     8. Click 'Submit' button
     9. Click OK button
     10. Verify success message 'Success! Your details have been submitted successfully.' is visible
     11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue(homePage.isDisplayed());

        WebElement contactUs= driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
        contactUs.click();

        WebElement getInTouch= driver.findElement(By.xpath("//*[contains(text(),'Get In Touch')]"));

        Assert.assertTrue(getInTouch.isDisplayed());

        Faker faker =new Faker();
        WebElement name= driver.findElement(By.xpath("//input[@data-qa='name']"));
        name.sendKeys(faker.harryPotter().character());

        WebElement email= driver.findElement(By.xpath("//input[@data-qa='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement subject= driver.findElement(By.xpath("//input[@data-qa='subject']"));
        subject.sendKeys(faker.harryPotter().book());

        WebElement message = driver.findElement(By.id("message"));
        message.sendKeys(faker.harryPotter().spell());

        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"FileExist";
        WebElement uploadFile = driver.findElement(By.name("upload_file"));
        uploadFile.sendKeys(path);

        Thread.sleep(3000);

        WebElement submitButton= driver.findElement(By.xpath("//input[@data-qa='submit-button']"));
        submitButton.sendKeys(Keys.SPACE);
    }
}
