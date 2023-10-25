package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task23 extends TestBase {
      /*
    Go to URL: http://demo.guru99.com/test/drag_drop.html
    Drag and drop the BANK button to the Account section in DEBIT SIDE
    Drag and drop the SALES button to the Account section in CREDIT SIDE
    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
    Verify the visibility of Perfect text.
 */

    @Test
    public void test(){

        driver.get("http://demo.guru99.com/test/drag_drop.html");


        WebElement first5Bin= driver.findElement(By.xpath("//li[@id='fourth'][1]"));
        WebElement second5Bin= driver.findElement(By.xpath("//li[@id='fourth'][2]"));
        WebElement bank= driver.findElement(By.id("credit2"));
        WebElement sales= driver.findElement(By.id("credit1"));


        WebElement debitAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement debitAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));
        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));


        Actions actions = new Actions(driver);

        actions
                .dragAndDrop(bank,debitAccount)
                .dragAndDrop(sales,creditAccount)
                .dragAndDrop(first5Bin,debitAmount)
                .dragAndDrop(second5Bin,creditAmount)
                .perform();


        WebElement perfect = driver.findElement(By.xpath("//*[contains(text(),'Perfect!')]"));

        Assert.assertTrue(perfect.getText().contains("Perfect!"));

    }
}
