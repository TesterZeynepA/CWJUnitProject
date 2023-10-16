import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C13_AbsoluteRelative {

   /** Go to URL: https://opensource-demo.orangehrmlive.com/
    Locate the username, password, login button using absolute xpath and relative xpath.
*/

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void absoluteXPath(){
        WebElement username= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement passwordBox= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        WebElement loginButton= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

    }


    @Test
    public void relativeXPath() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));

    }


    @AfterClass
    public static void tearDown(){

        driver.close();
    }


}
