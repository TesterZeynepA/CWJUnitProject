import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_BeforeClassAfterClass {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        System.out.println("Before class methodu çalıştı.");

    }

    @AfterClass
    public static void tearDown(){

        driver.close();

        System.out.println("After class methodu çalıştı.");

    }

    @Test
    public void test01(){

       driver.get("http://www.n11.com/");
        System.out.println("test 01 çalıştı.");

    }

    @Test
    public void test02(){

        driver.get("http://amazon.com/");
        System.out.println("Test 02 çalıştı.");

    }


}
