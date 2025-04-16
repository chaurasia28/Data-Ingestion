package com.ingestiontool.backend;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DataIngestionService {

    // Method to handle the flat file upload and process it
    public void flatFileToClickHouse(MultipartFile file) {
        try {
            // Use an absolute path to ensure the file is saved in the correct directory
            String uploadDir = "C:/Users/HP/clickhouse-ingestion-tool/backend/src/main/uploaded_files";  // Absolute path

            // Create the directory if it doesn't exist
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();  // Create the directory if it doesn't exist
            }

            // Specify the full file path
            String filePath = uploadDir + file.getOriginalFilename();
            File uploadedFile = new File(filePath);

            // Save the file to the directory
            file.transferTo(uploadedFile);

            // Call the ingestion logic to load the file into ClickHouse
            FlatFileToClickHouse flatFileToClickHouse = new FlatFileToClickHouse();
            flatFileToClickHouse.ingestDataToClickHouse(uploadedFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    public void ingestData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ingestData'");
    }
}
