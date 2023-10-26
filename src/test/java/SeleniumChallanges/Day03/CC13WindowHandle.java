package SeleniumChallanges.Day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CC13WindowHandle extends TestBase {

    // Step 1: Go to the URL https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
    // Step 2: Switch to the iframe containing the "Try it" button
    // Locate and click the "Try it" button
    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle

 /*
Bu kod, tüm pencere kollarını içeren bir küme içinden, orijinal pencereye geri dönüş yapar.
driver.getWindowHandles().iterator().next() ifadesi, tüm pencere kollarını içeren kümenin ilk elemanını alır,
bu da genellikle orijinal pencereye karşılık gelir. Bu şekilde, orijinal pencereye dönülür ve orada işlemlere devam edilebilir.
Bu kod parçası, bir web sayfasındaki iframe'den ana pencereye geçmek ve ardından yeni bir pencereye geçiş yapmak için kullanılır.

*/
    @Test
    public void test(){

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        driver.switchTo().frame("iframeResult");

       By TryItButton = By.xpath("//button[text()='Try it']");
        clickElement(TryItButton);


        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
            String newTitle=driver.getTitle();
            System.out.println("newTitle = " + newTitle);
            String newURL = driver.getCurrentUrl();
            System.out.println("newURL = " + newURL);
        }
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println(" Son Title= "+driver.getTitle());

    }

}
