package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseReport;

public class Task34 extends TestBaseReport {
      /*
    Amazon Senaryosu
      https://www.amazon.com.tr/ sitesi açılır.
      Ana sayfanın açıldığı kontrol edilir.
      Çerez tercihlerinden Çerezleri kabul et seçilir.
      Siteye login olunur.
      Login işlemi kontrol edilir.
      Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.
      Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
      Bilgisayar kategorisi seçildiği kontrol edilir.
      Arama alanına msi yazılır ve arama yapılır.
      Arama yapıldığı kontrol edilir.
      Arama sonuçları sayfasından 2. sayfa açılır.
      2'inci sayfanın açıldığı kontrol edilir.
      Sayfadaki 2'inci ürün oluşturulan “Virgosol Liste” listesine eklenir.
      2'inci Ürünün listeye eklendiği kontrol edilir.
      Hesabım  Alışveriş Listesi sayfasına gidilir.
      “Alışveriş Listesi” sayfası açıldığı kontrol edilir.
      Eklenen ürün Virgosol Liste’sinden silinir.
      Silme işleminin gerçekleştiği kontrol edilir.
      Virgosol Liste'si silinir.
      Üye çıkış işlemi yapılır.
      Çıkış işleminin yapıldığı kontrol edilir.
      Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com.tr/");

        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        WebElement cerezKabul= driver.findElement(By.id("sp-cc-accept"));
        cerezKabul.sendKeys(Keys.SPACE);

        WebElement girisYap= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        girisYap.click();
      WebElement inputMail= driver.findElement(By.id("ap_email"));
      inputMail.sendKeys("zeyneppaytop@gmail.com");

      WebElement devemEt= driver.findElement(By.xpath("//input[@id='continue']"));
      devemEt.sendKeys(Keys.SPACE);

      WebElement sifre= driver.findElement(By.id("ap_password"));
      sifre.sendKeys("AzEs1722");

      WebElement girisYap2= driver.findElement(By.id("signInSubmit"));
      girisYap2.sendKeys(Keys.SPACE);

      Assert.assertTrue(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains("Zeynep"));

      driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();

      driver.findElement(By.xpath("//h2[contains(text(),'Listeleriniz')]")).click();

      driver.findElement(By.xpath("//input[@class='a-button-input']")).sendKeys(Keys.ENTER);

      WebElement listeAdi= driver.findElement(By.id("list-name"));

      listeAdi.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
      listeAdi.sendKeys("Virgosol Liste");

      driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]")).sendKeys(Keys.ENTER);

    Thread.sleep(10000);

      WebElement tumKategoriler= driver.findElement(By.id("searchDropdownBox"));

      Select select = new Select(tumKategoriler);

      select.selectByValue("search-alias=computers");

      Assert.assertTrue(tumKategoriler.getText().contains("Bilgisayarlar"));

      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msi"+ Keys.ENTER);

      Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Aranan ürün')]")).getText().contains("Aranan"));

      driver.findElement(By.xpath("(//a[@class='s-pagination-item s-pagination-button'])[1]")).click();

      Assert.assertTrue(driver.getCurrentUrl().endsWith("pg_2"));

      driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[2]")).click();

      driver.findElement(By.id("add-to-wishlist-button-submit")).click();

      WebElement urunEklendi= driver.findElement(By.xpath("//span[contains(text(),'1 ürün şuraya eklendi')]"));

      Assert.assertTrue(urunEklendi.getText().contains("eklendi"));

      WebElement hesapVeListeler= driver.findElement(By.xpath("//span[contains(text(),'Hesap ve Listeler')]"));

        Actions actions = new Actions(driver);

        WebElement hesabım = driver.findElement(By.xpath("//span[contains(text(),'Hesabım')]"));

        actions.moveToElement(hesapVeListeler).click(hesapVeListeler).click(hesabım)
                .perform();

        driver.findElement(By.xpath("//h2[contains(text(),'Listeleriniz')]")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));


        driver.findElement(By.name("submit.deleteItem")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Silindi')]")).getText().contains("Silindi"));

        WebElement dahaFazlası= driver.findElement(By.id("overflow-menu-popover-trigger"));

        WebElement listeyiYönet = driver.findElement(By.id("editYourList"));

        WebElement listeyiSil= driver.findElement(By.xpath("//span[contains(text(),'Listeyi sil')]"));

        actions.moveToElement(dahaFazlası).click(listeyiYönet).click(listeyiSil)
                .perform();

        driver.findElement(By.name("submit.save")).click();

        actions.moveToElement(hesapVeListeler).
                click(driver.findElement(By.xpath("//span[contains(text(),'Çıkış Yap')]")))
                .perform();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Giriş yap')]")).getText().contains("Giriş yap"));



    }
}
