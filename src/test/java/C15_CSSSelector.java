import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C15_CSSSelector {

    /*
    http://the-internet.herokuapp.com/add_remove_elements/
    Click on the "Add Element" button 100 times.
    Write a function that takes a number, and clicks the "Delete" button.
    Given number of times, and then validates that given number of buttons was deleted.
    1. Method: createButtons(100)
    2. Method: DeleteButtonsAndValidate()
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void test() throws InterruptedException {
        createButtons(100);
        Thread.sleep(2000);
        DeleteButtonsAndValidate(25);
        Thread.sleep(2000);

    }

    private void DeleteButtonsAndValidate(int i) {
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOncekiSize = deleteButtonList.size();
        System.out.println(silinmedenOncekiSize);

        for (int j =0; j<i; j++) {
            deleteButtonList.get(j).click();
        }

        List<WebElement> geriyekalaDeleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int sildiktensonrakiSize = geriyekalaDeleteButtonList.size();
        System.out.println(sildiktensonrakiSize);

        //2. yol olarak.
        // for (int j = 0; j < i; j++) {
        //    driver.findElement(By.xpath("//*[@id=\"elements\"]/button[1]")).click();
        //}

        Assert.assertEquals(silinmedenOncekiSize-i, sildiktensonrakiSize);
    }

    private void createButtons(int i) {

        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int j = 0; j < i; j++) {
            addButton.click();

        }


    }
}
