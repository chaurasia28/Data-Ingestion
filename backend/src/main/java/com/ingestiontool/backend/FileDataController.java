package com.ingestiontool.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileDataController {

    // Assuming your uploaded files are in the 'uploads' directory
    private static final String UPLOAD_DIR = "C:/Users/HP/clickhouse-ingestion-tool/backend/src/main/uploaded_files/";    // Change this path as needed

    @GetMapping("/fetchUploadedFileData")
    public List<String[]> getUploadedFileData() {
        List<String[]> fileData = new ArrayList<>();
        File uploadedFile = new File(UPLOAD_DIR + "/uploaded_filestest_data.csv"); // Replace with the actual uploaded file name

        // Check if the file exists
        if (uploadedFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(uploadedFile))) {
                String line;
                // Read the CSV file line by line
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(","); // Assuming CSV is comma-separated
                    fileData.add(data); // Add each row to the list
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileData;
    }
}
