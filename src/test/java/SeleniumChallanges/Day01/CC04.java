package SeleniumChallanges.Day01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CC04 extends TestBase {

     /*
        go to https://the-internet.herokuapp.com/geolocation
        get Where am I? button location
        verify the button location
        */

    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/geolocation");

        WebElement whereAmIButton= driver.findElement(By.xpath("//button[@onclick='getLocation()']"));

        Assert.assertEquals(whereAmIButton,driver.findElement(By.xpath("//button[@onclick='getLocation()']")));




    }

}
