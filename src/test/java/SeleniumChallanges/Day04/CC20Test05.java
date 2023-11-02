package SeleniumChallanges.Day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CC20Test05 extends TestBase {
//1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın

    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Actions");

        Actions actions = new Actions(driver);

        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//div[@class='dropdown hover']"));

        WebElement link1= driver.findElement(By.xpath("(//div[@class='dropdown-content']//a)[1]"));
        actions.moveToElement(hoverOverMeFirst).click(link1)
                .perform();

        System.out.println(driver.switchTo().alert().getText());

        Assert.assertEquals("Well done you clicked on the link!", driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        WebElement clickAndHoldKutusu = driver.findElement(By.id("click-box"));

        actions.clickAndHold(clickAndHoldKutusu).perform();

        System.out.println(clickAndHoldKutusu.getText());

        WebElement doubleClickMe= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMe).perform();

        Assert.assertEquals("div-double-click double",doubleClickMe.getAttribute("class"));

    }
}
