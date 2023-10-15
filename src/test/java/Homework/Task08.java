package Homework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task08 {


/**https://www.teknosa.com/ adresine gidiniz.
 Arama çubuğuna ‘’oppo’’ yazıp ENTER tıklayınız.
 Sonuç sayısını yazdırınız.
 Çıkan ilk ürüne tıklayınız.
 Sepete ekleyiniz.
 Sepetime gite tıklayınız.
 Konsolda "Sipariş Özeti" WebElement’inin text’ini yazdırınız.
 Alışverişi tamamlayınız.
 Son olarak "Teknosa’ya Hoş Geldiniz" WebElement’inin text’ini yazdırınız.
 Driver’ı kapatınız. */
static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        Thread.sleep(3000);

    }

    @Test
    public void xPathAbsolute() throws InterruptedException {

        WebElement userNameBoxForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));

        userNameBoxForAbsolute.click();

        Thread.sleep(3000);


        WebElement passwordBoxForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        passwordBoxForAbsolute.click();

        Thread.sleep(3000);

        WebElement loginButtonForAbsolute = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        loginButtonForAbsolute.click();

        Thread.sleep(3000);


    }





}
