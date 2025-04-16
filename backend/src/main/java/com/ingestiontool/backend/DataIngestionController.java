package com.ingestiontool.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DataIngestionController {

    @Autowired
    private DataIngestionService dataIngestionService;

    // Example endpoint to test the server
    @GetMapping("/")
    public String welcome() {
        return "Welcome to ClickHouse and Flat File Ingestion Tool!";
    }

    // Endpoint to trigger the data ingestion process
    @PostMapping("/ingestData")
    public String ingestData() {
        // Call the service to handle ingestion logic
        dataIngestionService.ingestData();
        return "Ingestion process started!";
    }
    @PostMapping("/uploadFlatFile")
    public String uploadFlatFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "No file selected!";
        }
        
        try {
            // Logic to handle the file and process it (e.g., loading it into ClickHouse)
            dataIngestionService.flatFileToClickHouse(file);
            return "Flat file upload to ClickHouse started!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while uploading the file: " + e.getMessage();
        }
    }
    
    
}
