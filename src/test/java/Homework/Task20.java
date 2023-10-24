package Homework;

import net.bytebuddy.utility.StreamDrainer;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Task20 extends TestBase {

    //Go to URL: https://demoqa.com/browser-windows
    //Click on the windows - "WindowButton"
    //Click on all the child windows.
    //Print the text present on all the child windows in the console.
    //Print the heading of the parent window in the console.

    @Test
    public void test() throws InterruptedException {

        driver.get("https://demoqa.com/browser-windows");

        String windowHandleMain = driver.getWindowHandle();

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        Set<String> handles = driver.getWindowHandles();
        handles.remove(windowHandleMain);
        String windowHandleTab = (String) handles.toArray()[0];

        driver.switchTo().window(windowHandleTab);

        WebElement newTab = driver.findElement(By.id("sampleHeading"));

        System.out.println(newTab.getText());

        driver.switchTo().window(windowHandleMain);


        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        Set<String> handles1 = driver.getWindowHandles();
        handles1.remove(windowHandleMain);
        handles1.remove(windowHandleTab);
        String windowHandleWindow = (String) handles1.toArray()[0];

        driver.switchTo().window(windowHandleWindow);

        WebElement newWindow = driver.findElement(By.id("sampleHeading"));

        System.out.println(newWindow.getText());

        driver.switchTo().window(windowHandleMain);

        WebElement windowMessage = driver.findElement(By.id("messageWindowButton"));
        windowMessage.click();

        Set<String> handles2 = driver.getWindowHandles();
        handles2.remove(windowHandleMain);
        handles2.remove(windowHandleTab);
        handles2.remove(windowHandleWindow);

        String windowHandleMessage = (String) handles2.toArray()[0];


        driver.switchTo().window(windowHandleMessage);

        WebElement messageText = driver.findElement(By.tagName("body"));

        System.out.println(messageText.getText());

        driver.switchTo().window(windowHandleMain);

        System.out.println(driver.getTitle());



    }

}