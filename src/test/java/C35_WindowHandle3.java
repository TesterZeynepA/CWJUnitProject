import com.sun.source.doctree.SeeTree;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class C35_WindowHandle3 extends TestBase {

    // 1- browser ac
    // 2- acilan sekmede https://www.amazon.com/ ac
    // 3- yeni sekme olustur
    // 4- acilan sekmede https://www.linkedin.com/ ac
    // 5- yeni pencere olustur
    // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

    @Test
    public void test(){

        driver.get("https://www.amazon.com/");
        String amazonHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.linkedin.com/");
        String linkedHandle= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String opensourceHandle = driver.getWindowHandle();

     /*   driver.switchTo().window(amazonHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Amazon sekmesini buldun");*/

        //2. yol

        //window handle ler arasi gecis yapmamiz gerek
        //set objesi olusturmaliyiz..
       // Set<String> windowHandles = driver.getWindowHandles();
        //set uzerinde gezecegim bir objesi olmadigindan iterator kullancagiz

        //window handle ler arasi gecis yapmamiz gerek
        //set objesi olusturmaliyiz..
        Set<String> windowHandles = driver.getWindowHandles();

        //set uzerinde gezecegim bir objesi olmadigindan iterator kullancagiz
        Iterator<String> itr= windowHandles.iterator();

        while (itr.hasNext()){//itr.hasNext() ifadesi , itr isimli bir nesnenin bir sonraki elemani olup olmadigini kontrol eder
            String currentHandle=itr.next();//itr.next() ifadesi , i isimli bir nesnenin bir sonraki elemani bu degiskene atamaktadir.
            driver.switchTo().window(currentHandle);
            System.out.println(driver.getWindowHandle());//3 farkli WH degeri gormeliyiz

            if (driver.getTitle().toLowerCase().contains("amazon")){
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Amazon sekmesini buldun BRAVO");
                break;
            }
        }
    }

}
