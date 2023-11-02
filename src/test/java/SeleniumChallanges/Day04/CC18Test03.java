package SeleniumChallanges.Day04;

import org.junit.Test;
import utilities.TestBase;

public class CC18Test03 extends TestBase {
 /*
  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
  ~ click on Phones & PDAs
  ~ get the brandName of phones
  ~ click on add to button for all elements
  ~ click on black total added cart button
  ~ get the names of list from the cart
  ~ compare the names from displaying list and cart list
   */

    @Test
    public void test(){
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");



    }
}
