import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C58_Log4j extends TestBase {
    //Go to URL: https://healthunify.com/bmicalculator/
    //Entring weight
    //Selecting kilograms
    //Selecting height in feet
    //Selecting height in inchs
    //Clicking on calculate
    //Getting SIUnit value
    //Getting USUnit value
    //Getting UKUnit value
    //Getting overall description

    @Test
    public void test(){
        //loglarımızı configure etmek için
        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C58_Log4j.class);

        logger.info("Go to URL");
        driver.get("https://healthunify.com/bmicalculator/");

        logger.info("Entring weight");
        WebElement weight = driver.findElement(By.xpath("//input[@name='wg']"));
        weight.sendKeys("63");

        logger.info("Selecting kilograms");
        Select select = new Select(driver.findElement(By.name("opt1")));
        select.selectByValue("kilograms");

        logger.info("Selecting height in feet");
        Select select1 = new Select(driver.findElement(By.name("opt2")));
        select1.selectByValue("1");

        logger.info("Selecting height in inchs");
        Select select2 = new Select(driver.findElement(By.name("opt3")));
        select2.selectByValue("6");

        logger.info("Clicking on calculate");
        WebElement calculate = driver.findElement(By.xpath("//input[@name='cc']"));
        calculate.sendKeys(Keys.SPACE);

        logger.info("Getting SIUnit value");
        WebElement siUnit = driver.findElement(By.xpath("//input[@name='si']"));
        System.out.println(siUnit.getAttribute("value"));

        logger.info("Getting USUnit value");
        WebElement usUnit = driver.findElement(By.xpath("//input[@name='us']"));
        System.out.println(usUnit.getAttribute("value"));

        logger.info("Getting UKUnit value");
        WebElement ukUnit = driver.findElement(By.xpath("//input[@name='uk']"));
        System.out.println(ukUnit.getAttribute("value"));

        logger.info("Getting overall description");
        WebElement description = driver.findElement(By.xpath("//input[@name='desc']"));
        System.out.println(description.getAttribute("value"));

    }
}
