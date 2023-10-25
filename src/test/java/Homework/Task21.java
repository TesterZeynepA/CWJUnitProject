package Homework;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task21 extends TestBase {

    // https://www.hepsiburada.com/ adresine gidin
// Sayfanın windowhandle değerini alın.
// iphone kelimesini aratın
// Sonuçlar arasından 3.ürünün fiyatını alın
// Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
// Herbir ürün sekmesindeki title'ı yazdırın
// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
// Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın


    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.hepsiburada.com/");

        WebElement cerezAyarları= driver.findElement(By.xpath("onetrust-pc-btn-handler"));
        cerezAyarları.click();

        WebElement tumunuKabulEt= driver.findElement(By.xpath("//button[@id='accept-recommended-btn-handler']"));
        tumunuKabulEt.click();

       String windowHandleMain= driver.getWindowHandle();

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='theme-IYtZzqYPto8PhOx3ku3c']"));

        searchBox.sendKeys("iphone"+ Keys.ENTER);

        WebElement thirdElement = driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        System.out.println(thirdElement.getText());

        List<WebElement> urunList = new ArrayList<>(driver.findElements(By.xpath("//div[@class='moria-ProductCard-jmtwOA emdq sexxexybruz sc-Axmtr gyRRhb']")));

        System.out.println(urunList.size());


    }



}
