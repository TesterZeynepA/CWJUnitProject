import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C09_WebElementCommands {

    //    sendKeys(String keys) methodu elementimize gonderilen degerleri klavyeyle yazarmis gibi gonderir
//    isDisplayed() bize boolean ifadeler dondurur!!!!!!!!!! Elementin sayfada goruntulenip goruntulenmedigi bilgisini verir
//    isSelected() methodumuz bize elementin secili olup olmadigi bilgisini verir. (checkbox, radio)
//    isEnabled() bir elementin aktif mi degil mi oldugunun bilgisini verir (button ve girdi yapilan elementlerde kullanilabilir)
//    submit() methodu formlari submit etmemize yani gondermemize yardimci olur. ENTER tusunun gorevini gorur.
//    click() methodu bir elemente sol tiklamamizi saglar.
//    getLocation() methodu bize elementin konumunu verir
//    clear() methodu input alanlarindaki yazilarin temizlenmesini saglar.
//    getText() methodu elementin contentini bize verir
//    getAttribute(String key) methodu bize elementin istedigimiz attribute degerini getirir.
//    getSize() elementin boyutunu bize verir.


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void webElementMethods() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='field-keywords']"));

        searchbox.sendKeys("iphone15" + Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement searchbox2 = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        searchbox2.sendKeys("galaxy A73");
        searchbox2.submit();

        Thread.sleep(3000);

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }

}
