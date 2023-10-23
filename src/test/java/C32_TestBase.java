import org.junit.Test;
import utilities.TestBase;

public class C32_TestBase extends TestBase {

    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/iframe");

        System.out.println(driver.getTitle());//The Internet
    }

    @Test
    public void test2(){

        driver.get("https://www.amazon.com./");
        System.out.println(driver.getTitle());//Amazon.com. Spend less. Smile more.

    }

    @Test
    public void test3(){

        driver.get("https://www.google.com./");

        System.out.println(driver.getTitle());//Google
    }

}
