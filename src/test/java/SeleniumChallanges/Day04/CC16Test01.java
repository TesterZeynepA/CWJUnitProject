package SeleniumChallanges.Day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CC16Test01 extends TestBase {
    /*
1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  "username" yazdirin
4. Password alanine "password" yazdirin
5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
6. Online Banking menusunden Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina "2020-09-10" yazdirin
9. Pay buttonuna tiklayin
10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
*/

    @Test
    public void test(){

        driver.get("http://zero.webappsecurity.com");

        WebElement signInButton= driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButton.click();

        WebElement login= driver.findElement(By.id("user_login"));
        login.sendKeys("username");

        WebElement password= driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        WebElement signButton= driver.findElement(By.xpath("//input[@name='submit']"));
        signButton.click();

        driver.navigate().back();

        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.id("sp_amount")).sendKeys("500");

        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        driver.findElement(By.id("sp_description")).submit();

        Assert.assertEquals("The payment was successfully submitted.",driver.findElement(By.xpath("//span[.='The payment was successfully submitted.']")).getText());

    }
}
