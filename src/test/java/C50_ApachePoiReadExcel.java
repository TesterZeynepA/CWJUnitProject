import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C50_ApachePoiReadExcel {
    //Workbook  Excel dosyamız.
    //Sheet  Açık excel sekmesi (Sheet1, Sheet2, etc.)
    //Row (Satır)  Java, yalnızca içeride veri varsa satırları sayar.
    //Cells (Hücre)  Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar.

    //workbook(excel)>worksheet(sheet)> row(satir)>cell(hucre) -> hiyerarsi

    // Add the excel file on the resources folder.
    // Open the file.
    // Open the workbook using file input stream.
    // Open the first worksheet.
    // Go to first row.
    // Go to first cell on that first row and print.
    // Go to second cell on that first row and print.
    // Go to 2nd row first cell and assert if the data equal to Russia.
    // Go to 3rd row and print 2nd cell
    // Find the number of used row.
    // Print country, area key value pairs as map object.
    // Verify that you have Türkiye on the list

    @Test
    public void test() throws IOException {
        //C:\Users\zeyne\IdeaProjects\CWJUnitProject\src\test\resources\excelfile.xlsx

        String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet1 = wb.getSheet("Sayfa1");
        Sheet sheet2 = wb.getSheetAt(0);
        Row row1 = sheet1.getRow(0);
        Cell cell = row1.getCell(0);

        System.out.println("cell = " + cell);
        System.out.println("cell = " + cell.toString());

        Cell cell2 = row1.getCell(1);

        System.out.println("cell2 = " + cell2);

        Assert.assertEquals("Rusya",sheet1.getRow(1).getCell(0).toString());

        Row row3 = sheet2.getRow((2));

        Cell r3c2= row3.getCell(1);
        System.out.println("r3c2 = " + r3c2);

        System.out.println("sheet2.getRow(2).getCell(1).toString() = " + sheet2.getRow(2).getCell(1).toString());

        System.out.println((sheet1.getLastRowNum() + 1));
        System.out.println(sheet1.getPhysicalNumberOfRows());

    }





}
