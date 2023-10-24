import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C37_MouseActions extends TestBase {

    // Go to URL: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @Test
    public void test(){

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions = new Actions(driver);

        WebElement boxOslo= driver.findElement(By.id("box1"));
        WebElement boxStockholm= driver.findElement(By.id("box2"));
        WebElement boxWashington= driver.findElement(By.id("box3"));
        WebElement boxCophenhagen= driver.findElement(By.id("box4"));
        WebElement boxSeoul= driver.findElement(By.id("box5"));
        WebElement boxRome= driver.findElement(By.id("box6"));
        WebElement boxMadrid= driver.findElement(By.id("box7"));

        WebElement NorwayBox = driver.findElement(By.id("box101"));
        WebElement SwedenBox = driver.findElement(By.id("box101"));
        WebElement UnitedStatesBox = driver.findElement(By.id("box101"));
        WebElement DenmarkBox = driver.findElement(By.id("box101"));
        WebElement NorthKoreaBox = driver.findElement(By.id("box101"));
        WebElement ItalyBox = driver.findElement(By.id("box101"));
        WebElement SpainBox = driver.findElement(By.id("box101"));

        actions.dragAndDrop(boxOslo,NorwayBox)
                .dragAndDrop(boxStockholm,SwedenBox)
                .dragAndDrop(boxWashington,UnitedStatesBox)
                .dragAndDrop(boxCophenhagen,DenmarkBox)
                .dragAndDrop(boxSeoul,NorthKoreaBox)
                .dragAndDrop(boxRome,ItalyBox)
                .dragAndDrop(boxMadrid,SpainBox)
                .perform();

        //2. yol
       // actions.moveToElement(boxWashington).clickAndHold().moveToElement(UnitedStatesBox).release().perform();

    }

}
