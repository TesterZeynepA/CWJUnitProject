package SeleniumChallanges.Day02;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CC08DropDown {
    /*
1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
3)Choose "Three"
4)Verify option Label
  */
    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        WebElement selectMenu= driver.findElement(By.name("my-select"));
        Select select = new Select(selectMenu);
       String optionLabel= "Three";
       select.selectByVisibleText(optionLabel);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), optionLabel);

    }
   @AfterClass
   public static void tearDown() {
       driver.close();

   }
}
