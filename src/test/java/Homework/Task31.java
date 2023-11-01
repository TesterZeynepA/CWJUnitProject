package Homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task31 extends TestBase {
    // Go to n11.com.
    // Take Full Page Screenshot.
    // Spesific WebElement ScreenShot (webelement is up to you)

    @Test
    public void test() throws IOException {

        driver.get("https://www.n11.com/");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss").format(new Date());
        File destination = new File(".\\test-output\\Screenshots\\N11FullPage"+ date + ".png");
        FileUtils.copyFile(source,destination);

    }

    @Test
    public void test2() throws IOException {

        driver.get("https://www.n11.com/");
        WebElement n11Logo= driver.findElement(By.xpath("//img[@alt='hayat sana gelir']"));
        File source = n11Logo.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss").format(new Date());

        File destination = new File(".\\test-output\\Screenshots\\n11Logo"+ date + ".png");
        FileUtils.copyFile(source, destination);
    }
}
