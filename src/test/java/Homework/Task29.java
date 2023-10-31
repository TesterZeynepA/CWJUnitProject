package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task29 extends TestBase {
    //Go to URL: https://www.monsterindia.com/seeker/registration
//Upload file.

    @Test
    public void test(){

        driver.get("https://www.monsterindia.com/seeker/registration");

        WebElement fileUpload= driver.findElement(By.xpath("//input[@accept='application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document']"));

        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"FileExist";

        fileUpload.sendKeys(path);





    }
}
