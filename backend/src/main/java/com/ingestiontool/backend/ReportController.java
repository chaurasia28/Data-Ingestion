package com.ingestiontool.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Backend - ReportController.java
@RestController
public class ReportController {

    @GetMapping("/report")
    public Report generateReport() {
        // Logic to generate the report
        Report report = new Report("Sample Report", 100);
        return report;
    }

    // Example report class
    public static class Report {
        private String title;
        private int dataCount;

        public Report(String title, int dataCount) {
            this.title = title;
            this.dataCount = dataCount;
        }

        // Getters and setters
    }
}
