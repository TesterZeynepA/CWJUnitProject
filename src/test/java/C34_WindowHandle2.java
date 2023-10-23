import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C34_WindowHandle2 extends TestBase {

    // 1- browser ac
    // 2- yeni sekme olustur
    // 3- yeni pencere olustur
    // 4- 2. sekmede https://www.linkedin.com/ ac
    // 5- son pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 6- Ilk sekmede https://www.amazon.com/ ac

    @Test
    public void test() throws InterruptedException {

       String windowHandleMain= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        String windowHandleTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        String windowHandleWindow = driver.getWindowHandle();

        driver.switchTo().window(windowHandleTab);
        driver.get("https://www.linkedin.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        driver.switchTo().window(windowHandleWindow);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        driver.switchTo().window(windowHandleMain);
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());


    }
}
