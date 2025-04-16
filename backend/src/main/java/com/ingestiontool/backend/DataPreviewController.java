 package com.ingestiontool.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataPreviewController {

    @GetMapping("/dataPreview")
    public List<DataPreview> fetchUploadedFileData() {
        String filePath = "C:/Users/HP/clickhouse-ingestion-tool/backend/src/main/uploaded_files/uploaded_filestest_data.csv"; // Full path to your file

        List<DataPreview> fileData = new ArrayList<>();

        // Process CSV file
        if (filePath.endsWith(".csv")) {
            fileData = parseCsvFile(filePath);
        }

        return fileData;
    }

    private List<DataPreview> parseCsvFile(String filePath) {
        List<DataPreview> data = new ArrayList<>();
        File file = new File(filePath);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean firstLine = true; // Skip header line
                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false; // Skip the header row
                        continue;
                    }
                    String[] values = line.split(","); // Split CSV by comma

                    // Assuming the file has 3 columns (adjust as needed)
                    if (values.length == 3) {
                        String column1 = values[0].trim();
                        String column2 = values[1].trim();
                        String column3 = values[2].trim();

                        // Add data to the list of DataPreview objects
                        data.add(new DataPreview(column1, column2, column3));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}

class DataPreview {
    private String column1;
    private String column2;
    private String column3;

    public DataPreview(String column1, String column2, String column3) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
    }

    // Getters and Setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }
}

