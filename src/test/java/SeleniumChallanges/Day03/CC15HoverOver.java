package SeleniumChallanges.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CC15HoverOver extends TestBase {

    /*
    Web sayfasına gidin  https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
    Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın
    görüntünün üzerine gelin ve görünen yazıyı alın.
    bu yazının, "compass" olup olmadığını doğrulayın.
    İkinci görüntünün üzerine gelin ve görünen yazıyı alın.
    Bu yazının, "calendar" olup olmadığını doğrulayın
    Üçüncü ve dördüncü  görüntüler için aynı işlemleri tekrarlayın.
     */

    @Test
    public void test() throws InterruptedException {

        Actions actions = new Actions(driver);

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        WebElement compass=driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][1]"));
        WebElement calendar=driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][2]"));
        WebElement award=driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][3]"));
        WebElement landscape=driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][4]"));


        String compassText = driver.findElement(By.xpath("(//p[@class='lead py-3'])[1]")).getText();

        actions.moveToElement(compass).perform();
        Thread.sleep(3000);

        Assert.assertTrue(compassText.equals("Compass"));

    }
}
