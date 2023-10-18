package SeleniumChallanges.Day01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CC02 {

    /*
  TESTLİO(https://testlio.com/) LİVE INTERVİEW QUESTION
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Test whether the Home page has Three Sliders only
4) The Home page must contains only three sliders
  */
    static WebDriver driver;//class seviyesinde tanımlamalıyız
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

            driver.get("http://practice.automationtesting.in/");
            List<WebElement> sliderList =driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']//div[@data-slide-duration='0']"));
//        for (int i = 0; i <sliderList.size() ; i++) {
//            System.out.println("sliderList.get(i).getText() = " + sliderList.get(i).getText());
//        }
            Assert.assertEquals(2, sliderList.size());
    }

   @AfterClass
   public static void tearDown() {
       driver.close();

   }
}

