import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C33_WindowHandle1 extends TestBase {

    // driver.getWindowHandle(); -> aktif olan pencere ve sekmemizin window handle (id) degerini bize verir.
// driver.getWindowHandles(); -> tum pencere ve sekmelerin window handle (id) lerini bir Set olarak bize dondurur.
// driver.switchTo().window(id); -> window handle degeri id olan pencere veya sekmeye gecis yapmamizi saglar.
// driver.switchTo().newWindow(TAB); -> Yeni sekme olusturur.
// driver.switchTo().newWindow(WINDOW); -> Yeni pencere olusturur.

//Open browser
//Open https://www.amazon.com/ in the open tab
//Create new tab
//Open https://www.linkedin.com/ in the open tab
//Create new window
//Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

    }



}
