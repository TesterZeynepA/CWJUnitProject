package SeleniumChallanges.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CC14DragAndDrop extends TestBase {

    /*
  web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
"draggable" elementini sürükleyerek sağa doğru 100 piksel hareket ettirin, ardından sola, yukarı ve aşağı yönlere sırasıyla 100 piksel hareket ettirin.
sürükle ve bırak işlemi sonrasında, "draggable" elementinin yeni konumunu alın ve başlangıç konumuyla karşılaştırın.
Eğer başlangıç konumuyla aynıysa, bu adım başarılı kabul edilir.
"draggable" elementini "target" elementine sürükleyin.
"draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.
*/



    @Test
    public void test(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        Point firstLocation = driver.findElement(By.id("draggable")).getLocation();
        Actions actions= new Actions(driver);
        actions.dragAndDropBy(draggable,100,0)
                .dragAndDropBy(draggable,0,100)
                .dragAndDropBy(draggable,-100,0)
                .dragAndDropBy(draggable,0,-100).perform();

        Assert.assertEquals(firstLocation, draggable.getLocation());

        WebElement target = driver.findElement(By.id("target"));
        actions.dragAndDrop(draggable,target).perform();

        Assert.assertEquals(target.getLocation(),draggable.getLocation());

    }
    @Test
    public void test2() throws InterruptedException {

         /*
        Coding assignment:
URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
UC -1 : +ve
Drag all the capitals to the respective country section.ex:
Oslo  to  Norway
Washington to United States
--- move all the capitals back to the capitals left section
UC - 2 Drag all the capitals to the wrong countries
Washington  to  South Korea
--- move all the capitals back to the capitals left section
UC -3 : correct + incorrect combinations
Oslo - Norway
Madrid  to  Sweden
--- move all the capitals back to the capitals left section
        */
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

        ////test case -01
  //     actions.dragAndDrop(boxOslo,NorwayBox).
  //             dragAndDrop(boxStockholm,SwedenBox).
  //             dragAndDrop(boxWashington,UnitedStatesBox).
  //             dragAndDrop(boxCophenhagen,DenmarkBox)
  //             .dragAndDrop(boxSeoul,NorthKoreaBox)
  //             .dragAndDrop(boxRome,ItalyBox)
  //             .dragAndDrop(boxMadrid,SpainBox).perform();
  //     Assert.assertEquals("visibility: visible; background-color: rgb(0, 255, 0);", boxRome.getAttribute("style"));
////test case -02
 //       actions.dragAndDrop(boxOslo,NorwayBox).
 //               dragAndDrop(boxStockholm,SwedenBox).
 //               dragAndDrop(boxWashington,NorthKoreaBox).
 //               dragAndDrop(boxCophenhagen,DenmarkBox)
 //               .dragAndDrop(boxSeoul,UnitedStatesBox)
 //               .dragAndDrop(boxRome,ItalyBox)
 //               .dragAndDrop(boxMadrid,SpainBox).perform();
 //       Assert.assertEquals("visibility: visible;",boxWashington.getAttribute("style"));
      actions.dragAndDrop(boxOslo,SwedenBox).
              dragAndDrop(boxStockholm,SpainBox).
              dragAndDrop(boxWashington,DenmarkBox).
              dragAndDrop(boxCophenhagen,NorthKoreaBox)
              .dragAndDrop(boxSeoul,ItalyBox)
              .dragAndDrop(boxRome,UnitedStatesBox)
              .dragAndDrop(boxMadrid,NorwayBox).perform();
      Assert.assertEquals("visibility: visible;",boxWashington.getAttribute("style"));
      Assert.assertEquals("visibility: visible;",boxCophenhagen.getAttribute("style"));
      Assert.assertEquals("visibility: visible;",boxSeoul.getAttribute("style"));
      Assert.assertEquals("visibility: visible;",boxRome.getAttribute("style"));
      Assert.assertEquals("visibility: hidden;",boxMadrid.getAttribute("style"));
      Thread.sleep(3000);
    }
}





