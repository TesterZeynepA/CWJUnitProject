import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class C24_Waits {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void implicitWait() {
        /* Implicit wait :
       Tüm sayfadaki elemanlar için bir bekleme süresi atanıyor.Ancak eleman bulunduğu anda daha fazla beklemiyor.
       Bütüm elemanlar geçerlidir.NoSuchElement hatasını vermek için verilen süre kadar eleman bulunana kadar bekler.
       globaldir, butun webelementler icin bekler..
         */
        driver.get("https://seleniumatfingertips.wordpress.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Group Test in TestNg yazısının görünürlüğünü test ediniz.
        WebElement groupTxt = driver.findElement(By.partialLinkText("Group Test"));
        Assert.assertTrue(groupTxt.isDisplayed());
    }

    @Test
    public void explicitWait(){

        /*WebDriver'ın beklemesi gereken koşulu ve zamanı belirtir.
        Pratik olarak, WebDriverWait ve explicitly wait,
        tanımları ve kullanımları mükemmel bir şekilde eşleştiğinden eş anlamlıdır.
        //Explicit wait nasil kullanilir
        // 1- WebDriverWait objesi olustur
        // 2- wait objesinin until methoduna istedigin condition u sagla.*/
        //https://seleniumatfingertips.wordpress.com/

        driver.get("https://seleniumatfingertips.wordpress.com/");
      //  WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement home = driver.findElement(By.linkText("Home"));

        //assumption : kodumuz bu noktada element yükleme durumda olduğundan
        //locate edilebilir ancak tıklanmayabilir. bu durumda ElementNotClickable hatası fırlatır...
        //wait objesinin until methoduna istediğimiz condition u sağlarız.

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(15));
        //sadece süre tanımlandı, henüz aktif değil,
        //15 saniye beklemek zorunda değil,eleman bulunduğu anda işleme devam eder.

        wait.until(ExpectedConditions.visibilityOf(home));//görünür olana kadar bekle.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));//locate edilene kadar bekle
    }

    @Test
    public void fluentWait(){
        //neredeyse hic kullanilmaz..
        //elementleri belirlenen sure boyunca sarti saglayip saglamadigi kontrol edilir
        //sarti sagladigi anda devam edilir, saglamazsa exception firlatir..
        driver.get("https://seleniumatfingertips.wordpress.com/");
        WebElement home = driver.findElement(By.linkText("Home"));

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))//toplam bekleme süresi sayfa ilk açıldığında
                .pollingEvery(Duration.ofSeconds(20))//yoklama, her 20 sn de varlık kontrolü
                .ignoring(NoSuchElementException.class);//exception ı görmezden gelir, veya engeller.

    }




}
