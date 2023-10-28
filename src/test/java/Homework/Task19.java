package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class Task19 extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        String firstWindowHandle = driver.getWindowHandle();

        WebElement text = driver.findElement(By.xpath("//h3[.='Opening a new window']"));

        Assert.assertEquals(text.getText(),"Opening a new window");
        Thread.sleep(3000);
        Assert.assertTrue(text.isDisplayed());

        Assert.assertEquals(driver.getTitle(),"The Internet");
        Thread.sleep(3000);

        WebElement clickText = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickText.click();

        Set<String> handlesList= driver.getWindowHandles();
        handlesList.remove(firstWindowHandle);
        String yeniSekme = (String) handlesList.toArray()[0];

        driver.switchTo().window(yeniSekme);
        Thread.sleep(3000);

        Assert.assertEquals("New Window", driver.getTitle());

        Thread.sleep(3000);
        driver.switchTo().window(firstWindowHandle);

        Assert.assertEquals(driver.getTitle(), "The Internet");

    }

}
