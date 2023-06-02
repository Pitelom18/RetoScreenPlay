package is.demo.serenity.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ObtenerDataExcel {
    public static Object[][] getCredentials(String filePath, String sheetName) {
        Object[][] objects = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            objects = new Object[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    objects[i][j] = getCellValueAsString(cell);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    private static String getCellValueAsString(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            CellType cellType = CellType.forInt(cell.getCellType());
            switch (cellType) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        cellValue = dateFormat.format(cell.getDateCellValue());
                    } else {
                        cell.setCellType(CellType.STRING); // Convertir el valor numérico a cadena
                        cellValue = cell.getStringCellValue();
                    }
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = cell.getCellFormula();
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }
}
