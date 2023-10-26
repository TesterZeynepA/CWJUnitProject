import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C45_Cookies extends TestBase {

    //***Cookie cookie  = driver.manage().cookie-methods
    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    // Get Cookie.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.
    @Test
    public void test1() {

        driver.get("https://kitchen.applitools.com/ingredients/cookie");

       Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println(c);
        }

        System.out.println("************************");
        System.out.println(driver.manage().getCookieNamed("protein"));

        Assert.assertEquals("chicken", driver.manage().getCookieNamed("protein").getValue());

        System.out.println("******************************");

        System.out.println(allCookies.size());

        Cookie cookie = new Cookie("kalsiyum","süt");
        driver.manage().addCookie(cookie);

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println(c);
        }

        System.out.println("************************");

        Cookie cookie2 = new Cookie("vegetable","cucumber");
        driver.manage().addCookie(cookie2);

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println(c);
        }

        System.out.println("************************");

        driver.manage().deleteCookie(cookie2);

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println(c);
        }

        System.out.println("************************");

        driver.manage().deleteAllCookies();
        System.out.println("************************");

    }
}
