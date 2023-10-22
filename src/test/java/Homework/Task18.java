package Homework;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task18 {
    /**https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
     Web sitesini maximize yapınız.
     İkinci emojiye tıklayınız.
     Tüm ikinci emoji öğelerine tıklayınız.
     Parent iframe geri dönünüz.
     Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button’a basınız.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        Faker faker = new Faker();

        driver.switchTo().frame("emoojis");

        WebElement secondEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();

        driver.switchTo().defaultContent();

        WebElement text = driver.findElement(By.xpath("//input[@id='text']"));
        text.sendKeys(faker.lordOfTheRings().character());

        WebElement smiles= driver.findElement(By.xpath("//input[@id='smiles']"));
        smiles.sendKeys(faker.lordOfTheRings().character());

        WebElement nature = driver.findElement(By.xpath("//input[@id='nature']"));
        nature.sendKeys(faker.lordOfTheRings().location());

        WebElement food = driver.findElement(By.xpath("//input[@id='food']"));
        food.sendKeys(faker.food().fruit());

        WebElement activities = driver.findElement(By.xpath("//input[@id='activities']"));
        activities.sendKeys(faker.harryPotter().spell());

        WebElement places = driver.findElement(By.xpath("//input[@id='places']"));
        places.sendKeys(faker.harryPotter().location());

        WebElement objects= driver.findElement(By.xpath("//input[@id='objects']"));
        objects.sendKeys(faker.backToTheFuture().character());

        WebElement symbols= driver.findElement(By.xpath("//input[@id='symbols']"));
        symbols.sendKeys(faker.food().vegetable());

        WebElement flags = driver.findElement(By.xpath("//input[@id='flags']"));
        flags.sendKeys(faker.gameOfThrones().city());

        WebElement enterTabs= driver.findElement(By.xpath("//input[@id='hide']"));
        enterTabs.sendKeys(faker.lordOfTheRings().character());

        WebElement defaultSmiles= driver.findElement(By.xpath("//input[@id='active']"));
        defaultSmiles.sendKeys(faker.lordOfTheRings().location());

        WebElement applyButton = driver.findElement(By.xpath("//button[@id='send']"));
        applyButton.click();








    }

    }
