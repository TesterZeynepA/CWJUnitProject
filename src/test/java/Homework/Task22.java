package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Task22 extends TestBase {
  //  C35. classdaki set ve iterator ile yapılan çözümü list ile yapınız.

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

            List<String> handlesList = new ArrayList<>(driver.getWindowHandles());

        for (int i = 0; i <handlesList.size(); i++) {
            String currentHandle= handlesList.get(i);

            if (handlesList.get(i).equals(amazonHandle))
            driver.switchTo().window(currentHandle);
            System.out.println(driver.getWindowHandle());

            if (driver.getTitle().toLowerCase().contains("amazon")){
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Amazon sekmesini buldun BRAVO");
                break;
            }

        }


    }

}

