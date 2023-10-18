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

public class C21_DropDown1 {
//Dropdown : acilir pencere
//Dropdownlar ozel etkilesimler gerektirdiginden dolayi Selenium bize dropdownlar icin ayri bir class olusturmustur..
//Class-> Select

/**Dropdownlar ile calisirken
    * <select> elementi locate edilir  : //select[@id='oldSelectMenu']
    *  select elementi kullanilarak select objesi olusturulur
        Select select = new Select(webElement)
    *  select objesi araciligiyla metodlar kullanilir..
        1-selectByIndex() : option elementinin indexi
        2-selectByValue() : option elementinin value attribute u
        3-selectByVisibleText(): option elementinin gorunur yazisi
    //Select elementlerinde info amaciyla kullanilan methodlar
     select.getAllSelectedOptions(); -> multi selectte secili tum degerleri bize return eden methoddur.
     select.getFirstSelectedOption(); -> Secili ilk option elementini bize getirir.
     select.getOptions(); -> select elementinin tum optionlarini liste halinde return eder
     select.isMultiple(); -> select elementinin multiple secime uygun olup olmadigni bize boolean olarak return eder.

    // 1- deselectByIndex() -> option elementini index ile  kaldirir
    // 2- deselectByValue() -> option elemenini value attribute ile kaldirir
    // 3- deselectByVisibleText() -> option elementini gorunur yazisi (contenti) ile kaldirir
    // 4- deselectAll() -> Butun secimleri kaldirir.
 */

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

    /*
        Launch the browser.
        Open "https://demoqa.com/select-menu".
        Select the Old Style Select Menu using the element id.
        Print all the options of the dropdown.
        Select 'Purple' using the index.
        After that, select 'Magenta' using visible text.
        Select an option using value.
        Close the browser.
     */


    @Test
    public void test() throws InterruptedException {

        WebElement dropDown1 = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(dropDown1);

        List<WebElement> optionsList= select.getOptions();

      //  System.out.println("optionsList = " + optionsList);// referans değerlerini getirir.

        for (WebElement each : optionsList) {

            System.out.println("each.getText() = " + each.getText());
        }


        select.selectByIndex(4);

        Thread.sleep(2000);

        select.selectByVisibleText("Magenta");

        Thread.sleep(2000);

        select.selectByValue("7");


    }





}
