package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

      // https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");

      JavascriptExecutor jse = ((JavascriptExecutor) driver);

      // Ana sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cerezKabul= driver.findElement(By.id("sp-cc-accept"));
        cerezKabul.sendKeys(Keys.SPACE);

        //Siteye login olunur.
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

      // Login işlemi kontrol edilir.
      Assert.assertTrue(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains("Zeynep"));

      //Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.
      driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();

     WebElement listeleriniz= driver.findElement(By.xpath("(//span[@class='a-color-secondary'])[9]"));

     listeleriniz.click();

      driver.findElement(By.xpath("//input[@class='a-button-input']")).sendKeys(Keys.ENTER);

      WebElement listeAdi= driver.findElement(By.id("list-name"));

      listeAdi.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
      listeAdi.sendKeys("Virgosol Liste");

      driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]")).sendKeys(Keys.ENTER);

    Thread.sleep(10000);

    // Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.

      WebElement tumKategoriler= driver.findElement(By.id("searchDropdownBox"));

      Select select = new Select(tumKategoriler);

      select.selectByValue("search-alias=computers");

      // Bilgisayar kategorisi seçildiği kontrol edilir.
      Assert.assertTrue(tumKategoriler.getText().contains("Bilgisayarlar"));

      // Arama alanına msi yazılır ve arama yapılır.
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msi"+ Keys.ENTER);

      // Arama yapıldığı kontrol edilir.
      Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Aranan ürün')]")).getText().contains("Aranan"));

      //Arama sonuçları sayfasından 2. sayfa açılır.
      driver.findElement(By.xpath("(//a[@class='s-pagination-item s-pagination-button'])[1]")).click();

      // 2'inci sayfanın açıldığı kontrol edilir.
      Assert.assertTrue(driver.getCurrentUrl().endsWith("pg_2"));

      //Sayfadaki 2'inci ürün oluşturulan “Virgosol Liste” listesine eklenir.
      driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[2]")).click();

      driver.findElement(By.id("add-to-wishlist-button-submit")).click();

      // 2'inci Ürünün listeye eklendiği kontrol edilir.
      WebElement urunEklendi= driver.findElement(By.xpath("//span[contains(text(),'1 ürün şuraya eklendi')]"));

      Assert.assertTrue(urunEklendi.getText().contains("eklendi"));

      driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();

     //Hesabım  Alışveriş Listesi sayfasına gidilir.
      WebElement hesapVeListeler= driver.findElement(By.xpath("//span[contains(text(),'Hesap ve Listeler')]"));

      actions.sendKeys(Keys.PAGE_UP).perform();
      actions.sendKeys(Keys.PAGE_UP).perform();
      actions.sendKeys(Keys.PAGE_UP).perform();
      actions.sendKeys(Keys.PAGE_UP).perform();
      actions.sendKeys(Keys.PAGE_UP).perform();
      actions.sendKeys(Keys.PAGE_UP).perform();

      Thread.sleep(2000);

      jse.executeScript("arguments[0].click();", hesapVeListeler);

      Thread.sleep(10000);

      WebElement listeler= driver.findElement(By.xpath("//img[@alt='Listeleriniz']"));

     listeler.click();

     //“Alışveriş Listesi” sayfası açıldığı kontrol edilir.
      Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));

      //Eklenen ürün Virgosol Liste’sinden silinir.
      driver.findElement(By.name("submit.deleteItem")).sendKeys(Keys.ENTER);

      //Silme işleminin gerçekleştiği kontrol edilir.
      Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Silindi')]")).getText().contains("Silindi"));

      //Virgosol Liste'si silinir.
      WebElement dahaFazlası= driver.findElement(By.id("overflow-menu-popover-trigger"));
      jse.executeScript("arguments[0].click();", dahaFazlası);

      WebElement listeyiYönet = driver.findElement(By.id("editYourList"));

      jse.executeScript("arguments[0].click();", listeyiYönet);

      actions.sendKeys(Keys.PAGE_DOWN).perform();
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      actions.sendKeys(Keys.PAGE_DOWN).perform();

      WebElement listeyiSil= driver.findElement(By.xpath("//span[contains(text(),'Listeyi sil')]"));

      jse.executeScript("arguments[0].click();", listeyiSil);

      jse.executeScript("arguments[0].click();",driver.findElement(By.name("submit.save")));

      //Üye çıkış işlemi yapılır.
      WebElement hesaplar= driver.findElement(By.id("nav-link-accountList-nav-line-1"));

      actions.moveToElement(hesaplar)
              .perform();

      WebElement cikisYap= driver.findElement(By.xpath("//span[contains(text(),'Çıkış Yap')]"));

      jse.executeScript("arguments[0].click();",cikisYap );

      //Çıkış işleminin yapıldığı kontrol edilir.
      Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Giriş yap')]")).getText().contains("Giriş yap"));


    }
}
