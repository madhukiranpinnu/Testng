package TestNg;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Dataproviderexcel {
    @DataProvider(name = "Excel")
    @Test
    public Object[][] dataExcel() throws IOException {
        File exc = new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\resources\\Datasupplier.xlsx");
        System.out.println(exc.exists());
        FileInputStream fileInputStream = new FileInputStream(exc);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getLastRowNum());
        int rowCount = sheet.getPhysicalNumberOfRows();
        int cellCount = sheet.getRow(0).getLastCellNum();
        System.out.println(cellCount);
        Object[][] object = new Object[rowCount-1][cellCount];
        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < cellCount; j++) {
                System.out.println(i);
                System.out.println(j);
                DataFormatter dataFormatter = new DataFormatter();
                String s = dataFormatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
                object[i][j] = s;
                System.out.println(s);
            }
            System.out.println();
        }
        workbook.close();
        fileInputStream.close();
        return object;
    }
}
