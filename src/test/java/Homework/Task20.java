package Homework;

import net.bytebuddy.utility.StreamDrainer;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

       List<String> handles = new ArrayList<>(driver.getWindowHandles());

        for (int i = 0; i < handles.size(); i++) {

            String windowHandleTab= handles.get(i);

            if (!handles.get(i).equals(windowHandleMain)){

                driver.switchTo().window(windowHandleTab);
            }

        }

        WebElement newTab = driver.findElement(By.id("sampleHeading"));

        System.out.println("Tab Text= " + newTab.getText());

        driver.switchTo().window(windowHandleMain);


        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        List<String> handles1= new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < handles1.size(); i++) {
            String windowHandleWindow= handles1.get(i);
            if (!handles1.get(i).equals(windowHandleMain)){
                driver.switchTo().window(windowHandleWindow);
                break;
            }

        }

        WebElement newWindow = driver.findElement(By.id("sampleHeading"));

        System.out.println("Window Text= " + newWindow.getText());

        driver.switchTo().window(windowHandleMain);

        WebElement windowMessage = driver.findElement(By.id("messageWindowButton"));
        windowMessage.click();


        List<String> handlesList = new ArrayList<>(driver.getWindowHandles());;

        for (int i = 0; i < handlesList.size(); i++) {

           String windowHandleMessage= handlesList.get(i);

            if (!handlesList.get(i).equals(windowHandleMain)){

                driver.switchTo().window(windowHandleMessage);
                break;
            }

        }

        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("Window Message Text= " + text.getText());

        Thread.sleep(2000);

        driver.switchTo().window(windowHandleMain);

        System.out.println(driver.getTitle());


    }

}