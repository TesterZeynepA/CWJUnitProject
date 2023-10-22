package Homework;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task17 {

    /**Go to "https://demo.guru99.com/test/newtours/register.php"
     * Sayfadaki inputları faker class ile doldur.
     * dropdown bölümünü value ile doldur.
     * Gönder Butonunu tıkla
     * çıkan text de Note: "Your user name is" yazısının olduğunu doğrulayınız.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        WebElement firstName= driver.findElement(By.name("firstName"));
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys(faker.name().lastName());

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(faker.phoneNumber().phoneNumber());

        WebElement eMail= driver.findElement(By.name("userName"));
        eMail.sendKeys(faker.internet().emailAddress());

        WebElement address= driver.findElement(By.name("address1"));
        address.sendKeys(faker.address().fullAddress());


        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys(faker.address().city());


        WebElement province= driver.findElement(By.name("state"));
        province.sendKeys(faker.address().state());

        WebElement postalCode= driver.findElement(By.name("postalCode"));
        postalCode.sendKeys(faker.address().zipCode());

        WebElement countrySelect = driver.findElement(By.name("country"));
        Select select= new Select(countrySelect);

        select.selectByValue("TURKEY");

        WebElement userName= driver.findElement(By.id("email"));
        userName.sendKeys(faker.name().username());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("12345");

        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("12345");

        WebElement gonderButton = driver.findElement(By.name("submit"));
        gonderButton.click();

        WebElement text = driver.findElement(By.xpath("//*[contains(text(),' Note: Your user name is')]"));

        Assert.assertTrue(text.getText().contains("Your user name is"));

    }

    }
