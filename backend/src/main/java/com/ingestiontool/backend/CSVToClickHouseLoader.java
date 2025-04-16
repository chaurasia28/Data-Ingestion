package com.ingestiontool.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CSVToClickHouseLoader {

    public static void insertCSVToClickHouse(String filePath) {
        String url = "jdbc:clickhouse://localhost:8123/test_data";
        String user = "default";
        String password = "";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            reader.readLine(); // skip header line

            String insertQuery = "INSERT INTO test_data (id,name,created_at) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                pstmt.setString(1, parts[0].trim());
                pstmt.setString(2, parts[1].trim());
                pstmt.setString(3, parts[2].trim());
                pstmt.executeUpdate();
            }

            System.out.println("CSV data inserted into ClickHouse successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
