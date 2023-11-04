package Homework;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task30 {

    //Store the path of the file as string and open the file.
    //Open the workbook.
    //Open the first worksheet.
    //Go to the first row.
    //Create a cell on the 3rd column (2nd index) on the first row.
    //Write "POPULATION" on that cell.
    //Create a cell on the 2nd row 3rd cell(index2), and write data.
    //Create a cell on the 3rd row 3rd cell(index2), and write data.
    //Create a cell on the 4th row 3rd cell(index2), and write data.
    //Write and save the workbook.
    //Close the file.
    //Close the workbook.

//dosya bu clasttan once 3. sutun temiz olmalı.. ilk calıstırıldıgında yazar..
// 2. kez calıstırılınca uzerine yazar, hata vermez

     @Test
    public void test() throws IOException {
         //C:\Users\zeyne\IdeaProjects\CWJUnitProject\src\test\resources\homework-30.xlsx

         String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\homework-30.xlsx";

         FileInputStream fis = new FileInputStream(path);

         Workbook wb = WorkbookFactory.create(fis);

         Sheet sheet = wb.getSheet("Sheet1");
         Row row = sheet.createRow(0);
         Cell r1c3= row.createCell(2);
         r1c3.setCellValue("POPULATION");

         Row row2 = sheet.createRow(1);
         Cell r2c3= row2.createCell(2);
         r2c3.setCellValue("data");

         sheet.createRow(2).createCell(2).setCellValue("data");

         sheet.createRow(3).createCell(2).setCellValue("data");

         FileOutputStream fos = new FileOutputStream(path);
         wb.write(fos);

         wb.close();
         fis.close();
         fos.close();

    }
}
