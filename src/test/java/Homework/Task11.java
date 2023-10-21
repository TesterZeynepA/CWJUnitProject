package Homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task11 {
    /*
   Go to URL: https://the-internet.herokuapp.com/dropdown
   Create method selectByIndexTest and Select Option 1 using index .
   Create method selectByValueTest Select Option 2 by value.
   Create method selectByVisibleTextTest Select Option 1 value by visible text.
   Create method printAllTest Print all dropdown value.
   Verify the dropdown has Option 2 text.
   Create method printFirstSelectedOptionTest Print first selected option.
   Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

    */

    static WebDriver driver;
    static Select select;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        selectByIndexTest();

        Thread.sleep(2000);

        selectByValueTest();

        Thread.sleep(2000);

        selectByVisibleTextTest();

        Thread.sleep(2000);

        printAllTest();

        Thread.sleep(2000);

        hasOption2();

        Thread.sleep(2000);

        printFirstSelectedOptionTest();

        Thread.sleep(2000);

        FindTheSizeOfTheDropdown();
    }

    private void FindTheSizeOfTheDropdown() {
        System.out.println("Method 7 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        List<WebElement> selectList = select.getOptions();

        int actualSelectSize = selectList.size();

        int expectedSelectSize = 3;

        System.out.println(actualSelectSize == expectedSelectSize ? "Expected is equal actual " : "Expected is not equal actual");
    }

    private void printFirstSelectedOptionTest() {
        System.out.println("Method 6 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

    }

    private void hasOption2() {
        System.out.println("Method 5 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        List <WebElement> selectAllList = select.getOptions();

        for (WebElement element : selectAllList) {
          if(element.getText().contains("Option 2")){
              System.out.println("SelectAllList has Option 2");
          }
        }

    }


    private void printAllTest() {
        System.out.println("Method 4 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("oldSelectMenu"));

        select = new Select(dropDown);

        List<WebElement> selectAllList = select.getOptions();

        for (WebElement element : selectAllList){

            System.out.println("element.getText() = " + element.getText());

        }

    }

    private void selectByVisibleTextTest() {
        System.out.println("Method 3 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        select.selectByVisibleText("Option 1");

    }

    private void selectByValueTest() {
        System.out.println("Method 2 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        select.selectByValue("2");

    }

    private void selectByIndexTest() {

        System.out.println("Method 1 Çalıştı");

        WebElement dropDown = driver.findElement(By.id("dropdown"));

        select = new Select(dropDown);

        select.selectByIndex(1);

    }
}
