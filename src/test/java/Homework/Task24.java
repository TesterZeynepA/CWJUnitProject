package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task24 extends TestBase {

    // https://www.google.com/ u ac
    // Arama kismina  keyboard Actionlarla "Scroll Methodlar"  yaz

    @Test
    public void test(){

        driver.get("https://www.google.com/");

        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.cssSelector("#APjFqb"));

        actions
                .click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethodlar")
                .perform();


    }
}
