package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public abstract class TestBase {
    /*
     TestBase Class : Her test class’inda tekrar tekrar yazdigimiz setup ve teardown method’lari tekrar
    yazmaktan kurtulmak icin Java OOP konsept’I kullanarak olusturdugumuz bir class’dir
    -Test Base’I parent olarak Kabul eden class’lar hazirlik icin olusturdugumuz driver, setup( ) ve
    teardown( ) olusturmak zorunda kalmazlar, kendilerinde olmasa bile parent class’dan kullanilmis
    olur.
    -TestBase genelde testlerden farkli bir package’da oldugundan driver’i kullanabilmek icin public
    veya protected yapmamiz gerekir. Biz hep child class’lardan kullanacagimiz icin protected yapmayi
    tercih ettik
    -Bu class sadece child class’lardan inheritance ozellikleri ile kullanilsin istedigimizden, bu class’in
    obje olusturularak kullanilmasina engel olmak icin class’I abstract YAPABILIRIZ.
    -Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
    TestBase Class'ı sadece extends ile inherit ederek kullanacağız.
    Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz.
     */

    protected WebDriver driver;


    @Before
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);

      // driver= new ChromeDriver();
     // driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       // driver.quit();
    }

    public void clickElement(By element){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(driver,driver.findElement(element));
        driver.findElement(element).click();
    }
    public void setText(By elemet,String text){
        driver.findElement(elemet).sendKeys(text);
    }
    public void switchToWindow(int tab){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tab));
    }
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
//        pauseMethod(1);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style');", element);

    }

}
