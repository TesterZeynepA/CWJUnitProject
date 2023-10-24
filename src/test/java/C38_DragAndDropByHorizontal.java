import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C38_DragAndDropByHorizontal extends TestBase {
    //Go to URL: https://rangeslider.js.org/
    //Shift 100 units to the right and 100 units to the left on the horizontal axis.


    @Test
    public void test(){
        driver.get("https://rangeslider.js.org/");
        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.cssSelector("div.rangeslider__handle"));

        actions
                .dragAndDropBy(slider,100,0)
                .perform();

        WebElement output = driver.findElement(By.id("js-output"));
        System.out.println(output.getText());

        actions
                .dragAndDropBy(slider,-100,0)
                .perform();

        System.out.println(output.getText());
    }
}
