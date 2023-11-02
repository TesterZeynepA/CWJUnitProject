package SeleniumChallanges.Day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CC17Test02 extends TestBase {
    //1. "https://www.saucedemo.com" Adresine gidin
    //2. Username kutusuna "standard_user" yazdirin
    //3. Password kutusuna "secret_sauce" yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    @Test
    public void test(){

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        WebElement IlkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
        String IlkUrunText=IlkUrun.getText();

        System.out.println("IlkUrunText = " + IlkUrunText);
        IlkUrun.click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        WebElement sepetUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("sepetUrun = " + sepetUrun.getText());
        Assert.assertEquals(IlkUrunText, sepetUrun.getText());
    }

}

