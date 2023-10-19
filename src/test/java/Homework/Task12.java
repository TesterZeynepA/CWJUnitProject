package Homework;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task12 {
    //https://demoqa.com/select-menu
    //Get all the options of the dropdown
    //Options size
    //Print all test
    //Verify the dropdown has option "Black"
    //Print FirstSelectedOptionTest
    //Select option "Yellow"

   // Açılır menüdeki tüm seçenekleri alın
    // Seçenek boyutu
    // Tüm testi yazdır
    // Açılır menüde "Siyah" seçeneğinin bulunduğunu doğrulayın
    // FirstSelectedOptionTest Yazdır "Sarı" seçeneğini seçin


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement dropDown = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(dropDown);
        Thread.sleep(2000);

        //Get all the options of the dropdown
        select.getAllSelectedOptions();
        Thread.sleep(2000);

        //Options size
        List<WebElement> selectList = select.getOptions();

        System.out.println("selectList.size() = " + selectList.size());
        Thread.sleep(2000);

        //Print all test
        List<WebElement> selectAllList = select.getOptions();

        for (WebElement element : selectAllList) {

            System.out.println("element.getText() = " + element.getText());
        }
        Thread.sleep(2000);

        //Verify the dropdown has option "Black"
        List <WebElement> dropDownList = select.getOptions();

        for (WebElement element : dropDownList) {

            if(element.getText().contains("Black")){
                System.out.println("dropDownList has Black elements");
            }
        }
        Thread.sleep(2000);

        //Print FirstSelectedOptionTest
        System.out.println("select.getFirstSelectedOption().getText() = "
                + select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        //Select option "Yellow"

        select.selectByVisibleText("Yellow");

    }

}
