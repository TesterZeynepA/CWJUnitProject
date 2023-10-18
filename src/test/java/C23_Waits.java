import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C23_Waits {

    // bazi siteler, islemeler arasında bekleme süreleri koyar. bundan dolayi bekleme methodlari kulaniriz
    // Selenium wait ler selenium icin kritik bir konsepttir. Senkronize bir sekilde elementleri bulmamizi
    // ve elementnotfound gibi hatalari almamizi engeller.
    // Implicit Wait
    // Explicit Wait *
    // Fluent Wait

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
    public void hardWait() throws InterruptedException {
        //kosulsuz senkronizasyon-statik bekleme
        //statik bekleme, tek basina zaman asimi degerini gosterir
        //ve aracin yalnizca belirtilen sure doldugunda devam etmesini saglar
        //Java ile selenium da statik beklemeyi saglamak icin Thread.sleep() methodunu kullaniriz

        driver.get("https://seleniumatfingertips.wordpress.com/");

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));

    }

    @Test
    public void pageLoadTimeout(){

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
      //  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);
        //30 sn suresince sayfanın yüklenmesini bekliyor,bu süreden sonra sayfa yüklenmezse timeOut duserek hata verir.
        //sayfanin belirtilen sure kadar tamamen yüklenmesini bekler...

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String title = driver.getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Orange"));


    }
}
