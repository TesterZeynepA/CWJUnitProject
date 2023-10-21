package SeleniumChallanges.Day02;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CC07Faker {
    /*
1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
3)Fill form
4)Verify alert access 10,danger empty
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='first-name']"));
        firstName.sendKeys(faker.name().firstName());
        Thread.sleep(2000);

        WebElement lastName = driver.findElement(By.xpath("//input[@name='last-name']"));
        lastName.sendKeys(faker.name().lastName());
        Thread.sleep(2000);

        WebElement address = driver.findElement(By.xpath("//input[@name='address']"));
        address.sendKeys(faker.address().fullAddress());
        Thread.sleep(2000);

        WebElement zipCode= driver.findElement(By.xpath("//input[@name='zip-code']"));
        zipCode.sendKeys(faker.address().zipCode());
        Thread.sleep(2000);

        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(faker.address().city());
        Thread.sleep(2000);

        WebElement country = driver.findElement(By.xpath("//input[@name='country']"));
        country.sendKeys(faker.address().country());
        Thread.sleep(2000);

        WebElement email= driver.findElement(By.xpath("//input[@name='e-mail']"));
        email.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.phoneNumber().phoneNumber());
        Thread.sleep(2000);

        WebElement jobPosition= driver.findElement(By.xpath("//input[@name='job-position']"));
        jobPosition.sendKeys(faker.job().position());
        Thread.sleep(2000);

        WebElement company= driver.findElement(By.xpath("//input[@name='company']"));
        company.sendKeys(faker.company().name());
        Thread.sleep(2000);

        WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();
        Thread.sleep(2000);

        List<WebElement>alertSucces=driver.findElements(By.xpath("//div[@class='alert py-2 alert-success']"));
        Assert.assertEquals(10, alertSucces.size());


        List<WebElement> alertDanger = driver.findElements(By.name("alert py-2 alert-danger"));
        Assert.assertEquals(0, alertDanger.size());

    }
//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}
