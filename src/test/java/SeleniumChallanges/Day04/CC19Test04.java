package SeleniumChallanges.Day04;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CC19Test04 extends TestBase {
      /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("//button[@class='dt-button buttons-create']")).click();

        Faker faker= new Faker();

        String firstName = faker.harryPotter().character();

        String lastName = faker.harryPotter().character();

        driver.findElement(By.id("DTE_Field_first_name")).sendKeys(firstName);

        driver.findElement(By.id("DTE_Field_last_name")).sendKeys(lastName);

        driver.findElement(By.id("DTE_Field_position")).sendKeys(faker.harryPotter().location());

        driver.findElement(By.id("DTE_Field_office")).sendKeys(faker.lordOfTheRings().location());

        driver.findElement(By.id("DTE_Field_extn")).sendKeys(faker.harryPotter().spell());

        driver.findElement(By.id("DTE_Field_start_date")).sendKeys("2023-11-02");

        driver.findElement(By.id("DTE_Field_salary")).sendKeys("50000");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn']")).click();

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(firstName," ", lastName);

        WebElement NameIlk = driver.findElement(By.xpath("//td[@class='sorting_1']"));
        Assert.assertEquals(NameIlk.getText(), firstName + " " + lastName);
        NameIlk.click();

        driver.findElement(By.xpath("//button[@class='dt-button buttons-selected buttons-remove']")).click();

        driver.findElement(By.xpath("//div[@class='DTE_Form_Buttons']")).click();

        WebElement basariliDelete=driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        Assert.assertEquals("No matching records found", basariliDelete.getText());





    }
}
