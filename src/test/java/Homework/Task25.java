package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class Task25 extends TestBase {
    /*
Amazona gidin
robot ile sayfanın en altına gidin
"Back to top" weblementini clickleyin
javascriptexecutor ile sayfanın altındaki (footer bölümündeki logo) Amazon logosunu clickleyin
Actions ile Arama kutusuna "ClarusWay" yazdırıp aratın
*/

    @Test
    public void test() throws AWTException, InterruptedException {

        driver.get("https://www.amazon.com/");

        Robot robot = new Robot();
        robot.mouseWheel(80);
        Thread.sleep(5000);

        WebElement backToTop = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
        backToTop.click();

        Thread.sleep(5000);

        WebElement footerLogo = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",footerLogo);

        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        actions.sendKeys("ClarusWay"+ Keys.ENTER)
                .perform();
        Thread.sleep(5000);

    }
}
