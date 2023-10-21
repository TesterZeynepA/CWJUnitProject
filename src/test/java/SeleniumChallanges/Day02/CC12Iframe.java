package SeleniumChallanges.Day02;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CC12Iframe {

    static WebDriver driver;
    /*
     https://bonigarcia.dev/selenium-webdriver-java/iframes.html adresine gidin
     Paragraf sayısının 20 adet oldugunu dogrulayın

    */
    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
/*
ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe") ifadesi,
"my-iframe" adındaki bir iframe'in yüklendiğini bekler. İframe kullanılabilir hale geldiğinde,
bu ifade WebDriver'ın bu iframe'e geçiş yapmasını sağlar.
Bu, iframe içeriğine erişmek ve işlem yapmak için kullanışlıdır.
*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt("my-iframe"));

        By pName = By.tagName("p");
/*
ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0) ifadesi,
sayfadaki bir veya daha fazla web öğesinin (HTML öğeleri)
varlığını bekler. pName bir By nesnesi olmalıdır ve
bu nesnenin temsil ettiği öğelerin sayısının 0'dan fazla olduğunu kontrol eder.
Yani, pName ile belirtilen türdeki web öğelerinin sayısı 0'dan fazla olduğunda
bekleme işlemi sona erer ve test devam eder.
*/
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0));
        List<WebElement> paragraphs = driver.findElements(pName);
        Assert.assertEquals(20, paragraphs.size());

    }

//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}
