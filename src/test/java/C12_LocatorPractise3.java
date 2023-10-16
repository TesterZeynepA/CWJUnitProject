import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_LocatorPractise3 {

    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://id.heroku.com/login");

    }

    @Test
    public void loginPage() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='email']"));

        searchbox.sendKeys("abcd@gmail.com");

        Thread.sleep(3000);
        WebElement searchbox2 = driver.findElement(By.xpath("//input[@autocomplete='off']"));

        searchbox2.sendKeys("A12345");

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//button[@name = 'commit']"));
        button.click();
        Thread.sleep(3000);

    }

    @Test
    public void isMessage(){

        WebElement passbox = driver.findElement(By.xpath("//div[contains(text(), 'problem')]"));

        System.out.println(passbox.isDisplayed() ? "Kayıt Yapıldı" : "Kayıt Yapılamadı");

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}
