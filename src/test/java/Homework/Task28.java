package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task28 extends TestBase {
/*
    1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
            3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders
*/

    @Test
    public void test(){

        driver.get("http://practice.automationtesting.in/");

        WebElement shopMenu= driver.findElement(By.linkText("Shop"));
        shopMenu.click();

        driver.findElements(By.xpath("iframe"));
       driver.switchTo().frame("aswift_7");
       WebElement reklamClose= driver.findElement(By.cssSelector("#dismiss-button"));
       reklamClose.click();

       WebElement homeButton= driver.findElement(By.xpath("//*[contains(text(),'Home')]"));
       homeButton.click();

       List<WebElement> sliders= driver.findElements(By.xpath("//class[contains('slider')]"));
        System.out.println(sliders.size());

        Assert.assertEquals(sliders.size(),3);


    }
}
