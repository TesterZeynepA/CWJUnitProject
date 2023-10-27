package Homework;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Task26 extends TestBase {

     /*
        Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */

    @Test
    public void test(){

        driver.get("http://facebook.com");

        Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println("Cookie= "+c);
        }

        System.out.println(allCookies.size());

        System.out.println("******************");
         Cookie cookie = new Cookie("AzeS", "BuYeniCookie:!");

         driver.manage().addCookie(cookie);

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println("Cookie= "+c);
        }
        System.out.println(allCookies.size());
        System.out.println("****************************");

        driver.manage().deleteCookieNamed("_js_datr");

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println("Cookie= "+c);
        }
        System.out.println(allCookies.size());


        System.out.println("****************************");

        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println("Cookie= "+c);
        }
        System.out.println(allCookies.size());

        System.out.println("****************************");

        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {

            System.out.println("Cookie= "+c);
        }
        System.out.println(allCookies.size());

        System.out.println("****************************");

    }
}
