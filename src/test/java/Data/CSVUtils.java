package Data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static List<String[]> readCSV(String filePath) throws  CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> csvData = new ArrayList<>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            csvData.add(nextLine);
        }
        reader.close();
        return csvData;
    }
}
