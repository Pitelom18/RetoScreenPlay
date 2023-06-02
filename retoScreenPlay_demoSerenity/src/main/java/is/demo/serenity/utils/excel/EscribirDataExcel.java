package is.demo.serenity.utils.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class EscribirDataExcel {
    public static void addNewProduct(String filePath, String sheetName, Product product) {
        Workbook workbook;
        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        int lastRowNum = sheet.getLastRowNum();
        int newRowNum = lastRowNum + 1;

        Row newRow = sheet.createRow(newRowNum);
        newRow.createCell(1).setCellValue(product.getProductName());
        newRow.createCell(7).setCellValue(product.getUnitsInStock());
        newRow.createCell(8).setCellValue(product.getUnitsOnOrder());
        newRow.createCell(9).setCellValue(product.getReorderLevel());

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
