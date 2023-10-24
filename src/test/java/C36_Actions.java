import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C36_Actions extends TestBase {

    /*
Mouse Actions
click(): Geçerli konumu tıklamak için kullanılır.
doubleClick(): Fare konumuna çift tıklama gerçekleştirmek için kullanılır.
clickAndHold(): Fare tıklamasını serbest bırakmadan gerçekleştirmek için kullanılır.
contextClick(): Geçerli fare konumuna sağ fare tıklaması gerçekleştirmek için kullanılır.
moveToElement (WebElement target): Fare işaretçisini hedef konumun merkezine taşımak için kullanılır.
dragAndDrop(WebElement source, WebElement target): Öğeyi kaynaktan sürüklemek ve hedef konuma bırakmak için kullanılır.
dragAndDropBy(source, xOffset, yOffset): Bu yöntem, kaynak öğeyi tıklar ve tutar ve belirli bir ofset kadar hareket eder, ardından fareyi serbest bırakır. Ofsetler x & y ile tanımlanır.(X = Yatay Kaydır, Y= Dikey Kaydır)
release(): Geçerli konumdaki sol fare düğmesini serbest bırakmak için kullanılır.
perform(): Bir eylemi yürütür. Bu, bir eylemi gerçekleştirmek için sonunda kullanılmalıdır.
perform() KULLANMAYI UNUTMAYIN!
*/
    //Go to URL: https://demoqa.com/buttons
    //Run the buttons on the page using the Actions Class.
    //Verify the texts that appear after the buttons are operated.

    @Test
    public void test(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton= driver.findElement(By.id("doubleClickBtn"));

        WebElement rightClickButton= driver.findElement(By.id("rightClickBtn"));

        WebElement clickMeButton= driver.findElement(By.xpath("(//*[.='Click Me'])[2]"));

        Actions actions= new Actions(driver);

       // actions.doubleClick(doubleClickButton).perform();
       // actions.contextClick(rightClickButton).perform();
       // actions.click(clickMeButton).perform();
//
        actions.doubleClick(doubleClickButton)
                .contextClick(rightClickButton)
                .click(clickMeButton).perform();

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());

    }
}
