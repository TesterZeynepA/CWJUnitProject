package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task32 extends TestBase {

    //Go to URL: https://the-internet.herokuapp.com/tables
    //Print the entire table
    //Print All Rows
    //Print Last row data only
    //Print column 5 data in the table body
    //Write a method that accepts 2 parameters
    //parameter 1 = row number  parameter 2 = column number
    //printData(3,4); => prints
    //Write a method that accepts 3 parameters, parameter 3 = table id
    //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    @Test
    public void test() {
        //Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print the entire table
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        int satirNumber = table1.findElements(By.xpath(".//tr")).size();
        int sutunNumber = table1.findElements(By.xpath(".//tr[1]//td")).size();
        for (int i = 1; i < +satirNumber; i++) {

            for (int j = 1; j <= sutunNumber; j++) {

                String cellValue = table1.findElement(By.xpath(".//tr[" + i + "]//td[" + j + "]")).getText();
                System.out.print(cellValue + " ");
            }
            System.out.println();
            System.out.println("-----------------------------------------------------");
        }
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print All Rows
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table1.findElement(By.xpath(".//tr[1]")).getText());

        int satir = table1.findElements(By.xpath(".//tbody//tr")).size();

        for (int i = 1; i <= satir; i++) {

            String rows = table1.findElement(By.xpath(".//tbody//tr[" + i + "]")).getText();
            System.out.println(rows + " ");

        }
        System.out.println();

        System.out.println("------------------");

        //Print Last row data only
        System.out.println(table1.findElement(By.xpath(".//tr[4]")).getText());

        System.out.println("------------------");

        //Print column 5 data in the table body
        System.out.println(table1.findElement(By.xpath(".//tbody//tr//td[5]")).getText());

        System.out.println("------------------");
        //Write a method that accepts 2 parameters
        //parameter 1 = row number  parameter 2 = column number
        //printData(3,4); => prints

        System.out.println(printData(table1, 3, 4));

        System.out.println("------------------");

        //Write a method that accepts 3 parameters, parameter 3 = table id
        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

        System.out.println(printData2(table1, 3, 4, "table1"));


    }

    private String printData2(WebElement table, int row, int column, String tableId) {

        WebElement table2 = driver.findElement(By.id(tableId));

        WebElement cell = table2.findElement(By.xpath( ".//tr[" + row + "]//td[" + column + "]"));
        return cell.getText();
    }

    public String printData(WebElement table, int rowNumber, int columnNumber) {
        By locator = By.xpath(".//tr[" + rowNumber + "]//td[" + columnNumber + "]");
        WebElement cell = table.findElement(locator);
        return cell.getText();
    }
}
