package Homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {

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
        driver.get("https://id.heroku.com/login");

    }

    @Test
    public void loginPage() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='email']"));

        searchbox.sendKeys("jabixi6573@ibtrades.com");

        Thread.sleep(3000);
        WebElement searchbox2 = driver.findElement(By.xpath("//input[@id= 'password']"));

        searchbox2.sendKeys("A.12345");

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//button[@name = 'commit']"));
        button.click();
        Thread.sleep(3000);

    }

    @Test
    public void isMessage(){

        WebElement message = driver.findElement(By.xpath("//*[@id='login']/form/div[1]"));

        System.out.println( message.getText().equals("There was a problem with your login.") ?
                "Kayıt Yapılamadı!" : "Kayıt Başarılı :)");

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}
