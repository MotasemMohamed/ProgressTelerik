package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {
        String filePath = System.getProperty("user.dir") +"//src//test//java//Data//UserData.xlsx";
        File srcfile = new File(filePath);
        try {
            fis = new FileInputStream(srcfile);
        } catch (FileNotFoundException e) {
            System.out.println("Test data file not found.");
            System.exit(0);
        }
        return fis;
    }

    public Object[][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int totalNumberOfRow = (sheet.getLastRowNum() + 1);
        int TotalNumberOfCols = 1;
        String[][] arrayExcelData = new String[totalNumberOfRow][TotalNumberOfCols];
        for (int i = 0; i < totalNumberOfRow; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;
    }
}
